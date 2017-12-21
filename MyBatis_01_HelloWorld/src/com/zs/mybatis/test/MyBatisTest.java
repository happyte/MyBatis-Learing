package com.zs.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

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

}
