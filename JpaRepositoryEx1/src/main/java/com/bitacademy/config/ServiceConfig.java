package com.bitacademy.config;

import com.bitacademy.services.member.MemberRegisterRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

//여기서 service의 모든 것을 Scan해서 빈으로 등록하고 ControllerConfig에서  @Import(ServiceConfig.class)
@Configuration
@ComponentScans( value = {
    @ComponentScan(basePackages = {"com.bitacademy.services.member"}, excludeFilters = {@Filter(type=FilterType.ASSIGNABLE_TYPE, classes = MemberRegisterRequest.class)})
    })
public class ServiceConfig {
    
}