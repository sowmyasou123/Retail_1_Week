package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.AddCategoryBean;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	@DataProvider(name = "db-inputs_1")
	public Object [][] getDBData_1() {

		List<AddCategoryBean> list = new ELearningDAO().getCategory(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(AddCategoryBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getCategoryname(); 
			obj[1] = temp.getMetatagtitle(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Sowmya\\TestData_Retail.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName, 0); 
	}
	
	@DataProvider(name = "excel-inputs_1")
	public Object[][] getExcelData1(){
		String fileName ="C:\\Sowmya\\TestData_Retail.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName, 2); 
	}
	
	@DataProvider(name = "excel-inputs_2")
	public Object[][] getExcelData2(){
		String fileName ="C:\\Sowmya\\TestData_Retail.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName, 3); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Sowmya\\TestData_Retail.xlsx", "Sheet1"); 
	}
}
