package org.codemanship;




public class CD {

    private int stock;
    private String artist;
    private String title;
    private Chart chart;

    public CD(String artist, String title, int stock) {
        this.stock = stock;
        this.artist = artist;
        this.title = title;
    }

    public int getStock() {
        return stock;
    }

    public void buy(CreditCard creditCard, int purchaseQuantity, Chart chart) {
        if (creditCard.payment()){
            stock = this.stock-purchaseQuantity;
        }
     chart.notify(this.getArtist(),this.getTitle(),purchaseQuantity);
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }
}
