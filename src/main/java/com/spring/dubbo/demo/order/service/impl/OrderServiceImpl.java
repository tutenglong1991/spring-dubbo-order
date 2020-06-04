package com.spring.dubbo.demo.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.spring.dubbo.demo.order.service.IOrderService;
import com.spring.dubbo.demo.user.service.api.IUserService;
import com.spring.dubbo.demo.user.service.request.UserQueryReq;
import com.spring.dubbo.demo.user.service.response.UserRespModel;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Service
@Component("orderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IUserService userService;

    @Override
    public void initOrder(String userId) {
        System.out.println("传入的用户ID："+ userId);
        UserQueryReq userQueryReq = new UserQueryReq();
        userQueryReq.setId(userId);
        System.out.println(JSON.toJSONString(userQueryReq));
        System.out.println(userService);

        UserRespModel userRespModel = userService.getUserInfoById(userQueryReq);
        String address = userRespModel.getAddress();
        String name = userRespModel.getName();
        System.out.println("正在使用【"+ address+"】作为地址为用户【"+ name + "】生成订单");
    }
}
