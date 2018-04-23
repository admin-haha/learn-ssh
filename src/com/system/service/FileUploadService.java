package com.system.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.excel.utils.ImportExcelToObject;
import com.system.po.Users;
import com.system.utils.GsonUtils;


/** 
 * 文件上传service
 * @author haohao 
 * @date 2018年1月26日 
 */
@Component
public class FileUploadService {

	private Logger logger = LoggerFactory.getLogger(FileUploadService.class);
	@Autowired
	private UserService userService;
	
	/**
	 * 上传文件
	 * @param request
	 * @param fileType  文件类型
	 * @param filePath  文件路径     缺省：默认路径
	 * @param fileName  文件名称     缺省：自动生成
	 * @return
	 * @throws FileUploadException 
	 * @throws IOException 
	 */
	public String[] uploadFile(HttpServletRequest request,String filePath,String fileName) throws FileUploadException, IOException{
		logger.info("【上传文件】开始======");
		String[] filePaths = new String[]{};
		try{
			//校验是否支持文件上传    Content-Type: multipart/form
			if(!ServletFileUpload.isMultipartContent(request)){
				throw new RuntimeException("当前请求不支持文件上传！");
			}
			
			//获取工厂类
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();

			//核心处理类
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			
			//设置编码
			fileUpload.setHeaderEncoding("UTF-8");
			
			//解析request 获取fileItem集合
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			
			//便利结合  解析数据
			for(FileItem item:fileItems){
				//跳过普通的表单元素
				if(!item.isFormField()){
					//上传文件名称
					String uploadFileName = item.getName();
					logger.info("【上传文件】原文件名："+uploadFileName);
					//兼容浏览器
					uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
					
					//获取文件扩展名
					String fileNameExt = uploadFileName.substring(uploadFileName.lastIndexOf("."));
					
					//获取文件内容
					BufferedInputStream bufferedInputStream = new BufferedInputStream(item.getInputStream());
					
					//保存文件的名称
					Workbook workbook = null;
					if (fileNameExt.endsWith(".xls")) {
						// 对于03~07版本的excel
						workbook = new HSSFWorkbook(bufferedInputStream);
					} else if (fileNameExt.endsWith(".xlsx")) {
						// 对于03~07版本以后版本的excel
						workbook =new XSSFWorkbook(bufferedInputStream);
					}
					
					if(workbook!=null) {
						ImportExcelToObject importExcelToObject = new ImportExcelToObject();
						HashMap<Integer, String> mapping = new HashMap<Integer, String>();
						mapping.put(0, "name");
						mapping.put(1, "gender");
						mapping.put(2, "collegeId");
						mapping.put(3, "departmentId");
						mapping.put(4, "mobile");
						importExcelToObject.setMapping(mapping);
						importExcelToObject.setDatePattern("yyyy-MM-dd");
						importExcelToObject.setStartRow(1);
						List<Users> datas = importExcelToObject.importExcelFromWorkBook(workbook, Users.class);
						logger.info("【人员导入】 导入数据："+GsonUtils.getGson().toJson(datas));
						
						userService.batchSave(datas);
					}
					
					//删除临时文件
					item.delete();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("【上传文件】结束======    返回值："+StringUtils.join(filePaths));
		return filePaths;
	}
	
	
}
