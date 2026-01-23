package com.example.commerce;

public class StockManager {
    //재고 차감 가능 여부 확인
    public static boolean isAvailable (Product p, int quantity) {
        return p.getStock() >= quantity;
    }

    //재고 감소
    public static void reduceStock(Product p, int quantity){
        if(isAvailable(p, quantity)){
            p.setStock(p.getStock() - quantity);
        } else {
            System.out.println("재고가 부족합니다.");
        }
    }
    //재고 보충
    public static void addStock(Product p, int quantity){
        p.setStock(p.getStock() + quantity);
    }
}
