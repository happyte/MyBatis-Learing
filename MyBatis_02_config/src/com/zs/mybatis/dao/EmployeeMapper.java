package com.zs.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.zs.mybatis.bean.Employee;

public interface EmployeeMapper {
	//map,key是主键，value是封装对象
	@MapKey("id")
	public Map<Integer, Employee> getEmpByLastNameReturnMap(String lastNme);
	//返回map
	public Map<String, Object> getEmpByIdReturnMap(Integer id);
	//返回类型是list
	public List<Employee> getEmpsByLastName(String lastName);
	//多个参数
	public Employee getEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
	public Employee getEmpById(Integer id);
	public void addEmp(Employee employee);
	public boolean updateEmp(Employee employee);
	public void deleteEmpById(Integer id);
}
