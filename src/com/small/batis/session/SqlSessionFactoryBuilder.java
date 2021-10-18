package com.small.batis.session;

import com.small.batis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author GTsung
 * @date 2021/10/18
 */
public class SqlSessionFactoryBuilder {

    /**
     * build
     *
     * @param fileName
     * @return
     * @see
     */
    public SqlSessionFactory build(String fileName) {

        InputStream inputStream = SqlSessionFactoryBuilder.class.getClassLoader().getResourceAsStream(fileName);

        return build(inputStream);
    }

    /**
     * build
     *
     * @param inputStream
     * @return
     * @see
     */
    public SqlSessionFactory build(InputStream inputStream) {
        try {
            Configuration.PROPS.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DefaultSqlSessionFactory(new Configuration());
    }

}
