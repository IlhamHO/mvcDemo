package eu.epfc.mvcDemo;

import eu.epfc.mvcDemo.entities.Produit;
import eu.epfc.mvcDemo.repositoriesDAO.ProduitRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MvcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MvcDemoApplication.class, args);
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("LX 4352", 670, 90));
		produitRepository.save(new Produit("ord HP 432", 670, 90));
		produitRepository.save(new Produit("Imprimante Epson", 450, 12));
		produitRepository.save(new Produit("Imp HP 5400", 45, 10));
		produitRepository.save(new Produit("LX 4352", 670, 90));
		produitRepository.save(new Produit("ord HP 432", 670, 90));
		produitRepository.save(new Produit("Imprimante Epson", 450, 12));
		produitRepository.save(new Produit("Imp HP 5400", 45, 10));
		produitRepository.save(new Produit("LX 4352", 670, 90));
		produitRepository.save(new Produit("ord HP 432", 670, 90));
		produitRepository.save(new Produit("Imprimante Epson", 450, 12));
		produitRepository.save(new Produit("Imp HP 5400", 45, 10));
		produitRepository.save(new Produit("LX 4352", 670, 90));
		produitRepository.save(new Produit("ord HP 432", 670, 90));
		produitRepository.save(new Produit("Imprimante Epson", 450, 12));
		produitRepository.save(new Produit("Imp HP 5400", 45, 10));
		produitRepository.save(new Produit("LX 4352", 670, 90));
		produitRepository.save(new Produit("ord HP 432", 670, 90));
		produitRepository.save(new Produit("Imprimante Epson", 450, 12));
		produitRepository.save(new Produit("Imp HP 5400", 45, 10));

		produitRepository.findAll().forEach(produit -> System.out.println(produit.getDesignation()));
	}

}
