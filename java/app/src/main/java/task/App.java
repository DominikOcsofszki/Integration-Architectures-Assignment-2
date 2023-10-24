package task;
// import task.MongoDB;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )   {
        ManagePersonalImpl managePersonal = new ManagePersonalImpl();

        SalesMan salesMan = new SalesMan("Dominik", "Ocsofszki", 90133);
        final SocialAttribute socialAttribute = new SocialAttribute("Leadership Competence",4, 3, 20,"whats wrong?");
        final SocialAttribute socialAttribute2 = new SocialAttribute("Openness to Employee",4, 3, 20,"whats wrong?");
        final ArrayList<SocialAttribute> socialAttributes = new ArrayList();
        socialAttributes.add(socialAttribute);
        socialAttributes.add(socialAttribute2);
        final SocialPerfomanceRecord socialPerfomanceRecord = new SocialPerfomanceRecord(socialAttributes, 2_000);
        final Order order = new Order("HooverGo", "TKMax", "A", 200, 20, "last year we had 10 more sold");
        final Order order2 = new Order("HooverGo", "TKMax", "A", 200, 20, "last year we had 10 more sold");
        ArrayList<Order> orders = new ArrayList();
        orders.add(order);
        orders.add(order);
        final OrderEvaluation orderEvaluation = new OrderEvaluation(orders, 1_000);
        final EvaluationRecord evaluationRecord = new EvaluationRecord(socialPerfomanceRecord, orderEvaluation, 1, 3_000, 2023);
        managePersonal._dropAllSalesMan();

        managePersonal.createSalesMan(salesMan);
        System.out.println("-------");
        managePersonal.readSalesMan(90133);
        System.out.println("---perfRecord:----");
        managePersonal.addPerformanceRecord(evaluationRecord, 90133);

    }
}
