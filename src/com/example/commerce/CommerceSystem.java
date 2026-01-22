package com.example.commerce;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class CommerceSystem {
    private List<Category> categories;

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    public void start () {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        int cmd = -1;

        while(cmd != 0) {
            boolean isEmpty = cart.getCartList().isEmpty();
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            int i;
            for(i=0; i<categories.size(); i++){
                System.out.printf("%d. %s%n", i+1, categories.get(i).getCategoryName());
            }
            System.out.printf("%d. %-15s | %s%n",0, "종료", "프로그램 종료");

            if(!isEmpty) {
                System.out.println();
                System.out.println("[주문 관리]");
                System.out.printf("%d. %-15s | %s%n", categories.size()+1, "장바구니 확인", "장바구니를 확인 후 주문합니다.");
                System.out.printf("%d. %-15s | %s%n", categories.size()+2, "주문 취소", "진행중인 주문을 취소합니다.");
            }

            try{
               cmd = sc.nextInt();

           }catch(InputMismatchException e){
               System.out.println("올바르지 않은 입력입니다. 숫자를 입력해주세요.");
               sc.nextLine();
               continue;
           }

            if(cmd == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
            }else if(cmd>0 && cmd<=categories.size()) {
                 processCategory(sc, cmd, categories, cart);
            }else if(!isEmpty && cmd == categories.size()+1){
                processCart(sc,cart);
            }else if(!isEmpty && cmd == categories.size() +2){
                processCancelCart(sc, cart);
            }else {
                System.out.println("범위 안 숫자를 입력해주세요.");
            }
        }
        sc.close();
    }

    public void processCategory (Scanner sc, int category, List<Category> categories, Cart cart){
        int idx = category -1;
        System.out.printf("[ %s 카테고리 ]%n", categories.get(idx).getCategoryName());
        for (int j=0; j< categories.get(idx).getProductList().size(); j++) {
            Product p = categories.get(idx).getProductList().get(j);
            //formatted 출력으로 형식 맞추기
            System.out.printf("%d. %-15s | %,10d원 | %s%n",
                    j+1,
                    p.getProductName(),
                    p.getPrice(),
                    p.getDetails());
        }
        System.out.printf("%d. %s%n", 0, "뒤로가기");
        int product = -1;
        try{
            product = sc.nextInt();
        }catch(InputMismatchException e) {
            System.out.println("올바르지 않은 입력입니다. 숫자를 입력해주세요.");
            sc.nextLine(); //잘못 입력된 값을 버퍼에서 제거
        }
        if(product == 0) {
            product = -1;
        }else if(product > 0 && product <= categories.get(idx).getProductList().size()){
            int idx2 = product -1;
            Product p = categories.get(idx).getProductList().get(idx2);

            System.out.printf("%s: %-15s | %,10d원 | %s | 재고:%d개%n",
                    "선택한 상품",
                    p.getProductName(),
                    p.getPrice(),
                    p.getDetails(),
                    p.getStock()
            );
            System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
            System.out.printf("1. %-15s 2. %s%n", "확인", "취소");
            product = sc.nextInt();
            if(product == 1){
                System.out.println("담을 수량을 입력해 주세요.");
                product = sc.nextInt();
                cart.addItem(p, product);

            }else if(product != 2){
                System.out.println("범위 안 숫자를 입력해주세요.");
                sc.nextLine();
            }

        }else {
            System.out.println("범위 안 숫자를 입력해주세요.");
        }
    }

    public void processCart(Scanner sc, Cart cart){
        List<CartItem> c = cart.getCartList();
        int totalPrice = cart.getTotalPrice();
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ 장바구니 내역 ]");
        for (CartItem cartItem : c) {
            Product p = cartItem.getProduct();
            System.out.printf("%-15s | %,10d원 | %s | 수량:%d개%n",
                    p.getProductName(),
                    p.getPrice(),
                    p.getDetails(),
                    cartItem.getQuantity()
            );
        }
        System.out.println();
        System.out.println("[ 총 주문 금액]");
        System.out.printf("%,10d원",totalPrice);
        System.out.println();
        System.out.printf("1. %-15s 2. %s%n", "주문 확정", "메인으로 돌아가기");
        int cmd = sc.nextInt();

        if(cmd == 1){
            System.out.printf("주문이 완료되었습니다! 총 금액: %,10d원%n", totalPrice);
            cart.deleteAllItem();

        }else if(cmd != 2){
            System.out.println("범위 안 숫자를 입력해주세요.");
            sc.nextLine();
        }
    }

    public void processCancelCart(Scanner sc, Cart cart){
        List<CartItem> c = cart.getCartList();

        System.out.println("장바구니를 비우시겠습니까?");
        System.out.println();
        System.out.println("[ 장바구니 내역 ]");
        for (CartItem cartItem : c) {
            Product p = cartItem.getProduct();
            System.out.printf("%-15s | %,10d원 | %s | 수량:%d개%n",
                    p.getProductName(),
                    p.getPrice(),
                    p.getDetails(),
                    cartItem.getQuantity()
            );
        }

        System.out.printf("1. %-15s 2. %s%n", "주문 삭제", "메인으로 돌아가기");
        int cmd = sc.nextInt();
        if(cmd == 1){
            System.out.println("장바구니가 비워졌습니다.");
            for (CartItem item : c) {
                StockManager.addStock(item.getProduct(), item.getQuantity());
            }
            cart.deleteAllItem();

        }else if(cmd != 2){
            System.out.println("범위 안 숫자를 입력해주세요.");
            sc.nextLine();
        }
    }
}

