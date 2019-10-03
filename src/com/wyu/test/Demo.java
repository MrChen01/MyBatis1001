package com.wyu.test;

import com.wyu.mapper.ItemsMapper;
import com.wyu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    @Test
    public void fun() {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        //generator.xml
        File configFile = new File("generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {
            config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                    callback, warnings);
            myBatisGenerator.generate(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    @Test
//    public void func(){
//
//    }

    @Test
    public void func() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        ItemsMapper mapper = sqlSession.getMapper(ItemsMapper.class);
        System.out.println(mapper.selectByPrimaryKey(1));
//        Dept dept = new Dept();
//        dept.setId(12);
//        dept.setName("陈卓信");
//        dept.setRemark("MRHCNE");
//        System.out.println(mapper.insert(dept));
        sqlSession.commit();
        MyBatisUtils.closeSqlSession(sqlSession);
    }


}
