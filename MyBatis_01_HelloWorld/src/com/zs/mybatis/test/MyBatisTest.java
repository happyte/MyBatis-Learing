package com.zs.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zs.mybatis.bean.Employee;

public class MyBatisTest {

	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    //推介namespace+id的写法
	    Employee employee = sqlSession.selectOne("selectEmp", 1);
	    System.out.println(employee);
	    sqlSession.close();
	}

}
