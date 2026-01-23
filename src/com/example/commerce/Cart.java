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
            CartItem existingItem = findCartItem(item);

            if(existingItem != null){//이미 존재하는 물건이면 amount 업데이트
                existingItem.upadateQunatity(amount);
            }else {//새로 들어온 물건이면 추가
                CartItem cartItem = new CartItem(item, amount);
                cartList.add(cartItem);
            }
            System.out.printf("%s가 %d개 장바구니에 추가되었습니다.%n",item.getProductName(), amount );
        }
    }

    private CartItem findCartItem(Product p){
        for(CartItem ci : cartList){
            if(ci.getProduct().equals(p)){
                return ci;
            }
        }
        return null;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for(CartItem c : cartList){
            totalPrice += c.getTotalPrice();
        }
        return totalPrice;
    }
}
