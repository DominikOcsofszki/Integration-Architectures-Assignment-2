package de.hbrs.erasmux;

import de.hbrs.erasmux.model.BonusComputationSheet;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public interface ManageRecords {

    public void createBonusComputationSheet(BonusComputationSheet sheet);

    public BonusComputationSheet readBonusComputationSheet(int salesManId, int year);

    public void updateBonusComputationSheet(int sid, int year, BonusComputationSheet sheet);

    public void deleteBonusComputationSheet( int salesManId, int year);
}
