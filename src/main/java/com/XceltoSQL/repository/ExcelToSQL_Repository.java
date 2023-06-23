package com.XceltoSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.XceltoSQL.Enitity.Employee;

@Repository
public interface ExcelToSQL_Repository extends JpaRepository<Employee, String> {

}
