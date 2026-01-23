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
            CartItem existingItem = findCartItem(item);
            int currentAmount = (existingItem != null) ? existingItem.getQuantity() : 0;

            int totalRequest = currentAmount + amount;
            int available = item.getStock();

            if(totalRequest > available){
                System.out.printf("재고가 부족합니다. (현재 재고: %d개 / 장바구니: %d개)%n",
                        available, currentAmount);
                return;
            }
            if(existingItem != null){//이미 존재하는 물건이면 amount 업데이트
                existingItem.updateQuantity(amount);
            }else {//새로 들어온 물건이면 추가
                CartItem cartItem = new CartItem(item, amount);
                cartList.add(cartItem);
            }
            System.out.printf("%s가 %d개 장바구니에 추가되었습니다.%n",item.getProductName(), amount );
    }

    private CartItem findCartItem(Product p){//리스트를 순회하며 일치하는 카트 아이템 탐색
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
