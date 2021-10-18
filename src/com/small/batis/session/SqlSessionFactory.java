package com.small.batis.session;

public interface SqlSessionFactory {

    /**
     * 开启数据库会话
     *
     * @return
     * @see
     */
    SqlSession openSession();
}
