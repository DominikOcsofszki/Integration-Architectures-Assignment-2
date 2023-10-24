package task;
// package org.hbrs.ia.contract;

// import java.util.List;

public interface ManagePersonalMissingCRUD {

     public void deleteSalesMan( int sid );
     public void deleteEvaluationRecords( int sid);
     public void updateSalesMan( SalesMan salesMan , int sid);
     public void updateEvaluationRecord( EvaluationRecord evaluationRecord );

     public void createEvaluationRecord( EvaluationRecord evaluationRecord );

     public void updateSocialPerfomanceRecord( int sid, SocialPerfomanceRecord updatedRecord );

     public void deleteSocialPerfomanceRecord( int sid );


}
