package task;

public class EvaluationRecord {
    final SocialPerfomanceRecord socialPerfomanceRecord;
    final OrderEvaluation orderEvaluation;
    final int salesManId;
    final int totalBonus;
    final int yearOfOrder;

    public EvaluationRecord(SocialPerfomanceRecord socialPerfomanceRecord, OrderEvaluation orderEvaluation, int salesManId, int totalBonus, int yearOfOrder) {
        this.socialPerfomanceRecord = socialPerfomanceRecord;
        this.orderEvaluation = orderEvaluation;
        this.salesManId = salesManId;
        this.totalBonus = totalBonus;
        this.yearOfOrder = yearOfOrder;
    }


}
