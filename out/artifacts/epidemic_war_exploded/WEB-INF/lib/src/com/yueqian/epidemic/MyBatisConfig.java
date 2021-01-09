package com.yueqian.epidemic;


import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * 配置MyBatis
 */
@Configuration
@MapperScan(basePackages = "com.yueqian.epidemic.mapper")//自动扫描Mapper组件
public class MyBatisConfig {
    //从配置文件中导入 需要在spring配置类中加入该文件@PropertySource("classPath:jdbcConfig.properties")
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private  String url;
    @Value("${jdbc.userName}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;
    private  static Logger logger = Logger.getLogger(MyBatisConfig.class);
   //创建数据源
    @Bean(name = "dataSource" , destroyMethod = "close")
    public BasicDataSource basicDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setInitialSize(3);//初始连接数
        dataSource.setMaxActive(50);//最大活动连接数
        dataSource.setMaxIdle(1);//最大空闲数
        dataSource.setMaxWait(4000);//创建时最多等4000ms
        dataSource.setDefaultAutoCommit(false);//设置不默认提交
        return dataSource;
    }
    //将上面的数据源注入 会自动识别
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource){
    //创建工厂Bean
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //设置要使用的数据源
        factoryBean.setDataSource(dataSource);
        //设置xml文件中类所在的包
        factoryBean.setTypeAliasesPackage("com.yueqian.epidemic.beans");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //将下划线转为驼峰命名
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);

        SqlSessionFactory factory = null;
        //设置映射xml文件路径
        try {
            Resource resource[] =  new PathMatchingResourcePatternResolver().getResources("classpath:com/yueqian/epidemic/mapper/*Mapper.xml");
            factoryBean.setMapperLocations(resource);
            factory = factoryBean.getObject();//通过工厂Bean生产工厂
        } catch (Exception e) {
            logger.error("解析映射xml文件异常"+e.getMessage());
        }
        return factory;
    }
}
