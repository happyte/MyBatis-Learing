package com.zs.mybatis.dao;

import java.util.List;

import com.zs.mybatis.bean.Employee;

public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
	public List<Employee> getEmps();
}
