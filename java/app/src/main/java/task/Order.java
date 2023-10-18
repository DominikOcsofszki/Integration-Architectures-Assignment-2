package task;

public class Order {
    final String productName;
    final String client;
    final int clientRanking;
    final int bonus;
    final int itemAmount;
    final String comment;

    public Order(String productName, String client, int clientRanking, int bonus, int itemAmount, String comment) {
        this.productName = productName;
        this.client = client;
        this.clientRanking = clientRanking;
        this.bonus = bonus;
        this.itemAmount = itemAmount;
        this.comment = comment;
    }

}

