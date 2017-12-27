package com.zs.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zs.mybatis.bean.Employee;

public interface EmployeeMapperDynamicSQl {
	//动态sql查询,带条件查询
	public List<Employee> getEmpsByCondition(Employee employee);
	//trim自定义查询
	public List<Employee> getEmpsByConditionByTrim(Employee employee);
	//choose(when otherwise)条件查询
	public List<Employee> getEmpsByConditionByChoose(Employee employee);
	//set标签，更新操作(用trim标签也可以)
	public void updateEmp(Employee employee);
	//根据list中的id批量查询
	public List<Employee> getEmpsByConditionByForeach(@Param("ids")List<Integer> ids);
	//批量添加
	public void addEmps(@Param("emps")List<Employee> emps);
}
