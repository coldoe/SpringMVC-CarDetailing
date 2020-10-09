package com.kamiltest.demo;

import com.kamiltest.demo.doa.CarRepo;
import com.kamiltest.demo.doa.ClientRepo;
import com.kamiltest.demo.doa.model.Car;
import com.kamiltest.demo.doa.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Component
	class Dummy implements CommandLineRunner {

		@Autowired
		ClientRepo repo;
		CarRepo carRepo;

		@Override
		public void run(String... string) throws Exception {

			Client client = new Client();
			client.setId(1L);
			client.setContactNumber("997");
			client.setName("client00");
			client.setSurname("sryname");

			Car car = new Car();
			car.setId(1L);
			car.setMark("saab");
			car.setModel("9-3");
			car.setYear(2004);

			System.out.println(client);
			System.out.println(car);

			client.setCar(car);
			car.setClient(client);

//			carRepo.save(car);
			repo.save(client);

//			repo.findAll().forEach(p -> System.out.println(p.toString()));

		}
	}
}
