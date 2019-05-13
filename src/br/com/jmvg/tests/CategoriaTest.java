package br.com.jmvg.tests;

import br.com.jmvg.model.bean.Category;
import br.com.jmvg.model.bean.Product;
import br.com.jmvg.model.dao.DAOCategory;
import br.com.jmvg.model.dao.DAOProducty;

public class CategoriaTest {
    public static void main(String[] args) {

        Product product = new Product();
        Category category = new Category();
        DAOProducty dao = new DAOProducty();

        category.setId(2);
        product.setDescription("Arroz");
        product.setQuantity(10);
        product.setPrice(4.5);
        product.setCategory(category);

        dao.save(product);

    }

}
