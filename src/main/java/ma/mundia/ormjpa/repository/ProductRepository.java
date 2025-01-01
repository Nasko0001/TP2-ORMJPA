package ma.mundia.ormjpa.repository;

import ma.mundia.ormjpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    //---------Recherche par nom-------------------
    List<Product> findByNameContains(String kw);

    @Query("select p from Product p where p.name like :x")
    List<Product> search(@Param("x") String kw);

    //-----------Recherche par prix ----------------------
    List<Product> findByPriceGreaterThan(double price);

    @Query("select p from Product p where p.price >=:x")
    List<Product> searchByPrice (@Param("x") double price);









}
