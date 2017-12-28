package com.zs.mybatis.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zs.mybatis.bean.Employee;
import com.zs.mybatis.dao.EmployeeMapper;

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
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			EmployeeMapper mapper2 = sqlSession2.getMapper(EmployeeMapper.class);
			Employee emp01 = mapper.getEmpById(1);
			System.out.println(emp01);
			//会话关闭才会放到二级缓存中
			sqlSession.close();
			Employee emp02 = mapper2.getEmpById(1);
			System.out.println(emp02);
			sqlSession2.close();
		} finally {
			
		}
	}

}
