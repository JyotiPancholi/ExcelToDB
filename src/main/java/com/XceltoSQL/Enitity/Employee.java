package com.XceltoSQL.Enitity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	
	private String name;
	private String address;
	private String state;
	private float salary;
	
}
