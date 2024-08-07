package org.codemanship;

import org.codemanship.CreditCard;

public class CD {

    private int stock;

    public CD(int i) {
        this.stock = i;
    }

    public int getStock() {
        return stock;
    }

    public void buy(CreditCard creditCard) {
        if (creditCard.payment()){
            stock = this.stock-1;
        }
    }
}
