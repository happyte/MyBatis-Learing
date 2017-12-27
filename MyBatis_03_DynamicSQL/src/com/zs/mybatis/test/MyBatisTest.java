package com.zs.mybatis.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zs.mybatis.bean.Department;
import com.zs.mybatis.bean.Employee;
import com.zs.mybatis.dao.EmployeeMapperDynamicSQl;

public class MyBatisTest {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    return sqlSessionFactory;
	}

	@Test
	public void test() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapperDynamicSQl mapper = sqlSession.getMapper(EmployeeMapperDynamicSQl.class);
			Employee employee = new Employee(null, "%y%", null, null);
//			List<Employee> emps = mapper.getEmpsByCondition(employee);
//			for (Employee emp : emps) {
//				System.out.println(emp);
//			}
//			List<Employee> emps2 = mapper.getEmpsByConditionByTrim(employee);
//			for (Employee emp2 : emps2) {
//				System.out.println(emp2);
//			}
			List<Employee> emps3 = mapper.getEmpsByConditionByChoose(employee);
			for (Employee emp3 : emps3) {
				System.out.println(emp3);
			}
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void test01() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapperDynamicSQl mapper = sqlSession.getMapper(EmployeeMapperDynamicSQl.class);
//			Employee employee = new Employee(1, "zs", null, null);
//			mapper.updateEmp(employee);
//			sqlSession.commit();
//			List<Employee> emps = mapper.getEmpsByConditionByForeach(Arrays.asList(1,2,3));
//			for (Employee emp : emps) {
//				System.out.println(emp);
//			}
			List<Employee> emps = new ArrayList<>();
			emps.add(new Employee(null, "jordan", "1", "jordan@163.com", new Department(1)));
			emps.add(new Employee(null, "smith", "0", "smith@163.com", new Department(3)));
			mapper.addEmps(emps);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}
