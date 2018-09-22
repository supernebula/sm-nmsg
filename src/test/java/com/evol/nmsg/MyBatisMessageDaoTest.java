package com.evol.nmsg;

import com.evol.nmsg.domain.Message;
import com.evol.nmsg.mapper.MessageMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Calendar;
import java.util.Properties;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

public class MyBatisMessageDaoTest {

    private MessageMapper mapper;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            if(reader != null)
                reader.close();
        }
    }


    @After
    public void destroy() throws Exception { }



    @Test
    public void insertTest()
    {
        Message message = new Message();
        message.setId(UUID.randomUUID().toString());
        message.setUserId(UUID.randomUUID().toString());
        message.setUserId(UUID.randomUUID().toString());
        message.setSubject("今天下了一天的雨");
        message.setContent("今天有雨，明天风和丽日");
        message.setModel(1);
        message.setCreateTime(Calendar.getInstance().getTime());
        message.setUpdateTime(Calendar.getInstance().getTime());

        try {
            // innoDB是自动提交事务的，而MyBatis管理事务时默认不提交。这里openSession(true)，使MyBatis自动提交事务
            SqlSession sqlSession = sqlSessionFactory.openSession(true);

            //sqlSession.getMapper 动态构建接口的实现类
            MessageMapper msgMapper = sqlSession.getMapper(MessageMapper.class);
            int num = msgMapper.insert(message);
            sqlSession.close();
            System.out.printf("insert num: %d", num);
            assertTrue(num == 1, "更新失败");
            throw new Exception("故意抛出的异常");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }




/*    ///@Before
    public void setUp() throws Exception {
        InputStream fis = null;
        InputStream inputStream = null;
        try {
            //创建Properties对象
            Properties prop = new Properties();
            //创建输入流，指向配置文件,getResourceAsStream可以从classpath加载资源
            fis= Resources.getResourceAsStream("test.properties");
            //加载属性文件
            prop.load(fis);
            inputStream = Resources.getResourceAsStream("mybatis.xml");
            //build的第二个参数对应mybatis.xml配置文件的<environment id="development">标签的id，
            //其中后面两个参数可选，若第二个参数不写则默认为"development"
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"development",prop);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //StuScoreDao.class与配置文件StuMapper的namespace对应
            mapper = sqlSession.getMapper(MessageMapper.class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }*/
}





