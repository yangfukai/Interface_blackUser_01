package com.black.model;

public class FctOrderPage extends FctOrder {
    private int start;
    private int length;
    private String sortFied;
    private String sort;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSortFied() {
        return sortFied;
    }

    public void setSortFied(String sortFied) {
        this.sortFied = sortFied;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
