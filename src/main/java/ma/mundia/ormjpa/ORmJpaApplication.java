package ma.mundia.ormjpa;

import ma.mundia.ormjpa.entities.Product;
import ma.mundia.ormjpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ORmJpaApplication implements CommandLineRunner {

    @Autowired
    private  ProductRepository productRepository;


    public static void main(String[] args) {
        SpringApplication.run(ORmJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //productRepository.save(new Product(null, "p1", 4000, 100));
        //productRepository.save(new Product(null, "p2", 800, 50));
        //productRepository.save(new Product(null, "p3", 300, 40));

        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });

        Product product = productRepository.findById(Long.valueOf(2)).get();
        System.out.println("**********************");
        System.out.println("le nom du produit est " +product.getName());
        System.out.println("le prix du produit est " +product.getPrice()+"dhs");
        System.out.println("la quantité du produit est "+product.getQuantity());

        System.out.println("***************************************************");

        List<Product> product1 = productRepository.findByNameContains("p1");
        product1.forEach(p->{
            System.out.println(p.toString());

        });

        System.out.println("***************************************************");

        List<Product> product2 = productRepository.search("%p2%");
        product2.forEach(p->{
            System.out.println(p.toString());
        });

        System.out.println("***************************************************");

        List<Product> product3 = productRepository.findByPriceGreaterThan(600);
        product3.forEach(p->{
            System.out.println(p.toString());
        });

        System.out.println("***************************************************");


        List<Product> product4 = productRepository.searchByPrice(1000);
        product4.forEach(p->{
            System.out.println(p.toString());
        });

    }
}
