package task;
// package org.hbrs.ia.contract;

// import java.util.List;

public interface ManagePersonalMissingCRUD {

     public void deleteSalesMan( int sid );
     public void deleteEvaluationRecords( int sid ,int year);
     public void updateSalesMan( SalesMan salesMan , int sid);
     public void updateEvaluationRecord( SalesMan record );



}
