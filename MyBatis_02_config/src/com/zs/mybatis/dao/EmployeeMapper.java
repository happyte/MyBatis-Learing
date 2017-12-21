package com.zs.mybatis.dao;

import com.zs.mybatis.bean.Employee;

public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
	public void addEmp(Employee employee);
	public boolean updateEmp(Employee employee);
	public void deleteEmpById(Integer id);
}
