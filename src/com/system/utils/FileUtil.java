package com.system.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import com.system.constant.Constant;

import sun.misc.BASE64Encoder;


/**
 * 文件操作公共组件类
 * 
 */
public class FileUtil {

    public static void exportCsv(final HttpServletResponse response, final String fileName,
    final String content) {
        response.reset();
        response.setContentType("text/comma-separated-values;charset=gbk");
        response.setCharacterEncoding("GBK");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.println(content);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
    public static String toUtf8String(final String s) {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if ((c >= 0) && (c <= 255)) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (final Exception ex) {
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) {
                        k += 256;
                    }
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

    public static void writeZip(final HttpServletResponse response, final List<File> files,String fileName) throws IOException {
        response.reset();
        response.setContentType("text/comma-separated-values;charset=gbk");
        response.setCharacterEncoding("GBK");
        fileName=FileUtil.toUtf8String(fileName);
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        final OutputStream os = response.getOutputStream();
        final ZipOutputStream zos = new ZipOutputStream( os );
        zos.setEncoding("gbk");//指定编码为gbk，否则部署到linux下会出现乱码
        final byte[] buf = new byte[1024];
        int len;
        for ( final File file : files ) {
            if ( !file.isFile() ) {
                continue;
            }
            final ZipEntry ze = new ZipEntry(file.getName());
            zos.putNextEntry( ze );
            final BufferedInputStream bis = new BufferedInputStream( new FileInputStream( file ) );
            while ( ( len = bis.read( buf ) ) > 0 ) {
                zos.write( buf, 0, len );
            }
            zos.closeEntry();
        }
        zos.close();
    }


    public static void exportExcel(final HttpServletResponse response, String fileName,
    final HSSFWorkbook workbook) {
        response.reset();
        response.setContentType("text/comma-separated-values;charset=gbk");
        response.setCharacterEncoding("GBK");
        fileName=FileUtil.toUtf8String(fileName);
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        try {
            final OutputStream fOut = response.getOutputStream();
            workbook.write(fOut);
            fOut.flush();
            fOut.close();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static void exportExcel(final HttpServletResponse response, String fileName,
	    final Workbook workbook) {
	        response.reset();
	        response.setContentType("text/comma-separated-values;charset=gbk");
	        response.setCharacterEncoding("GBK");
	        fileName=FileUtil.toUtf8String(fileName);
	        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
	        try {
	            final OutputStream fOut = response.getOutputStream();
	            workbook.write(fOut);
	            fOut.flush();
	            fOut.close();
	        } catch (final IOException e) {
	            throw new RuntimeException(e);
	        } finally {
	     }
     }
    
    public static String getFileBase64(final String path) {
        String content = null;
        try {
            final FileInputStream fileInputStream = new FileInputStream(path);
            final byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            content = new BASE64Encoder().encode(bytes);
        } catch (final Exception e) {
            content = "错误了!";
        }
        return content;
    }

    public static String getPulishPath() {
        int i = 0;
        String publishPath = "";
        final String classNameUrl = "/org/springframework/jdbc/BadSqlGrammarException.class";
        String temp = null;
        try {
            final URL classUrl = FileUtil.class.getResource(classNameUrl);
            temp = classUrl.getPath();
            temp = URLDecoder.decode(temp, "UTF-8");
            // 如果是windows则从第六个字符开始，否则从第五个字符开始
            if ("Win".equalsIgnoreCase(System.getProperty("os.name").substring(0, 3))) {
                i = 6;
            } else {
                i = 5;
            }
            publishPath = temp.substring(i, temp.indexOf("WEB-INF") - 1);
        } catch (final Exception e) {
            System.err.println("取得publishPath时出错:");
            publishPath = "";
        }

        return publishPath;
    }

    public static void main(final String[] args) {
        System.out.println(FileUtil.getFileBase64("c://Hello.binHello.mem"));
    }

    /**
     * 创建文件目录
     * 
     * @param path
     *            目录路径
     * @return
     */
    public static boolean makeDir(final String path) {
        final File dir = new File(path);
        if (!dir.exists()) {
            return dir.mkdirs();
        } else {
            return true;
        }
    }

    /**
     * 组合路径与文件名
     * 
     * @param filepath
     *            路径
     * @param filename
     *            文件名
     * @return
     */
    public static String buildFilePath(final String filepath, final String filename) {
        final boolean checkfilepath = FileUtil.checkPathEndDivede(filepath);
        final boolean checkfilename = FileUtil.checkPathStartDivede(filename);
        if (checkfilepath && checkfilename) {
            return filepath + filename.substring(1);
        }
        if ((checkfilepath && !checkfilename) || (!checkfilepath && checkfilename)) {
            return filepath + filename;
        }
        if (!checkfilepath && !checkfilename) {
            return filepath + Constant.SEPARATOR_DIVIDE + filename;
        }

        return "";
    }

    /**
     * 判断是不是以/结束
     * 
     * @param path
     * @return
     */
    public static boolean checkPathEndDivede(final String path) {
        return path.endsWith(Constant.SEPARATOR_DIVIDE);
    }

    /**
     * 判断是不是以/开始
     * 
     * @param path
     * @return
     */
    public static boolean checkPathStartDivede(final String path) {
        return path.startsWith(Constant.SEPARATOR_DIVIDE);
    }

}