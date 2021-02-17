package com.ict.db;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {
   // config.xml 파일 읽어서 DAO에서 필요한 SqlSession클래스를 
   // 만들기 위한 SqlSessionFactory 클래스를 생성하는 역할 
	static private SqlSessionFactory factory;
	
	// static 초기화
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("com/ict/db/config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory ;
	}
}	
