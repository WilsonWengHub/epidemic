package com.yueqian.epidemic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



/**
 * 应用程序初始化类 实现继承方法 Alt+inset快捷键插入抽象方法
 */
public class EpidemicApplicationInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        //Spring的配置类
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //SpringMVC配置类
        return new Class[]{SpringMVCConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        //返回映射到DispatcherServletd的请求路径

        //{"/"}  客户端发来的除了jsp请求  都交给他来处理  从而进入springmvc框架
        return new String[]{"/"};
    }
}
