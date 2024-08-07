package org.codemanship;




public class CD {

    private int stock;
    private String artist;
    private String title;
    private Chart chart;

    public CD(String artist, String title, int stock, Chart chart) {
        this.stock = stock;
        this.artist = artist;
        this.title = title;
        this.chart = chart;
    }

    public int getStock() {
        return stock;
    }

    public void buy(CreditCard creditCard, int purchaseQuantity) {
        if (creditCard.payment()){
            stock = this.stock-purchaseQuantity;
        }
     this.chart.notify(this.getArtist(),this.getTitle(),purchaseQuantity);
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }
}
