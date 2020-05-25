package com.spring.dubbo.demo.order;

import com.spring.dubbo.demo.user.api.IUserService;
import org.apache.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class consumerMain {
    public static void main(String[] args) {
        //第一种方式111
        ClassPathXmlApplicationContext context=new
            ClassPathXmlApplicationContext("classpath*:/META-INF/consumer.xml");
        IUserService iUserService = (IUserService)context.getBean("userService");
        System.out.println(iUserService.getNameById("1001"));
        //第二种方式
//        Main.main(args);
    }
}
