package models.collections;

import models.entities.Purchase;
import models.repositories.PurchaseRepository;

import java.util.Set;

public class PurchaseCollection {
    public PurchaseRepository purchaseRepository;

    public PurchaseCollection(PurchaseRepository rep){
        this.purchaseRepository = rep;
    }

    public void createPurchase(Purchase purchase){purchaseRepository.createPurchase(purchase);}
    public void deletePurchase(Purchase purchase){purchaseRepository.deletePurchase(purchase);}
    public boolean updatePurchase(Purchase purchase)throws Exception{
        if(!purchaseRepository.updatePurchase(purchase)){
            throw new Exception("Compra inexistente!");
        }
        return true;
    }
    public Purchase findById(Integer id) throws Exception {
        Purchase ret = purchaseRepository.findById(id);
        if(ret == null){
            throw new Exception("Compra inexistente!");
        }
        return ret;
    }
    public Set<Purchase> findAll(){return purchaseRepository.findAll();}
}
