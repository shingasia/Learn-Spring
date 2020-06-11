package com.mongo.main;

import com.mongo.config.MongoConfig;
import com.mongo.repositories.UserRepository;
import com.mongo.vo.User;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// https://www.javainterviewpoint.com/spring-data-mongodb-example/
// SimpleMongoRepository 도 알아보자
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
        UserRepository repo = ctx.getBean("userRepository", UserRepository.class);
        User obj = new User();
        obj.setId("sexy");
        obj.setName("Sera");
        obj.setAge(20);
        repo.insert(obj);

        System.out.println("haha");

        ctx.close();
    }
}