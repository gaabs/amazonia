package models.controls;

import models.collections.PurchaseCollection;
import models.entities.Purchase;

import java.util.Set;

public class PurchaseControl {
    public PurchaseCollection purchaseCollection;

    public PurchaseControl(PurchaseCollection purchaseCollection){
        this.purchaseCollection = purchaseCollection;
    }

    public void create(Purchase purchase){purchaseCollection.createPurchase(purchase);}
    public void delete(Purchase purchase){purchaseCollection.deletePurchase(purchase);}
    public boolean update(Purchase purchase) throws Exception {
        return purchaseCollection.updatePurchase(purchase);
    }
    public Set<Purchase> findAll(){return purchaseCollection.findAll();}
    public Purchase findById(Integer id) throws Exception {return purchaseCollection.findById(id);}
}
