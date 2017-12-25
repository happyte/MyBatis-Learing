package com.zs.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zs.mybatis.bean.Employee;
import com.zs.mybatis.dao.EmployeeMapper;
import com.zs.mybatis.dao.EmployeeMapperAnnotation;

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
	    //推介namespace+id的写法
	    Employee employee = sqlSession.selectOne("selectEmp", 1);
	    System.out.println(employee);
	    sqlSession.close();
	}
	
	@Test
	public void testInterface() throws IOException{
		//1.获取sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//2.获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//3.获取接口
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			//4.
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void test02() throws IOException{
		//1.获取sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//2.获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//3.获取接口
			EmployeeMapperAnnotation mapper =  sqlSession.getMapper(EmployeeMapperAnnotation.class);
			//4.
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void test03() throws IOException{
		//1.获取sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//2.获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//3.获取接口
			EmployeeMapper mapper =  sqlSession.getMapper(EmployeeMapper.class);
			//添加员工
			Employee employee = new Employee(null, "Tom", "1", "123@163.com");
			mapper.addEmp(employee);
			System.out.println(employee.getId());
			//修改员工
//			Employee employee = new Employee(1, "jeff", "0", "hayyte@163.com");
//			boolean status = mapper.updateEmp(employee);
//			System.out.println(status);
			//删除员工
//			mapper.deleteEmpById(1);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void test04() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper =  sqlSession.getMapper(EmployeeMapper.class);
//			Employee employee = mapper.getEmpByIdAndLastName(4, "Tom");
//			System.out.println(employee);
			List<Employee> list = mapper.getEmpsByLastName("%e%");
			for(Employee employee:list){
				System.out.println(employee);
			}
			
		} finally {
			sqlSession.close();
		}
	}

}
