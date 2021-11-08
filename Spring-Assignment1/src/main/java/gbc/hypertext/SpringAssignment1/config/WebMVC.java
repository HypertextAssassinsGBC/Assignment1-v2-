package gbc.hypertext.SpringAssignment1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
public class WebMVC implements WebMvcConfigurer {
    @Bean
    public ViewResolver ViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("../resources/templates/");
        bean.setSuffix(".html");
        return bean;
    }
    @Configuration
    public class MvcConfig implements WebMvcConfigurer {
        public void addViewControllers(ViewControllerRegistry registry){
            registry.addViewController("/").setViewName("login");
            registry.addViewController("/login").setViewName("login");
            registry.addViewController("/registration").setViewName("registration");
            registry.addViewController("/home").setViewName("index");
        }
    }
}