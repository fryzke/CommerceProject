package com.example.commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private List<Category> categories;

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    public void start () {
        Scanner sc = new Scanner(System.in);

        int cmd = 1;

        while(cmd != 0) {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for(int i=0; i<categories.size(); i++){
                System.out.printf("%d. %s%n", i+1, categories.get(i).getCategoryName());
            }
            System.out.printf("%d. %-15s | %s%n",0, "종료", "프로그램 종료");
            cmd = sc.nextInt();

            if(cmd == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
            }else {
                int idx = cmd -1;
                System.out.printf("[ %s 카테고리 ]%n", categories.get(idx).getCategoryName());
                for (int i=0; i< categories.get(idx).getProductList().size(); i++) {
                    Product p = categories.get(idx).getProductList().get(i);
                    //formatted 출력으로 형식 맞추기
                    System.out.printf("%d. %-15s | %,10d원 | %s%n",
                            i+1,
                            p.getProductName(),
                            p.getPrice(),
                            p.getDetails());
                }
                System.out.printf("%d. %s%n", 0, "뒤로가기");
                cmd = sc.nextInt();
                if(cmd == 0) {
                    cmd = 1;
                }else {
                    int idx2 = cmd -1;
                    Product p = categories.get(idx).getProductList().get(idx2);

                    System.out.printf("%s: %-15s | %,10d원 | %s | 재고:%d개%n",
                            "선택한 상품",
                            p.getProductName(),
                            p.getPrice(),
                            p.getDetails(),
                            p.getStock()
                    );
                }
            }
        }
        sc.close();
    }
}
