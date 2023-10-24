package task;

public class SocialAttribute {
    final String comment;
    final int targetValue;
    final int actualValue;
    final String socialAttributeName;
    final int bonus;

    public SocialAttribute(String socialAttributeName, int targetValue, int actualValue,int bonus, String comment) {
        this.comment = comment;
        this.targetValue = targetValue;
        this.actualValue = actualValue;
        this.socialAttributeName = socialAttributeName;
        this.bonus = bonus;
    }
}
