package edu.citytech.cst3650.ds.model;
public record Stock (int id, String symbol) implements Comparable<Stock> {

    @Override
    public int compareTo(Stock o) {
        // TODO Auto-generated method stub
        return 0;
    }

};