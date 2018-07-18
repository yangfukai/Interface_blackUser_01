package com.black.controller.page;

public abstract class PageBase {
    private String draw;
    /**
     * 表的总记录数 必要
     */
    private int recordsTotal;
    /**
     * //条件过滤后记录数 必要
     */
    private int recordsFiltered;

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
