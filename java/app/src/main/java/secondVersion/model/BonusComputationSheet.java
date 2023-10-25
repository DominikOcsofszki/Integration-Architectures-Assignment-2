package secondVersion.model;

public class BonusComputationSheet {
    public final SocialPerfomanceRecord socialPerfomanceRecord;
    public final OrderEvaluation orderEvaluation;
    public final int salesManId;
    public final int totalBonus;
    public final int yearOfOrder;
    public final int evaluationRecordID;

    public BonusComputationSheet(SocialPerfomanceRecord socialPerfomanceRecord, OrderEvaluation orderEvaluation, int salesManId, int totalBonus, int yearOfOrder, int evaluationRecordID) {
        this.socialPerfomanceRecord = socialPerfomanceRecord;
        this.orderEvaluation = orderEvaluation;
        this.salesManId = salesManId;
        this.totalBonus = totalBonus;
        this.yearOfOrder = yearOfOrder;
        this.evaluationRecordID = evaluationRecordID;
    }


    @Override
    public String toString() {
        return "BonusComputationSheet{\n" +
                 socialPerfomanceRecord +
                ",\n" + orderEvaluation +
                ",\nsalesManId=" + salesManId +
                ",\ntotalBonus=" + totalBonus +
                ",\nyearOfOrder=" + yearOfOrder +
                ",\nevaluationRecordID=" + evaluationRecordID +
                '}';
    }
}
