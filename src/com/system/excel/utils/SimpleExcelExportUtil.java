package com.system.excel.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.system.excel.enums.CellStyleType;
import com.system.excel.vo.BaseExportVo;
import com.system.excel.vo.ExcelCellStyle;
import com.system.utils.StringKit;

/** 
 * Excel导出工具类
 * @date 2018年2月2日 
 */
@Component
public class SimpleExcelExportUtil {
	
	private Map<CellStyleType,CellStyle> cellStyleMap = new HashMap<>();
	
	@SuppressWarnings("rawtypes")
	public Workbook exportOnlyHeader(Workbook workbook,String sheetName,String fileName,BaseExportVo baseExportVo,Integer rowIndex) throws Exception{
		//行序号
		rowIndex = StringKit.toInt(rowIndex);
		
		//创建工作簿
		if(workbook==null){
			workbook = createWorkbook(fileName);
		}
		//创建sheet
		Sheet sheet = workbook.getSheet(sheetName);
		if(sheet==null){
			sheet = workbook.createSheet(sheetName);
		}
		
		if(rowIndex<0){
			rowIndex = sheet.getLastRowNum()+1;
		}
		
		//初始化样式
		//initCellStyleMap(cellStyleMap, workbook);
		
		//初始化导出数据
		if(baseExportVo!=null){
			baseExportVo.init();
			//创建标题行
			rowIndex = createHeader(workbook,sheet,baseExportVo,rowIndex);
		}
		
		return workbook;
	}
	
	@SuppressWarnings("rawtypes")
	public Workbook export(Workbook workbook,String sheetName,String fileName,BaseExportVo baseExportVo,Integer rowIndex) throws Exception{
		//行序号
		rowIndex = StringKit.toInt(rowIndex);
		
		//创建工作簿
		if(workbook==null){
			workbook = createWorkbook(fileName);
		}
		//创建sheet
		Sheet sheet = workbook.getSheet(sheetName);
		if(sheet==null){
			sheet = workbook.createSheet(sheetName);
		}
		
		if(rowIndex<0){
			rowIndex = sheet.getLastRowNum()+1;
		}
		
		//初始化样式
		//initCellStyleMap(cellStyleMap, workbook);
		
		//初始化导出数据
		if(baseExportVo!=null){
			baseExportVo.init();
			//创建标题行
			rowIndex = createHeader(workbook,sheet,baseExportVo,rowIndex);
			
			fillDatas(workbook,sheet,baseExportVo,rowIndex);
		}
		
		return workbook;
	}

	public void initCellStyleMap(Map<CellStyleType,CellStyle> cellStyleMap,Workbook workBook){
		if(cellStyleMap==null){
			cellStyleMap = new HashMap<CellStyleType,CellStyle>();
		}
		cellStyleMap.clear();
		
		cellStyleMap.put(CellStyleType.Center, CellStyleUtil.createCellStyle(workBook)
								  		 .setAlign(CellStyle.ALIGN_CENTER)
										 .getCellStyle());
		cellStyleMap.put(CellStyleType.Header, CellStyleUtil.createCellStyle(workBook)
				.setAlign(CellStyle.ALIGN_CENTER)
				.getCellStyle());
		cellStyleMap.put(CellStyleType.Info, CellStyleUtil.createCellStyle(workBook)
				.setAlign(CellStyle.ALIGN_CENTER)
				.getCellStyle());
		cellStyleMap.put(CellStyleType.Number, CellStyleUtil.createCellStyle(workBook)
				.setAlign(CellStyle.ALIGN_CENTER)
				.getCellStyle());
		cellStyleMap.put(CellStyleType.Text, CellStyleUtil.createCellStyle(workBook)
				.setAlign(CellStyle.ALIGN_CENTER)
				.getCellStyle());
		cellStyleMap.put(CellStyleType.Title, CellStyleUtil.createCellStyle(workBook)
				.setAlign(CellStyle.ALIGN_CENTER)
				.getCellStyle());
	}
	
