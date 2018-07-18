package com.black.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangzq
 * @date 2018年02月28日
 */
public class ReadExcelFile {
    //读取xlsx结尾的EXCEL
    public static List<String[]> readExcelsXLSX(String path) throws IOException {
        InputStream is = null;
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String []> list = new ArrayList<String[]>();
        try {
            is =new FileInputStream(path);
            //创建WorkBook
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                //创建一个Excel的sheet,定位到当前Sheet
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                //第一行
                int firstRowNum = xssfSheet.getFirstRowNum();
                //最后一行
                int lastRowNum = xssfSheet.getLastRowNum();
                //循环第二行到最后一行
                for(int i = firstRowNum+1; i <= lastRowNum; i++ ) {
                    //定位到当前行
                    Row row = xssfSheet.getRow(i);

                    //第一列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的最大列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    //创建数组存放当前行的数据
                    String[] cells = new String[lastCellNum];
                    //循环当前行
                    for(int j = firstCellNum; j <lastCellNum; j++ ) {
                        //申请Cell空间
                        XSSFCell cell = (XSSFCell) row.getCell(j);
                        cells[j] = getCellValue(cell);
                    }
                    list.add(cells);
                }
                is.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            is.close();
        }
        return list;
    }


    //读取xls格式Excel
    public static List<String[]> readExcels(String path) throws IOException{
        InputStream is = null;
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String []> list = new ArrayList<String[]>();
        try {
            is =new FileInputStream(path);
            //创建WorkBook
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                //创建一个Excel的sheet,定位到当前Sheet
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                //第一行
                int firstRowNum = hssfSheet.getFirstRowNum();
                //最后一行
                int lastRowNum = hssfSheet.getLastRowNum();
                //循环第二行到最后一行
                for(int i = firstRowNum+1; i <= lastRowNum; i++ ) {
                    //定位到当前行
                    Row row = hssfSheet.getRow(i);

                    //第一列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的最大列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    //创建数组存放当前行的数据
                    String[] cells = new String[lastCellNum];
                    //循环当前行
                    for(int j = firstCellNum; j <lastCellNum; j++ ) {
                        //申请Cell空间
                        HSSFCell cell = (HSSFCell) row.getCell(j);
                        cells[j] = getCellValue(cell);
                    }
                    list.add(cells);
                }
                is.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            is.close();
        }
        return list;
    }


    //获取xls单元格数据
    public static String getCellValue(HSSFCell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }
    //获取xlsx单元格数据
    public static String getCellValue(XSSFCell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }
}

