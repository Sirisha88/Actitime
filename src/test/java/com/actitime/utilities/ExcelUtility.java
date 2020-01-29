package com.actitime.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{
	public static int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+("/testdata/userdata.xlsx"));
		Workbook w1=WorkbookFactory.create(fis);
		return w1.getSheet(sheetname).getPhysicalNumberOfRows();
	}
	public static int getCellCount(String sheetname,int rowNumber) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+("/testdata/userdata.xlsx"));
		Workbook w1=WorkbookFactory.create(fis);
		return w1.getSheet(sheetname).getRow(rowNumber).getPhysicalNumberOfCells();
	}
	public static String readData(String sheetname,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+("/testdata/userdata.xlsx"));
		Workbook w1=WorkbookFactory.create(fis);
		Cell c= w1.getSheet(sheetname).getRow(rowNumber).getCell(cellNumber);
		DataFormatter rv=new DataFormatter();
		String s=rv.formatCellValue(c);
		return s;
		
	}
	public static String writeData(String sheetname,int rowNumber,int cellNumber,String Data) throws EncryptedDocumentException,  IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+("/testdata/userdata.xlsx"));
		Workbook w1=WorkbookFactory.create(fis);
		FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+("/testdata/userdata.xlsx"));
		w1.getSheet(sheetname).getRow(rowNumber).createCell(cellNumber).setCellValue(Data);
		w1.write(fos);
		return Data;
		
	}
}
