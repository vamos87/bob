//package pl.coderslab.bob.converter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//import pl.coderslab.bob.entity.Bank;
//import pl.coderslab.bob.entity.Product;
//import pl.coderslab.bob.repository.BankRepository;
//import pl.coderslab.bob.repository.ProductRepository;
//
//public class ProductConverter implements Converter<String, Product> {
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Override
//    public Product convert(String source) {
//        Product product = productRepository.getProductById(Long.parseLong(source));
//        return product;
//    }
//
//}
//
