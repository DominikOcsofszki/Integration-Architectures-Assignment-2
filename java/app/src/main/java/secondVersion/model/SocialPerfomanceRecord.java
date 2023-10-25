package secondVersion.model;

import secondVersion.model.SocialAttribute;

import java.util.List;

public class SocialPerfomanceRecord {
    final List<SocialAttribute> socialAttributes;
    final int bonusSumB;

    public SocialPerfomanceRecord(List<SocialAttribute> socialAttributes, int bonusSumB) {
        this.socialAttributes = socialAttributes;
        this.bonusSumB = bonusSumB;
    }


    @Override
    public String toString() {
        String temp = "[";
        for(SocialAttribute attribute: socialAttributes) {
            temp += "\n" + attribute.toString() + ",";
        }
        temp += "]";
        return "SocialPerfomanceRecord{" +
                 temp +
                "\nbonusSumb=" + bonusSumB +
                '}';
    }
}
