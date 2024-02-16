package com.Uday.ProductHunt.Controller;

import com.Uday.ProductHunt.Repo.productRepo;
import com.Uday.ProductHunt.Repo.rateRepo;
import com.Uday.ProductHunt.model.rate;
import com.Uday.ProductHunt.model.products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class productHuntController {

    @Autowired
    private  productRepo Repo1;
    @Autowired
    private  rateRepo Repo2;

    @GetMapping("/categories/engineering-development")
    public List home() {
        List<products> productList = Repo1.findAll();
        List<rate> rateList = Repo2.findAll();

        for (products pro : productList) {
            int totalRating = 0;
            for (rate r : rateList) {
                if (pro.get_id() == r.getId()) {
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


    @GetMapping("categories/engineering-development/order=most_followed")
    public List follow(){
        List<products> Product = Repo1.findAll();
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
