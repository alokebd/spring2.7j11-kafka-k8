package com.ait.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.producer.model.Order;
import com.ait.producer.producer.OrderProducer;

import java.util.Date;

@RestController
@RequestMapping("/publish")
public class PublishOrderController {

    public final OrderProducer orderProducer;

    @Autowired
    public PublishOrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @GetMapping(path = "")
    public String publishOrder() {
        for (int i = 0; i < 100; i++) {
            var order = new Order(i, new Date());
            orderProducer.produce(order);
        }
        return "Orders published";
    }
}
