package de.hbrs.erasmux.model;

import java.util.List;

public class OrderEvaluation {

    final List<Order> order;
    final int bonusSum;

    public OrderEvaluation(List<Order> order, int bonusSum) {
        this.order = order;
        this.bonusSum = bonusSum;
    }

    @Override
    public String toString() {
        String temp = "[";
        for(Order attribute: order) {
            temp += "\n" + attribute.toString() + ",";
        }
        temp += "]";

        return "OrderEvaluation{" +
                temp +
                ", \nbonusSum=" + bonusSum +
                '}';
    }
}
