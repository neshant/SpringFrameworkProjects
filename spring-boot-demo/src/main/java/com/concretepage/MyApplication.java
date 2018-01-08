package com.concretepage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class MyApplication {  
	public static void main(String[] args) throws IOException {
		
		
		SpringApplication.run(MyApplication.class, args);
	List<String> nameList=	Files.lines(Paths.get("/home/neshant/Documents/workspace-sts-3.9.1.RELEASE/SpringFrameworkProjects/spring-boot-demo/pom.xml"))
		.filter(line->line.contains("name"))
		.map(line-> 
			line.trim().replaceAll("name", "")
				.replaceAll("<", "")
				.replaceAll(">", "")
				.replaceAll("/", "")).collect(Collectors.toList());
	
	System.out.println(nameList);
				
				
		
    }       
}            	