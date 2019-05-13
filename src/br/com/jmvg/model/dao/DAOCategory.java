package br.com.jmvg.model.dao;

import br.com.jmvg.connection.ConnectionFactory;
import br.com.jmvg.model.bean.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class DAOCategory {

    public Category save(Category category){
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            if(category.getId() == null){
                em.persist(category);
            }else{
                em.merge(category);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        return category;
    }

    public Category findById(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Category category = null;

        try{
            category = em.find(Category.class, id);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }finally {
            em.close();
        }
        return category;
    }
    public List<Category> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        List<Category> categories = null;

        try{
            categories = em.createQuery("from Category c").getResultList();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }finally {
            em.close();
        }
        return categories;
    }
    public Category remove(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Category category = null;
        try{
            category = em.find(Category.class, id);

            em.getTransaction().begin();
            em.remove(category);
            em.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return category;
    }
}
