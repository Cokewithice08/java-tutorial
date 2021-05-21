package io.github.jast90.rocketmq.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jast90 on 2021/5/21
 */
public class OrderStep {
    private Long orderId;
    private String stepDesc;

    public OrderStep() {
    }

    public OrderStep(Long orderId, String stepDesc) {
        this.orderId = orderId;
        this.stepDesc = stepDesc;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc;
    }

    @Override
    public String toString() {
        return "OrderStep{" +
                "orderId=" + orderId +
                ", stepDesc='" + stepDesc + '\'' +
                '}';
    }

    public static List<OrderStep> orderSteps(){
        List<OrderStep> list = new ArrayList<>();
        list.add(new OrderStep(100L,"创建"));
        list.add(new OrderStep(100L,"支付"));
        list.add(new OrderStep(100L,"扣减积分"));
        list.add(new OrderStep(100L,"通知"));
        list.add(new OrderStep(100L,"完成"));

        list.add(new OrderStep(101L,"创建"));
        list.add(new OrderStep(101L,"支付"));

        list.add(new OrderStep(102L,"创建"));
         return list;
    }
}
