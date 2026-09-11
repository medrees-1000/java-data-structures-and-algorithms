package edu.citytech.cst3650.ds.model;

public record MyStock(String symbol, float price) implements Comparable<MyStock> {

    @Override
    public int compareTo(MyStock o) {
        // Compares this stock's price with the other stock's price
        return Float.compare(this.price, o.price);
    }
}
