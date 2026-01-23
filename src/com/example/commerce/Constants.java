package com.example.commerce;

import java.util.Arrays;
import java.util.List;

public enum Constants {
    ADMIN_MENU(4, Arrays.asList("상품 추가", "상품 수정", "상품 삭제", "전체 상품 현황"));

    private final int num;
    private final List<String> list;

    Constants(int num, List<String> list ) {
        this.num = num;
        this.list = list;
    };
    public int getNum () {
        return num;
    }

    public List<String> getList() {
        return list;
    }
}
