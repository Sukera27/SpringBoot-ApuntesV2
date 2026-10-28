package com.vedrunasevilla.tienda.persistance.model.enumlist;

public enum OrderStatus {
    PENDING,
    PAID,
    SHIPPED,
    CANCELLED;

    public boolean canChangeTo(OrderStatus next){
        if(this == PENDING){
            return next == PAID || next == CANCELLED;           
        }else if(this == PAID){
            return next == SHIPPED ||next == CANCELLED;
        }

        return false;
        
    }

    

    

}

