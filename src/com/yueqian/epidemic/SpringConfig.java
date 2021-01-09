package com.yueqian.epidemic;

import org.springframework.aop.framework.AopConfigException;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;


/**
 * Spring配置类
 */
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class))
@PropertySource("classPath:jdbcConfig.properties")//导入jdbcConfig.properties文件
@EnableTransactionManagement
@EnableAspectJAutoProxy//开启aop

public class SpringConfig {
//创建事务管理器  @EnableTransactionManagement 开启事务管理器
// 在需要支持事务的方放前加入@Transation注解  当方法出错的执行事务回滚  否则事务提交
    @Bean
    public PlatformTransactionManager transactionManager (DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }


//    @Bean
//    //文件上传解析器
//    //需要commons-fileUpload支持 同时依赖commons-io
//    public MultipartResolver resolver(){
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setMaxUploadSize(10485760);//10G 10*1024*1024
//        return commonsMultipartResolver;
//    }


}
