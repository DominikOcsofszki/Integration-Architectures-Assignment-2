package de.hbrs.erasmux.model;

public class Order {
    final String productName;
    final String client;
    final String clientRanking;
    final int bonus;
    final int itemAmount;
    final String comment;

    public Order(String productName, String client, String clientRanking, int bonus, int itemAmount, String comment) {
        this.productName = productName;
        this.client = client;
        this.clientRanking = clientRanking; // Could be changed to enum //ToDo change to enum?
        this.bonus = bonus;
        this.itemAmount = itemAmount;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productName='" + productName + '\'' +
                ", client='" + client + '\'' +
                ", clientRanking='" + clientRanking + '\'' +
                ", bonus=" + bonus +
                ", itemAmount=" + itemAmount +
                ", comment='" + comment + '\'' +
                "}";
    }
}

