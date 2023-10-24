package task;

import java.util.List;

public class SocialPerfomanceRecord {
    final List<SocialAttribute> socialAttributes;
    final int bonusSumB;

    public SocialPerfomanceRecord(List<SocialAttribute> socialAttributes, int bonusSumB) {
        this.socialAttributes = socialAttributes;
        this.bonusSumB = bonusSumB;
    }
}
