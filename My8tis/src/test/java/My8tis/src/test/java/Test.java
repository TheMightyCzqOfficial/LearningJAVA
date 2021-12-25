package My8tis.src.test.java;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Test {
    public SqlSession sqlSession()  {
        SqlSession sqlSession = null;
        try {
            InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSession;
    }
    @org.junit.Test
    public void deleteById() throws IOException {
        int id=5;
        SqlSession sqlSession=sqlSession();
        sqlSession.delete("UserMapper.delete",id);
        sqlSession.commit();
        findAll();

    }
@org.junit.Test
public void findAll() throws IOException {
    SqlSession sqlSession=sqlSession();
    My8tis.src.main.java.com.stock.dao.UserMapper mapper = sqlSession.getMapper(My8tis.src.main.java.com.stock.dao.UserMapper.class);
    List<My8tis.src.main.java.domin.User> list = mapper.findAll();

    list.forEach(System.out::println);
   // sqlSession.close();
}
}
