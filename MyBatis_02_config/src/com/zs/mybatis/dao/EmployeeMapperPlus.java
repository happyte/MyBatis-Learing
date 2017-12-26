package com.zs.mybatis.dao;

import com.zs.mybatis.bean.Employee;

public interface EmployeeMapperPlus {
	public Employee getEmpById(Integer id);
	//级联查询对应的部门
	public Employee getEmpWithDept(Integer id);
	//分步查询
	public Employee getEmpByIdStep(Integer id);
}
