package models.repositories;

import models.entities.Purchase;

import java.util.HashSet;
import java.util.Set;

public class PurchaseRepository {
    Set<Purchase> purchases;

    public PurchaseRepository(){purchases = new HashSet<Purchase>();}

    public Set<Purchase> findAll(){return new HashSet<>(purchases);}

    public void createPurchase(Purchase purchase){purchases.add(purchase);}

    public void deletePurchase(Purchase purchase){purchases.remove(purchase);}

    public boolean updatePurchase(Purchase purchase){
        Purchase aux = findById(purchase.getId());
        if(aux == null)return false;
        aux.setPayment(purchase.getPayment());
        aux.setDeliveryAddress(purchase.getDeliveryAddress());
        aux.setProductList(purchase.getProductList());
        aux.setStatus(purchase.getStatus());
        return true;
    }

    public Purchase findById(Integer id){
        for(Purchase purchase : purchases){
            if(purchase.getId() == id){
                return purchase;
            }
        }
        return null;
    }
}
