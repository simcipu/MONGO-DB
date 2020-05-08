/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.mongo.repository.persistence;

import it.mongo.repository.document.Product;
import java.util.List;

/**
 *
 * @author simonecipullo
 */
public interface MongoTemplateRepository {

   
    List<Product> findByProductCustumer(String surname);
    
}
