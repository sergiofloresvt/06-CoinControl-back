package tup.CoinControlSinUserBackend.datainitializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import tup.CoinControlSinUserBackend.model.Category;
import tup.CoinControlSinUserBackend.repository.CategoryRepository;

@Component
public class CategoryInitializer implements CommandLineRunner{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) {
        if(categoryRepository.count()==0){
        Category category1 = new Category();
        category1.setName("Alimentos");
        category1.setIcons("fastfood");
        category1.setColor("blue");
        categoryRepository.save(category1);

        Category category2 = new Category();
        category2.setName("Transporte");
        category2.setIcons("garage");
        category2.setColor("white");
        categoryRepository.save(category2);

        Category category3 = new Category();
        category3.setName("Impuestos");
        category3.setIcons("receipt-log");
        category3.setColor("purple");
        categoryRepository.save(category3);

        Category category4 = new Category();
        category4.setName("Salud");
        category4.setIcons("health_and_safety");
        category4.setColor("rgb(255, 0, 0)");
        categoryRepository.save(category4);

                System.out.println("Categorías creadas y guardadas en la base de datos.");
        } else {
            System.out.println("Las categorías ya existen en la base de datos. No se crearon nuevamente.");
        }

    }
}
