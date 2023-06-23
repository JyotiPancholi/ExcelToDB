package com.XceltoSQL.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.XceltoSQL.Enitity.Employee;
import com.XceltoSQL.helper.ExcelHelper;
import com.XceltoSQL.repository.ExcelToSQL_Repository;

@Service
public class ExcelToSQL_Service  {

	@Autowired
	private ExcelToSQL_Repository repo;
	
	public void save(MultipartFile file)
	{
		try 
		{
			List<Employee> emp=ExcelHelper.convertExcelToListOfProduct(file.getInputStream());
			this.repo.saveAll(emp);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Employee> getAllEmployees()
	{
		return this.repo.findAll();
	}
}
