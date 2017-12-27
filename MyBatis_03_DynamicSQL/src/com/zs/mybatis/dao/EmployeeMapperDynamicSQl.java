package com.zs.mybatis.dao;

import java.util.List;

import com.zs.mybatis.bean.Employee;

public interface EmployeeMapperDynamicSQl {
	//动态sql查询,带条件查询
	public List<Employee> getEmpsByCondition(Employee employee);
	//trim自定义查询
	public List<Employee> getEmpsByConditionByTrim(Employee employee);
	//choose(when otherwise)条件查询
	public List<Employee> getEmpsByConditionByChoose(Employee employee);
}
