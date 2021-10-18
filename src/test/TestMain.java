package test;

import com.small.batis.session.SqlSession;
import com.small.batis.session.SqlSessionFactory;
import com.small.batis.session.SqlSessionFactoryBuilder;
import test.bean.User;
import test.dao.UserMapper;

/**
 * @author GTsung
 * @date 2021/10/18
 */
public class TestMain {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build("conf.properties");

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUser("1");
        System.out.println(user);

        userMapper.updateUser("1");
        System.out.println(userMapper.getAll());
    }
}
