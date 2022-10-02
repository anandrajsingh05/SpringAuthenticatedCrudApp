package com.hostbooks.SchoolManagementSystemAPI;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchoolManagementSystemApiApplication  {

//	@Autowired
//	private PasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(this.passwordEncoder.encode("anand@123"));
//	}
}
