package com.spring.dubbo.demo.order;

import com.spring.dubbo.demo.order.service.IOrderService;
import com.spring.dubbo.demo.order.service.impl.OrderServiceImpl;
import com.spring.dubbo.demo.user.service.api.IUserService;
import com.spring.dubbo.demo.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class consumerMain {

    public static void main(String[] args) throws IOException {
        //第一种方式111
        ClassPathXmlApplicationContext context=new
            ClassPathXmlApplicationContext("classpath*:/META-INF/consumer.xml");
        IOrderService oderService = (IOrderService)context.getBean("orderService");
        context.start();
        oderService.initOrder("1");
        System.in.read(); //阻塞Main线程
        //第二种方式
//        Main.main(args);
    }
}
