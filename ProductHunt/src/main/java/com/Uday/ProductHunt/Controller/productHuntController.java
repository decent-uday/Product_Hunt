package com.Uday.ProductHunt.Controller;

import com.Uday.ProductHunt.Repo.productRepo;
import com.Uday.ProductHunt.Repo.rateRepo;
import com.Uday.ProductHunt.Repo.signupRepo;
import com.Uday.ProductHunt.model.SignUp;
import com.Uday.ProductHunt.model.rate;
import com.Uday.ProductHunt.model.products;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@Validated
public class productHuntController {

    @Autowired
    private  productRepo Repo1;
    @Autowired
    private  rateRepo Repo2;
    @Autowired
    private signupRepo Repo3;

    @PostMapping("/signup")
    public List<SignUp> create(@RequestBody @Valid  SignUp signUp) {
//        return "Hello";
        try {
            for (SignUp i : Repo3.findAll()) {
                if (i.getEmail().equals(signUp.getEmail())) {
                    throw new Exception();
                }
            }
            List<SignUp> cred = List.of(Repo3.save(signUp));
            return cred;
        } catch (Exception e) {
            System.out.println("Email already exists");
        }
        return null;
    }
    
    @GetMapping("signing")
    public List signin(String email, String password){
//        System.out.print(email+""+password);
        List<SignUp> creds = Repo3.findAll();
        for(SignUp i : creds){
            if(i.getEmail().equals(email) && i.getPassword().equals(password)){
                return home();
            }
        }
        return null;
    }

    @GetMapping("allemails")
    public List emails(){
        List emails = new ArrayList();
        try {
            for (SignUp i : Repo3.findAll()) {
                emails.add(i.getEmail());
            }
            return emails;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @GetMapping("/categories/engineering-development")
    public List home() {
        List<products> productList = Repo1.findAll();
        List<rate> rateList = Repo2.findAll();

        for (products pro : productList) {
            int totalRating = 0;
            for (rate r : rateList) {
                if (pro.get_id().equals(r.getId())) {
                    List<rate.Rating> ratings = r.getRatings();

                    if (ratings != null) {
                        for (rate.Rating rr : ratings) {
//                            System.out.println(rr.getRating());
                            totalRating += (int)rr.getRating();
                        }
                    }
                }
            }
//            System.out.println(totalRating);
            int star = (totalRating / 5);
//            System.out.println(star);
            pro.setStars(star);
        }

        return productList;
    }

    @GetMapping("/categories/engineering-development/{productName}")
    public List findByproductName(@PathVariable String productName){
        List<products> productByName = Repo1.findByproductName(productName);
        return productByName;
    }

    @GetMapping("categories/engineering-development/order=most_followed")
    public List follow(){
        List<products> Product = home();
        ArrayList<products> pro = new ArrayList<>();
        for(products p : Product){
            if(p.getReviews() > 100){
                pro.add(p);
            }
        }
        return pro;
    }

    @GetMapping("categories/engineering-development/order=most_recent")
    public List recent(){
        List pro = home();
        pro.sort(Comparator.comparing(products::getLaunchDate).reversed());
        return pro;
//        // Create a Sort object to specify the sorting order
//        Sort sort = Sort.by(Sort.Order.desc("launchDate"));
//        // Fetch and return the sorted list of products
//        return Repo1.findAll(sort);
    }

    @GetMapping("/getproducts")
    public List<products> getAllProducts() {
        List<products> Product = Repo1.findAll();
        return Product;
    }

    @PostMapping("/postproducts")
    public List<products> createProduct(@RequestBody products Product) {
        List<products> savedProduct = List.of(Repo1.save(Product));
        return savedProduct;
    }

    @GetMapping("/getrates")
    public List<rate> getAllRates() {
        List<rate> rates = Repo2.findAll();
        return rates;
    }

    @PostMapping("/postrates")
    public List<rate> createRate(@RequestBody rate Rate) {
        List<rate> savedRate = List.of(Repo2.save(Rate));
        return savedRate;
    }

}
