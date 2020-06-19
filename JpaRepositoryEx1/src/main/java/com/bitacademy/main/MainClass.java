package com.bitacademy.main;

import com.bitacademy.config.DBConfig;
import com.bitacademy.config.ServiceConfig;
import com.bitacademy.entities.MemberVO;
import com.bitacademy.services.member.MemberRegisterRequest;
import com.bitacademy.services.member.MemberRegisterService;
import com.bitacademy.services.member.MemberSearchService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class, ServiceConfig.class);
        // MemberRegisterService service=ctx.getBean("memberRegisterService", MemberRegisterService.class);
        // MemberRegisterRequest memberRequest=new MemberRegisterRequest();
        // memberRequest.setId("eeeee");
        // memberRequest.setPassword("eeeee");
        // memberRequest.setName("Sera");
        // memberRequest.setPhone("11111");
        // service.registerMember(memberRequest);

        MemberSearchService service = ctx.getBean("memberSearchService", MemberSearchService.class);
        MemberVO member=service.searchMember("shingasia");

        System.out.println(member.getId()+" "+member.getName());
        ctx.close();
    }
}