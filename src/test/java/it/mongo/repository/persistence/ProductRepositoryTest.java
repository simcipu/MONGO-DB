/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.mongo.repository.persistence;

import com.google.gson.Gson;
import it.mongo.repository.ApplicationTest;
import it.mongo.repository.document.Customer;
import it.mongo.repository.document.Product;
import it.mongo.repository.dto.ProductDto;
import it.mongo.repository.utils.Mapper;
import java.util.List;
import java.util.Objects;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author simonecipullo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class ProductRepositoryTest {
    
    private Product pr=null;
    
    private Customer cu=null;
    
    @Autowired
    private Mapper map;
    
    @Autowired
    private ProductRepository repo;

    
    @Before
    public void setUp(){
    
        pr=new Product();
        cu=new Customer();
        
        cu.setCompany("myCopany");
        cu.setName("rossi");
        cu.setSurname("cipullo");
        
        
        pr.setSerialNumber("01");
        pr.setName("pomodori");
        pr.setType("legumi");
        pr.getProductCustumer().add(cu);
    
    
    }
    
    
    @Test
    public void simpleTest(){
    
    repo.save(pr);
    
    
    Product pr1=repo.findOne("01");
    
    assertTrue(!Objects.isNull(pr1));
    
    
   List<Product> list= repo.findByProductCustumer("cipullo");
   
   assertTrue(!list.isEmpty());

        List<Product> list1= repo.findAll();
        assertTrue(!list1.isEmpty());
    }
    
    
    @Test
    public void jsonSchema()
    {
    
      ProductDto dto=  map.map(pr);
    
      Gson g1 = new Gson();
       String obj=g1.toJson(dto,ProductDto.class);
        System.out.print(obj);
    
    
    }
    
    
    
}
