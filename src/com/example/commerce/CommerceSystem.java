package com.example.commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private List<Product> productList;

    public CommerceSystem(List<Product> productList) {
        this.productList = productList;
    }

    public void start () {
        Scanner sc = new Scanner(System.in);

        int cmd = 1;

        while(cmd != 0) {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품]");
            for (int i=0; i< productList.size(); i++) {
                Product p = productList.get(i);
                //formatted 출력으로 형식 맞추기
                System.out.printf("%d. %-15s | %,10d원 | %s%n",
                        i,
                        p.getProductName(),
                        p.getPrice(),
                        p.getDetails());
            }
            System.out.printf("%d. %-13s | %s%n", 0, "종료", "프로그램 종료");

            cmd = sc.nextInt();

            if(cmd == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
            }
        }
        sc.close();
    }
}
