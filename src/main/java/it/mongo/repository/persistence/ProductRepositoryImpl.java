/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.mongo.repository.persistence;

import it.mongo.repository.document.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author simonecipullo
 */
@NoRepositoryBean
public class ProductRepositoryImpl implements MongoTemplateRepository{
    
    @Autowired
    private MongoTemplate mongoTemplate; 

    @Override
    public List<Product> findByProductCustumer(String surname) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productCustumer.surname").is(surname));
        query.fields().include("productCustumer.$");
        query.fields().include("type");
        query.fields().include("name");
        
        
        return mongoTemplate.find(query, Product.class);
    }
    
}
