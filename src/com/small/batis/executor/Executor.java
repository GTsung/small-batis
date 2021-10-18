package com.small.batis.executor;

import com.small.batis.mapping.MappedStatement;

import java.util.List;

/**
 * @author GTsung
 * @date 2021/10/18
 */
public interface Executor {

    /**
     * 查询数据库
     *
     * @param ms
     * @param parameter
     * @return
     * @see
     */
    <E> List<E> doQuery(MappedStatement ms, Object parameter);

    /**
     * 更新操作
     *
     * @param ms
     * @param parameter
     */
    void doUpdate(MappedStatement ms, Object parameter);

}
