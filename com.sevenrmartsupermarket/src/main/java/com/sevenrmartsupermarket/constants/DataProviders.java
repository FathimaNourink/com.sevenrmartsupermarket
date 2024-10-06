package com.sevenrmartsupermarket.constants;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class DataProviders 
{
ExcelReader excelReader=new ExcelReader();
@DataProvider(name="loginDetails")

public Object[][] login()
{
	excelReader.setExcelFile("logindata", "Admin_Users_login");
	return excelReader.getMultidimentionalData(4,2);
	
}
}