	/**
	 * 创建标题行
	 * @param workbook
	 * @param sheet
	 * @param baseExportVo
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private int createHeader(Workbook workbook, Sheet sheet, BaseExportVo baseExportVo,int rowIndex) {
		Collection<ExcelCellStyle> styles =  baseExportVo.getCellStyles().values();
		CellStyle cellstyle = workbook.createCellStyle();
		cellstyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellstyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
		cellstyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
		cellstyle.setBorderTop(CellStyle.BORDER_MEDIUM);
		cellstyle.setBorderRight(CellStyle.BORDER_MEDIUM);
		if(styles!=null&&styles.size()>0){
			Row header = sheet.createRow(rowIndex);
			for(ExcelCellStyle excelCellStyle:styles){
				//初始化列宽
				sheet.setColumnWidth(excelCellStyle.getIndex(),excelCellStyle.getColumnWidth());
				//创建单元格
				header.createCell(excelCellStyle.getIndex()).setCellValue(excelCellStyle.getColumnName());
				header.getCell(excelCellStyle.getIndex()).setCellStyle(cellstyle);
			}
		}
		return ++rowIndex;
	}

	/**
	 * 根据文件名称创建Excel工作簿
	 * 
	 * @param fileName
	 *            文件名
	 * @return 创建后的工作簿
	 */
	private Workbook createWorkbook(String fileName) {
		if (fileName.endsWith(".xls")) {
			// 对于03~07版本的excel
			return new HSSFWorkbook();
		} else if (fileName.endsWith(".xlsx")) {
			// 对于03~07版本以后版本的excel
			return new XSSFWorkbook();
		} else {
			return null;
		}
	}
	
	
	/**
	 * 填充数据
	 * @param workbook
	 * @param sheet
	 * @param baseExportVo
	 * @param rowIndex
	 * @throws Exception 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void fillDatas(Workbook workbook, Sheet sheet, BaseExportVo baseExportVo, int rowIndex) throws Exception {
		List<Object> datas = baseExportVo.getDatas();
		if(datas!=null&&datas.size()>0){
			Map<String, ExcelCellStyle> cellStyleMap = baseExportVo.getCellStyles();
			CellStyle cellstyle = workbook.createCellStyle();
			cellstyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
			cellstyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
			cellstyle.setBorderTop(CellStyle.BORDER_MEDIUM);
			cellstyle.setBorderRight(CellStyle.BORDER_MEDIUM);
			for(Object vo:datas){
				Row row = sheet.createRow(rowIndex);
				if(cellStyleMap!=null&&!cellStyleMap.isEmpty()){
					fillRowFromObject(workbook,row, vo,cellStyleMap,cellstyle);
					rowIndex++;
				}
			}
		}
		
	}
	
	private void fillRowFromObject(Workbook workBook,Row row, Object o,Map<String, ExcelCellStyle> cellStyles,CellStyle cellStyle) throws Exception {
		// 要导出的对象的相应字段名
		Set<String> set = cellStyles.keySet();
		Object value; // 用于保存字段的值
		// 遍历
		for (String key : set) {
			
			ExcelCellStyle excelCellStyle = cellStyles.get(key);
			
			// 获得对象字段的值
			value = o.getClass().getMethod(getMethodName(key)).invoke(o);
			
			if(StringUtils.isBlank(StringKit.toString(value))){
				row.createCell(excelCellStyle.getIndex()).setCellStyle(cellStyle);
				continue;
			}
			
			row.createCell(excelCellStyle.getIndex()).setCellType(excelCellStyle.getCellType());
			row.getCell(excelCellStyle.getIndex()).setCellValue(StringKit.toString(value));
			
			//这里除了标题都采用默认样式
			row.getCell(excelCellStyle.getIndex()).setCellStyle(cellStyle);
		}
	}

	/**
	 * 拼接get方法名
	 * 
	 * @param name
	 *            字段名
	 * @return 返回拼接后的值
	 */
	private String getMethodName(String name) {
		return new StringBuffer().append("get").append(name.substring(0, 1).toUpperCase()).append(name.substring(1)).toString();
	}
	
}
