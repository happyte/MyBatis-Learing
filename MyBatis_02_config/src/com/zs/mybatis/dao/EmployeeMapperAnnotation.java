package com.zs.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.zs.mybatis.bean.Employee;

public interface EmployeeMapperAnnotation {
	@Select("select * from tbl_employee where id = #{id}")
	public Employee getEmpById(Integer id);
}
