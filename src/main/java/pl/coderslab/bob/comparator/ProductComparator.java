package pl.coderslab.bob.comparator;

import pl.coderslab.bob.entity.Product;

import java.util.Comparator;


public class ProductComparator implements Comparator<Product> {

    public ProductComparator() {
    }

    @Override
    public int compare(Product product1, Product product2) {
        return (int) (product2.getPopularity() - product1.getPopularity());
    }
}
