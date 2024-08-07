package org.codemanship;

import org.codemanship.CreditCard;

public class CD {

    private int stock;

    public CD(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void buy(CreditCard creditCard, int purchaseQuantity) {
        if (creditCard.payment()){
            stock = this.stock-purchaseQuantity;
        }
    }
}
