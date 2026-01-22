import com.example.commerce.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //상품목록 생성
        Product p1 = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 1);
        Product p2 = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 1);
        Product p3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 1);
        Product p4 = new Product("AirPods pro", 350000, "노이즈 캔슬링 무선 이어폰", 1);

        //List에 상품목록 추가
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        int cmd = 1;

        while(cmd != 0) {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품]");
            for (int i=0; i< products.size(); i++) {
                Product p = products.get(i);
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