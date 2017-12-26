package com.zs.mybatis.dao;

import com.zs.mybatis.bean.Department;

public interface DepartmentMapper {
	//不查询部门对应的员工
	public Department getDeptById(Integer id);
	//增强版，查询出部门对应的员工
	public Department getDeptByIdPlus(Integer id);
}
