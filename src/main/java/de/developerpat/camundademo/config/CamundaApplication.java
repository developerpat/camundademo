package de.developerpat.camundademo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "de.developerpat")
public class CamundaApplication {

  public static void main(String[] args){
    SpringApplication.run(CamundaApplication.class, args);
  }
}
