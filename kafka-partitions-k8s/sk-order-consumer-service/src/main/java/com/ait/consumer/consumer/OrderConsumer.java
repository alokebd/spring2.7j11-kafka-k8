package com.ait.consumer.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.ait.consumer.model.Order;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "order-topic", groupId = "group-id-1", properties = {"spring.json.value.default.type=com.ait.consumer.model.Order"})
    public void consume1(Order order, Acknowledgment acknowledgment, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(String.format("Consumer 1: %s, Partition: %s", order.getOrderId(), partition));
        acknowledgment.acknowledge();
    }

    @KafkaListener(topics = "order-topic", groupId = "group-id-1", properties = {"spring.json.value.default.type=com.ait.consumer.model.Order"})
    public void consume2(Order order, Acknowledgment acknowledgment, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(String.format("Consumer 2: %s, Partition: %s", order.getOrderId(), partition));
        acknowledgment.acknowledge();
    }

    @KafkaListener(topics = "order-topic", groupId = "group-id-1", properties = {"spring.json.value.default.type=com.ait.consumer.model.Order"})
    public void consume3(Order order, Acknowledgment acknowledgment, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(String.format("Consumer 3: %s, Partition: %s", order.getOrderId(), partition));
        acknowledgment.acknowledge();
    }

}
