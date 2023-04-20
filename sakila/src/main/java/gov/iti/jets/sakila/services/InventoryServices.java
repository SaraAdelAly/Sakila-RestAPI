package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dto.InventoryDto;
import gov.iti.jets.sakila.persistence.dao.InventoryDao;
import gov.iti.jets.sakila.persistence.entities.Inventory;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class InventoryServices {
    private ModelMapper modelMapper = new ModelMapper();
    private InventoryDao inventoryDao = new InventoryDao();
    public InventoryServices(ModelMapper modelMapper, InventoryDao inventoryDao){
        this.modelMapper= modelMapper;
        this.inventoryDao= inventoryDao;
    }

    public List<InventoryDto> getInventoriesByFilmId(int filmId) {
       List<Inventory> inventories = inventoryDao.getInventoriesByFilmId(filmId);
       List<InventoryDto> inventoryDtos = new ArrayList<>();
       for(Inventory inventory : inventories){
           InventoryDto inventoryDto = modelMapper.map(inventory, InventoryDto.class);
           inventoryDtos.add(inventoryDto);
       }
       return inventoryDtos;
    }
    public Long groupFilmNumInSameStore(int storeId, int filmId) {
        return inventoryDao.groupFilmNumInSameStore(storeId, filmId);
    }
    public Boolean checkFilmInStore(int filmId, int storeId) {
        return inventoryDao.checkFilmInStore(filmId,storeId);
    }

    public List<InventoryDto> getInventoriesByStoreId(int storeId) {
        List<Inventory> inventories = inventoryDao.getInventoriesByStoreId(storeId);
        List<InventoryDto> inventoryDtos = new ArrayList<>();
        for(Inventory inventory : inventories){
            InventoryDto inventoryDto = modelMapper.map(inventory, InventoryDto.class);
            inventoryDtos.add(inventoryDto);
        }
        return inventoryDtos;
    }


}
