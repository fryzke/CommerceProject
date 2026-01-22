import com.example.commerce.CommerceSystem;
import com.example.commerce.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        //Commerce System Start

        CommerceSystem cs = new CommerceSystem(products);
        cs.start();

    }
}