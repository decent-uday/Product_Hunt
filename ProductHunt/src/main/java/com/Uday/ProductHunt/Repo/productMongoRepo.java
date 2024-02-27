//package com.Uday.ProductHunt.Repo;
//
//import com.mongodb.client.*;
//import org.bson.Document;
//
//import java.util.HashMap;
//import java.util.Iterator;
//
//public class productMongoRepo {
//    public static void main(String[] args) {
//        // Connection string format: mongodb://username:password@host:port/database
//        String connectionString = "mongodb://localhost:27017/ProductHunt";
//
//        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
//            MongoDatabase db = mongoClient.getDatabase("ProductHunt");
//
//            MongoCollection<Document> p = db.getCollection("products");
//            FindIterable<Document> itr = p.find();
//            HashMap<String, Object> hs = new HashMap<>();
//            hs.put("_id","21");
//            hs.put("productName", "Gopi");
//            hs.put("reviews", 200);
//            hs.put("description", "A Java library for building user interfaces.");
//            hs.put("category", "Engineering & Development");
//            hs.put("launchDate", "2003-02-20");
//            hs.put("website", "https://gopijava.org/");
//
//            Document dd = new Document(hs);
//            p.insertOne(dd);
//
//            for (Document document : itr)
//                System.out.println(document);
//            System.out.println("Connected to MongoDB successfully!");
//        } catch (Exception e) {
//            System.err.println("Error connecting to MongoDB: " + e.getMessage());
//        }
//    }
//}
