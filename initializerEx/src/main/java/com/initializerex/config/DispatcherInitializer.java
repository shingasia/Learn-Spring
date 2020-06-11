package com.initializerex.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// getRootConfigClasses() 의 경우에는 ContextLoaderListener가 생성한 어플리케이션 컨텍스트를 설정하는데 사용되고
// getServletConfigClasses()의 경우 DispatcherServlet 사용되는 빈들을 등록합니다.

public class DispatcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class, ControllerConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        // TODO Auto-generated method stub
        return super.getServletFilters();
    }
}