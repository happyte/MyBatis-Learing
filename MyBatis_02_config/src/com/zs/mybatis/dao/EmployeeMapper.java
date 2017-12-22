package com.zs.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import com.zs.mybatis.bean.Employee;

public interface EmployeeMapper {
	//多个参数
	public Employee getEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
	public Employee getEmpById(Integer id);
	public void addEmp(Employee employee);
	public boolean updateEmp(Employee employee);
	public void deleteEmpById(Integer id);
}
