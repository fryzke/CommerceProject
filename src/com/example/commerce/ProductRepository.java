package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public static List<Category> getAllCategories() {
        // 1. 전자제품 데이터 생성
        List<Product> eProducts = new ArrayList<>();
        eProducts.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10));
        eProducts.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 20));
        eProducts.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 26));
        eProducts.add(new Product("AirPods pro", 350000, "노이즈 캔슬링 무선 이어폰", 34));

        // 2. 의류 데이터 생성
        List<Product> cProducts = new ArrayList<>();
        cProducts.add(new Product("오버핏 코튼 티셔츠", 29000, "100% 순면 소재의 편안한 데일리룩", 50));
        cProducts.add(new Product("슬림핏 데님 팬츠", 59000, "신축성이 좋은 프리미엄 생지 데님", 30));
        cProducts.add(new Product("경량 다운 베스트", 89000, "보온성이 뛰어난 가을/겨울용 조끼", 20));

        // 3. 식품 데이터 생성
        List<Product> fProducts = new ArrayList<>();
        fProducts.add(new Product("유기농 햇사과 1kg", 12500, "경북 청송에서 직송한 당도 높은 사과", 100));
        fProducts.add(new Product("무항생제 닭가슴살", 3500, "운동 필수템, 냉동 보관 가능한 200g 팩", 200));
        fProducts.add(new Product("제주 삼다수 2L", 1200, "깨끗하고 믿을 수 있는 제주 화산 암반수", 500));

        // 4. 카테고리 구성
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("가전제품", eProducts));
        categories.add(new Category("의류", cProducts));
        categories.add(new Category("식품", fProducts));

        return categories;
    }
}
