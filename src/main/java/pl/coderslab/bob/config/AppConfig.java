package pl.coderslab.bob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.bob.converter.BankConverter;
import pl.coderslab.bob.converter.InstrumentTypeConverter;
//import pl.coderslab.bob.converter.ProductConverter;
//import pl.coderslab.converter.AuthorConverter;
//import pl.coderslab.converter.CategoryConverter;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab.bob")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.coderslab.bob.repository")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("BobPersistenceUnit");
        return emfb; }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm; }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:assets/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getInstrumentTypeConverter());
        registry.addConverter(getBankConverter());
//        registry.addConverter(getProductConverter());
    }

    @Bean
    public InstrumentTypeConverter getInstrumentTypeConverter() {
        return new InstrumentTypeConverter();
    }

    @Bean
    public BankConverter getBankConverter() {
        return new BankConverter();
    }

//    @Bean
//    public ProductConverter getProductConverter() {
//        return new ProductConverter();
//    }

    @Bean
    public Validator validator()	{
        return	new LocalValidatorFactoryBean();
    }
}
