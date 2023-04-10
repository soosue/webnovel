package com.toy.pay.novel.web;

import java.util.List;

public class ListResponse<T> {
    List<T> list;

    public ListResponse(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }
}
