package task;
// import task.MongoDB;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )   {
        ManagePersonalImpl managePersonal = new ManagePersonalImpl();

        SalesMan salesMan = new SalesMan("Dominik", "Ocsofszki", 90133);
        final SocialAttribute socialAttribute = new SocialAttribute("better next time", 5, 4);
        final SocialPerfomanceRecord socialPerfomanceRecord = new SocialPerfomanceRecord(socialAttribute, 2_000);
        final Order order = new Order("HooverGo", "TKMax", "A",200,20,"last year we had 10 more sold");
        final OrderEvaluation orderEvaluation = new OrderEvaluation(order, 1_000);
        final EvaluationRecord evaluationRecord = new EvaluationRecord(socialPerfomanceRecord, orderEvaluation, 1, 3_000, 2023);
        managePersonal.dropAllSalesMan();

        managePersonal.createSalesMan(salesMan);
        System.out.println("-------");
        managePersonal.readSalesMan(90133);
    }
}
