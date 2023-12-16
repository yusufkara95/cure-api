package de.yusufkara.cureapi;

import de.yusufkara.cureapi.domain.Customer;
import de.yusufkara.cureapi.domain.Job;
import de.yusufkara.cureapi.repository.CustomerRepository;
import de.yusufkara.cureapi.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CureApiApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CureApiApplication.class);

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CureApiApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		// Add Customer objects and save these to db
		Customer customer1 = new Customer("Yusuf", "Kara", "Meeresstrasse", "33", "23111","Mülheim an der Ruhr","+492112213123", "katerina@cure.app");
		Customer customer2 = new Customer("Muhamed", "Emin", "Essenerstrasse", "98", "43212", "Essen", "+492112121263", "muhamedemin@cure.app");
		Customer customer3 = new Customer("Katerina", "Kati", "Kölnerstrasse", "20", "50321","Köln","+492112213123", "yusufkara@cure.app");
		Customer customer4 = new Customer("Max", "Mustermann", "Peterstrasse", "56", "38903","Berlin","+492112213123", "yusufkara@cure.app");
		Customer customer5 = new Customer("Gürsel", "Gürbüz", "Beulenstrasse", "766", "65342","Mannheim","+492112213123", "yusufkara@cure.app");

		customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3, customer4, customer5));

		Job job1 = new Job("Lenkrad", 200, customer1);
		Job job2 = new Job("Sitz", 425, customer2);
		jobRepository.saveAll(Arrays.asList(job1, job2));

		// Fetch all jobs and log to console
		for (Job job : jobRepository.findAll()) {
			logger.info(job.getName() + " " + job.getPrice());
		}
	}
}
