package com.XceltoSQL.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.XceltoSQL.Enitity.Employee;
import com.XceltoSQL.helper.ExcelHelper;
import com.XceltoSQL.service.ExcelToSQL_Service;

@RestController
public class Excel_to_sql_Controller {

	@Autowired
	private ExcelToSQL_Service service;

	@PostMapping("/Employee/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)
	{
		if(ExcelHelper.checkExcelFormat(file))
		{
			this.service.save(file);
			Map<String, String> map=new HashMap<>();
			map.put("message","file is uploaded & data saved is equal to db");
			return ResponseEntity.ok(map);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload Excel");
		
	}
	
	@GetMapping("/Employee")
	public List<Employee> getAllEmployee()
	{
		return this.service.getAllEmployees();
	}
}
