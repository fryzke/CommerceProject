import com.example.commerce.Category;
import com.example.commerce.CommerceSystem;
import com.example.commerce.ProductRepository;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Category> categories = ProductRepository.getAllCategories();
        //Commerce System Start

        CommerceSystem cs = new CommerceSystem(categories);
        cs.start();

    }
}