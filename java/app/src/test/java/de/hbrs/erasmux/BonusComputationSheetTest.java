package de.hbrs.erasmux;

import de.hbrs.erasmux.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.hbrs.erasmux.ManagePersonalImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusComputationSheetTest {

    private ManagePersonalImpl managePersonal = new ManagePersonalImpl();

    @BeforeEach
    void clear() {
        managePersonal._dropAllBonusComputationSheets();
    }

    @Test
    void roundTripTest() {
        BonusComputationSheet first = firstBonusComputationSheet();
        BonusComputationSheet changed = changedBonusComputationSheet();

        managePersonal.createBonusComputationSheet(first);
        assertEquals(first.toString(),managePersonal.readBonusComputationSheet(25, 2022).toString());
        managePersonal.updateBonusComputationSheet(25,2022,changed);
        assertEquals(changed.toString(),managePersonal.readBonusComputationSheet(25, 2022).toString());
        managePersonal.deleteBonusComputationSheet(25,2022);
        assertEquals(null, managePersonal.readBonusComputationSheet(25,2022));
    }


    private BonusComputationSheet firstBonusComputationSheet() {
        List<SocialAttribute> list = new ArrayList<>();
        list.add(new SocialAttribute("Leadership Competence",
                4, 3, 20,"Gut gemacht"));
        list.add(new SocialAttribute("Communication Skills",
                4, 4, 50,"Sehr gut!"));
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Hoover Go",
                "Telekom AG", "very good", 500, 25, "Wir sind reich wegen dir!"));
        orderList.add(new Order("Hoover Clean",
                "Dirk Müller Gmbh", "very good", 750, 25, "Nice!"));

        BonusComputationSheet first = new BonusComputationSheet(
                new SocialPerfomanceRecord(list,70), new OrderEvaluation(orderList, 1250),
                25, 1320, 2022,0);
        return first;
    }

    private BonusComputationSheet changedBonusComputationSheet() {
        List<SocialAttribute> list = new ArrayList<>();
        list.add(new SocialAttribute("Leadership Competence",
                4, 1, 0,"Och nööö"));
        list.add(new SocialAttribute("Communication Skills",
                4, 5, 100,"Wow, das hätte ich nicht gedacht"));


        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Hoover Go",
                "Telekom AG", "very good", 500, 25, "Wir sind reich wegen dir!"));
        orderList.add(new Order("Hoover Clean",
                "Das Beste GmbH", "very good", 1500, 50, "Nice!"));

        BonusComputationSheet first = new BonusComputationSheet(
                new SocialPerfomanceRecord(list,100), new OrderEvaluation(orderList, 2000),
                25, 2100, 2022,0);
        return first;
    }

}
