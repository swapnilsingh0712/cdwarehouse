package org.codemanship;




public class CD {

    private int stock;
    private String artist;
    private String title;
    private Chart chart;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public CD(String artist, String title, int stock, Chart chart, double price) {
        this.stock = stock;
        this.artist = artist;
        this.title = title;
        this.chart = chart;
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void buy(CreditCard creditCard, int purchaseQuantity) {
        if (creditCard.payment()){
            stock = this.stock-purchaseQuantity;
        }
        notifyChart(purchaseQuantity);
    }

    private void notifyChart(int purchaseQuantity) {
        this.chart.notify(this.getArtist(),this.getTitle(), purchaseQuantity);
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public void checkLowestPriceGurantee(Competitor competitor) {
        if (this.chart.getPosition("artist", "title") <= 100) {


            if (this.price >= competitor.getPrice()) {
                this.price = competitor.getPrice() - 1;
            }
        }
    }
}
