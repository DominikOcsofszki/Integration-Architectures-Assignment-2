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
        boolean runUI = false;
        if(runUI) {
            ManagePersonalUI managePersonalUI = new ManagePersonalUI(new ManagePersonalImpl());
            managePersonalUI.start();
        } else {
            ManagePersonalImpl managePersonal = new ManagePersonalImpl();

            SalesMan salesMan = new SalesMan("Dominik", "Ocsofszki", 90133);
            final SocialAttribute socialAttribute = new SocialAttribute("Leadership Competence", 4, 3, 20, "whats wrong?");
            final SocialAttribute socialAttribute2 = new SocialAttribute("Openness to Employee", 4, 3, 20, "whats wrong?");
            final ArrayList<SocialAttribute> socialAttributes = new ArrayList();
            socialAttributes.add(socialAttribute);
            socialAttributes.add(socialAttribute2);
            final SocialPerfomanceRecord socialPerfomanceRecord = new SocialPerfomanceRecord(socialAttributes, 2_000);
            final Order order1 = new Order("HooverGo", "Telekom AG", "A", 700, 20, "YES!");
            final Order order2 = new Order("HooverGo", "Mayer", "B", 500, 10, "YES");
            ArrayList<Order> orders = new ArrayList();
            orders.add(order1);
            orders.add(order2);
            final OrderEvaluation orderEvaluation = new OrderEvaluation(orders, 1_000);
            final EvaluationRecord evaluationRecord = new EvaluationRecord(socialPerfomanceRecord, orderEvaluation, 1, 3_000, 2023, 0);
            managePersonal._dropAllSalesMan();

            managePersonal.createSalesMan(salesMan);
            System.out.println("-------");
            managePersonal.readSalesMan(90133);
            System.out.println("---perfRecord:----");
            managePersonal.addPerformanceRecord(evaluationRecord, 90133);
            System.out.println("querry:");
            System.out.println(managePersonal.querySalesMan("Dominik", "firstname"));
            System.out.println("after querry:");
            managePersonal.createEvaluationRecord(evaluationRecord);    //ToDo: this is not working
//        managePersonal.readEvaluationRecords(90133);            //ToDo: Or this not working
        }

    }
}
