package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.kafka.client.KafkaProduerClient;
import com.example.demo.model.student;
import com.example.demo.repo.StudentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	KafkaProduerClient client;

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Iterable<student> stdt = studentRepo.findAll();

		System.out.println(stdt);
		
		ObjectMapper obj = new ObjectMapper();
		
		for (student std : stdt) {
			String std_json = obj.writeValueAsString(std);
			System.out.println(std_json);
			
			client.producer(std_json);

		
		}
		
	}

}
