package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartList = new ArrayList<>();

    public List<CartItem> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartItem> cartList) {
        this.cartList = cartList;
    }

    public void deleteItem(String item) {
        cartList.stream()
                        .filter(p -> p.getProduct().getProductName().equals(item))
                        .toList()
                        .forEach( i -> cartList.remove(i)
                        );
    }

    public void deleteAllItem() {
        cartList.clear();
    }

    public void addItem(Product item, int amount) {
        if(StockManager.reduceStock(item, amount)){
            CartItem cartItem = new CartItem(item, amount);
            cartList.add(cartItem);
            System.out.printf("%s가 %d개 장바구니에 추가되었습니다.%n",item.getProductName(), amount );
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for(CartItem c : cartList){
            totalPrice += c.getTotalPrice();
        }
        return totalPrice;
    }
}
