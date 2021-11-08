/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: sets the view resolver and basic controller names
 *********************************************************************************/

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
            registry.addViewController("/registration").setViewName("register-form");
            registry.addViewController("/home").setViewName("index");
        }
    }
}