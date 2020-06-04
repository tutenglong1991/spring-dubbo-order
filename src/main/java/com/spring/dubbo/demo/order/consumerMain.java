package com.spring.dubbo.demo.order;

import com.alibaba.fastjson.JSON;
import com.spring.dubbo.demo.order.service.IOrderService;
import com.spring.dubbo.demo.order.service.impl.OrderServiceImpl;
import com.spring.dubbo.demo.user.service.api.IUserService;
import com.spring.dubbo.demo.user.service.impl.UserServiceImpl;
import com.spring.dubbo.demo.user.service.request.UserQueryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class consumerMain {

    public static void main(String[] args) throws IOException {
        //第一种方式111
        ClassPathXmlApplicationContext context=new
            ClassPathXmlApplicationContext("classpath*:/META-INF/consumer.xml");
//        IOrderService oderService = (IOrderService)context.getBean("orderService");
        IUserService userService = (IUserService)context.getBean("userService");
        context.start();
//        oderService.initOrder("1");
        UserQueryReq userQueryReq = new UserQueryReq();
        userQueryReq.setId("1001");
        System.out.println(JSON.toJSONString(userQueryReq));
        userService.getUserInfoById(userQueryReq);
        System.in.read(); //阻塞Main线程
        //第二种方式
//        Main.main(args);
    }
}
