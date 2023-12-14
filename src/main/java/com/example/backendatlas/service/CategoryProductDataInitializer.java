package com.example.backendatlas.service;

import com.example.backendatlas.entity.Category;
import com.example.backendatlas.entity.Product;
import com.example.backendatlas.entity.User;
import com.example.backendatlas.repository.CategoryRepository;
import com.example.backendatlas.repository.ProductRepository;
import com.example.backendatlas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryProductDataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Autowired
    public CategoryProductDataInitializer(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(
                1,
                "Pizza"
        );
        Category category2 = new Category(
                2,
                "Retter"
        );
        Category category3 = new Category(
                3,
                "Drikkevarer"
        );

        List<Product> products = new ArrayList<Product>();

        products.add(new Product(
                1,
                "Margherita",
                "Tomat, ost",
                "https://eu.ooni.com/cdn/shop/articles/20220211142754-margherita-9920.jpg?crop=center&height=800&v=1644590277&width=800",
                60.0,
                category1
        ));
        products.add(new Product(
                2,
                "Vesuvio",
                "Kalkunstrimler",
                "https://static.mathem.se/shared/images/recipes/doublelarge/pizza-vesuvio.jpeg",
                75.0,
                category1
        ));
        products.add(new Product(
                3,
                "Carpricciosa",
                "Kalkunstrimler, champignon",
                "https://media-cdn.tripadvisor.com/media/photo-s/15/e6/eb/91/capriccio-pizzeria.jpg",
                80.0,
                category1
        ));
        products.add(new Product(
                4,
                "Hawaii",
                "Kalkunstrimler, ananas",
                "https://mambeno.dk/wp-content/uploads/2016/06/Mambenos-hawaiipizza.jpg",
                80.0,
                category1
        ));
        products.add(new Product(
                5,
                "Atlas Pizza",
                "Shawarma, champignon, paprika, aubergine, rucola",
                "https://static.mathem.se/shared/images/recipes/doublelarge/pizza-vesuvio.jpeg",
                85.0,
                category1
        ));
        products.add(new Product(
                6,
                "Shawarma",
                "Shawarma, champignon, paprika",
                "https://weirdandwildpizza.com/wp-content/uploads/2020/02/chkn-shawarma-main.jpg",
                85.0,
                category1
        ));
        products.add(new Product(
                7,
                "Salat pizza",
                "Shawarma, salat, dressing",
                "https://forumpizza.dk/wp-content/uploads/2013/06/salatpizza-forumpizza-479-1.jpg",
                85.0,
                category1
        ));
        products.add(new Product(
                8,
                "Salat pizza mix",
                "Shawarma, kylling, salat, dressing",
                "https://forumpizza.dk/wp-content/uploads/2013/06/salatpizza-forumpizza-479-1.jpg",
                90.0,
                category1
        ));
        products.add(new Product(
                9,
                "Kødstrimler",
                "Kødstrimler, champignon, ananas",
                "https://miro.medium.com/v2/resize:fit:1180/1*D2Crpw1q-kKoZbDZ5rXoEA.jpeg",
                85.0,
                category1
        ));
        products.add(new Product(
                10,
                "Kødboller",
                "Kødboller, paprika, oliven",
                "https://www.thecountrycook.net/wp-content/uploads/2023/03/thumbnail-Meatball-Pizza-scaled.jpg",
                85.0,
                category1
        ));
        products.add(new Product(
                11,
                "Beyti kebab ret",
                "Kalvekød, tzatziki, salat, tomatsauce, ris",
                "https://turkishfoodchef.com/wp-content/uploads/2018/09/Beyti-Kebab-Beyti-Kebabi-14-447x375.jpg",
                125.0,
                category2
        ));
        products.add(new Product(
                12,
                "Sac kavurma",
                "Kødstrimler, stegt tomat, løg, carliston peber, ris",
                "https://www.giverecipe.com/wp-content/uploads/2011/12/Turkish-sac-kavurma.jpg",
                125.0,
                category2
        ));
        products.add(new Product(
                13,
                "Iskender kebab ret",
                "Shawarma, tzatziki, tomatsauce, brød",
                "https://www.thespruceeats.com/thmb/WQ8STSH_DbawldRxEQ7AW9T9T0I=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/baqIMG_1160fsq-5b102541eb97de003619811d.jpg",
                125.0,
                category2
        ));
        products.add(new Product(
                14,
                "Chicken dipper 9 stk.",
                "Kylling, pommes frites, remoulade, salat, dressing",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEYyamZuND2s9Qsqty1hp0TrffSU9NdpQ07Q&usqp=CAU",
                85.0,
                category2
        ));
        products.add(new Product(
                15,
                "Coca-Cola 33cl",
                "",
                "https://nielsen.discount/wp-content/uploads/1000035.jpg",
                15.0,
                category3
        ));
        products.add(new Product(
                16,
                "Fanta 33cl",
                "",
                "https://bevco.b-cdn.net/thumbnail/93/41/76/1645126812/fanta-orange-24x33-cl-daase-463fb_644x644.png",
                15.0,
                category3
        ));
        products.add(new Product(
                17,
                "Ayran 33cl",
                "",
                "https://közgrill.dk/cdn/shop/products/Ayran.png?v=1646673298",
                13.0,
                category3
        ));

        User user1 = new User(
                "User",
                "1234"
        );

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        for(Product p : products) {
            productRepository.save(p);
        }
        userRepository.save(user1);
    }
}
