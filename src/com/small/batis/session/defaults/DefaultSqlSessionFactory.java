package com.small.batis.session.defaults;

import com.small.batis.constants.Constant;
import com.small.batis.session.Configuration;
import com.small.batis.session.SqlSession;
import com.small.batis.session.SqlSessionFactory;
import com.small.batis.utils.CommonUtils;
import com.small.batis.utils.XmlUtil;

import java.io.File;
import java.net.URL;

/**
 * @author GTsung
 * @date 2021/10/18
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    /**
     * the configuration
     */
    private final Configuration configuration;

    /**
     * @param configuration
     */
    public DefaultSqlSessionFactory(Configuration configuration) {

        this.configuration = configuration;
        loadMappersInfo(Configuration.getProperty(Constant.MAPPER_LOCATION).replaceAll("\\.", "/"));
    }

    /**
     * 开启会话
     *
     * @return
     */
    @Override
    public SqlSession openSession() {

        SqlSession session = new DefaultSqlSession(this.configuration);

        return session;
    }

    /**
     * loadMappersInfo
     *
     * @param dirName
     * @see
     */
    private void loadMappersInfo(String dirName) {

        URL resources = DefaultSqlSessionFactory.class.getClassLoader().getResource(dirName);

        File mappersDir = new File(resources.getFile());

        if (mappersDir.isDirectory()) {
            // 显示包下所有文件
            File[] mappers = mappersDir.listFiles();
            if (CommonUtils.isNotEmpty(mappers)) {
                for (File file : mappers) {

                    // 对文件夹继续递归
                    if (file.isDirectory()) {
                        loadMappersInfo(dirName + "/" + file.getName());

                    } else if (file.getName().endsWith(Constant.MAPPER_FILE_SUFFIX)) {
                        // 只对XML文件解析
                        XmlUtil.readMapperXml(file, this.configuration);
                    }

                }

            }
        }

    }

}
