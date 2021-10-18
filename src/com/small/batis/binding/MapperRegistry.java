package com.small.batis.binding;

import com.small.batis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GTsung
 * @date 2021/10/18
 */
public class MapperRegistry {

    /**
     * the knownMappers
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    /**
     * 注册代理工厂
     *
     * @param type
     */
    public <T> void addMapper(Class<T> type) {
        this.knownMappers.put(type, new MapperProxyFactory<T>(type));
    }

    /**
     * 获取代理工厂实例
     *
     * @param type
     * @param sqlSession
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) this.knownMappers.get(type);
        return mapperProxyFactory.newInstance(sqlSession);
    }
}
