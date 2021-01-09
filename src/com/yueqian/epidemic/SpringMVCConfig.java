package com.yueqian.epidemic;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
//别到错controller包
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;


/**
 * SpringMVC配置类
 */
@Configuration //注解 注入ioc容器 声明为配置类
@EnableWebMvc //开启MVC功能
//自动扫描Controller类 并注册到ioc容器中
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class))
public class SpringMVCConfig extends WebMvcConfigurerAdapter {

    //添加视图控制器
    //当用户发来的请求为/ 后无内容 （无明确访问哪个资源）  将转发到epidemic视图
    // 返回视图名称 后用视图解析器解析
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("epidemic");
    }



    //配置视图解析器
    //把视图名字解析成内部资源jsp等等
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //把视图名称解析成/.jsp   eg：epidemic-->epidemic.jsp  prefix为文件路径  suffix为后缀名
        registry.jsp("/",".jsp");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //设置默认访问路径       当找不到以上路径时  图片等静态资源
        configurer.enable();
    }


}
