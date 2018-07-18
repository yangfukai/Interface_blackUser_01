package com.black.controller.testbean;

import com.black.controller.page.PageBase;
import com.black.model.FctOrder;

import java.util.List;

public class RetBean extends PageBase {

    private List<FctOrder> data;

    public List<FctOrder> getData() {
        return data;
    }

    public void setData(List<FctOrder> data) {
        this.data = data;
    }
}
