package com.testdb;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.testdb.data.DataGenerator;
import com.testdb.repository.DataRepository;


@SpringBootApplication
@EnableAutoConfiguration
public class TestdbApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(TestdbApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(TestdbApplication.class, args);
	}
	
	@Autowired
	DataRepository dataRepository;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Starting - provisioning data");

		int rowQuantity = Integer.parseInt(args[0]);
		int workerQuantity = Integer.parseInt(args[1]);

		ExecutorService executor = Executors.newFixedThreadPool(workerQuantity);

		for (int x = 0; x < workerQuantity; x++) {
			executor.submit(() -> {
				log.info("Hi, I'm the worker " + Thread.currentThread().getName());
				DataGenerator generator = new DataGenerator(rowQuantity);
				List<Object[]> parameters = generator.generateData();
				System.out.println("Data: "+parameters);
				dataRepository.insertData(parameters);
				log.info(Thread.currentThread().getName() + " says goodbye!");
			});
		}

		executor.shutdown();

		while (!executor.isTerminated()) {

		}

		log.info("End - provisioning data");

	}
}
