package com.mi.intdo;

import java.util.HashSet;
import java.util.Set;

import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext subApplicationContext = null;
        SpringCamelContext springCamelContext = null;
        Resource[] resources = applicationContext.getResources("classpath*:**fuse/**/*.xml");

        Set<String> set = new HashSet<>();
        for (Resource resource : resources) {
            set.add(resource.getFilename());
        }

        for (String filename : set) {
            subApplicationContext = new ClassPathXmlApplicationContext(
                    new String[] { "classpath*:**fuse/**/" + filename }, applicationContext);
            springCamelContext = subApplicationContext.getBean(SpringCamelContext.class);
            springCamelContext.start();
        }
    }

}