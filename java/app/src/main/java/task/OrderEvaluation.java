package task;
import java.util.ArrayList;
import java.util.List;

public class OrderEvaluation {

    final List<Order> order;
    final int bonusSum;

    public OrderEvaluation(List<Order> order, int bonusSum) {
        this.order = order;
        this.bonusSum = bonusSum;
    }
}
