package com.dell.eureka;

 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {
 public static void main(String[] args) {// http://localhost:6868/
  SpringApplication.run(EurekaServer.class,args);

 }
}
