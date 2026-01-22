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

        int cmd = -1;

        while(cmd != 0) {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for(int i=0; i<categories.size(); i++){
                System.out.printf("%d. %s%n", i+1, categories.get(i).getCategoryName());
            }
            System.out.printf("%d. %-15s | %s%n",0, "종료", "프로그램 종료");
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
                try{
                    cmd = sc.nextInt();
                }catch(InputMismatchException e) {
                    System.out.println("올바르지 않은 입력입니다. 숫자를 입력해주세요.");
                    sc.nextLine(); //잘못 입력된 값을 버퍼에서 제거
                    continue;
                }
                if(cmd == 0) {
                    cmd = -1;
                }else if(cmd > 0 && cmd <= categories.get(idx).getProductList().size()){
                    int idx2 = cmd -1;
                    Product p = categories.get(idx).getProductList().get(idx2);

                    System.out.printf("%s: %-15s | %,10d원 | %s | 재고:%d개%n",
                            "선택한 상품",
                            p.getProductName(),
                            p.getPrice(),
                            p.getDetails(),
                            p.getStock()
                    );
                }else {
                    System.out.println("범위 안 숫자를 입력해주세요.");
                }
            }else {
                System.out.println("범위 안 숫자를 입력해주세요.");
            }
        }
        sc.close();
    }
}
