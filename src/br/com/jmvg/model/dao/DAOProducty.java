package br.com.jmvg.model.dao;

import br.com.jmvg.connection.ConnectionFactory;
import br.com.jmvg.model.bean.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class DAOProducty {
    public Product save(Product product){
        EntityManager em = new ConnectionFactory().getConnection();
        try {

            em.getTransaction().begin();
            if(product.getId() == null){
                em.persist(product);
            }else {
                em.merge(product);
            }

            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return product;
    }

    public Product findById(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Product product = null;
        try{
            product = em.find(Product.class, id);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
        return product;
    }

    public List<Product> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        List<Product> products = null;
        try{
            products = em.createQuery("from Product p").getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
        return products;
    }
}
