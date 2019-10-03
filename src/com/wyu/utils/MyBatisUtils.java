package com.wyu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    static InputStream is = null;
    static SqlSessionFactory sf = null;

    static {
        String config = "mybatis-config.xml";
        try {
            is = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        2.	创建SqlSessionFactory对象，此对象可以完成对配置文件的读取
        sf = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSession getSqlSession() {
        return sf.openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        sqlSession.close();
    }


}
