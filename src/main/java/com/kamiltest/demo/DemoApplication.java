package com.kamiltest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	@Component
//	class Dummy implements CommandLineRunner {
//
//		@Autowired
//		ClientRepo repo;
//		CarRepo carRepo;
//
//		@Override
//		public void run(String... string) throws Exception {
//
////			Client client = new Client();
////			client.setId(100L);
////			client.setContactNumber("997");
////			client.setName("client00");
////			client.setSurname("sryname");
////
////			Car car = new Car();
////			car.setId(2L);
////			car.setMark("test");
////			car.setModel("9-3");
////			car.setYear(2004);
////
////			client.setCar(car);
////			car.setClient(client);
////
//////			carRepo.save(car);
////			repo.save(client);
//		}
//	}
}
