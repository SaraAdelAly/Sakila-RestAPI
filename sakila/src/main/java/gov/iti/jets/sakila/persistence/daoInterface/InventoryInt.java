package gov.iti.jets.sakila.persistence.daoInterface;

import java.util.List;

import gov.iti.jets.sakila.persistence.entities.Inventory;

public interface InventoryInt {


    List<Inventory> getInventoriesByFilmId(int filmId);
    List<Inventory> getInventoriesByStoreId(int storeId);
    Long groupFilmNumInSameStore (int storeId, int filmId);
    Boolean checkFilmInStore (int filmId, int storeId);
}
