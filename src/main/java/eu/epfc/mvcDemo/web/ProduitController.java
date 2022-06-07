package eu.epfc.mvcDemo.web;

import com.sun.istack.NotNull;
import eu.epfc.mvcDemo.entities.Produit;
import eu.epfc.mvcDemo.repositoriesDAO.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;

    @RequestMapping(value="/index")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue = "0") int p,
                        @RequestParam(name="size",defaultValue = "5") int s,
                        @RequestParam(name = "motCle",defaultValue = "")String mc){
        Pageable paging = PageRequest.of(p,s);
        Page<Produit> pageProduits = produitRepository.chercher("%"+mc+"%", paging);
        model.addAttribute("listProduits",pageProduits.getContent());
        int[] pages = new int[pageProduits.getTotalPages()];
        model.addAttribute("pages",pages);
        model.addAttribute("size",s);
        model.addAttribute("pageCourante",p);
        model.addAttribute("motCle",mc);
        return "produits";
    }
    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public String delete(Long id, String motCle,int page, int size){
        produitRepository.deleteById(id);
        return "redirect:/index?page="+page+"&size="+size+"&motCle="+motCle;
    }

    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String edit(Model model,Long id){
        Optional<Produit> produit = produitRepository.findById(id);
            model.addAttribute("produit",produit.get());
        return "editProduit";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String formProduit(Model model){
        model.addAttribute("produit",new Produit());
        return "FormProduit";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Model model,
                       @Validated Produit produit,
                       BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "FormProduit";
        produitRepository.save(produit);
        return "Confirmation";
    }
}
