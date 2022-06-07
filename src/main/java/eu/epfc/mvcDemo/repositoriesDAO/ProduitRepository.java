package eu.epfc.mvcDemo.repositoriesDAO;

import eu.epfc.mvcDemo.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    @Query("select p from Produit p where p.designation like :x")
    public Page<Produit> chercher(@Param("x") String mc, Pageable pageable);
}