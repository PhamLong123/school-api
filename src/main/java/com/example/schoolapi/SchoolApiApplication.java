package com.example.schoolapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "springdoc-openapi", version = "1.0.0"), security = {
		@SecurityRequirement(name = "bearer-key") })
public class SchoolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApiApplication.class, args);
	}

	// @Bean
	// CommandLineRunner init(UserRepository userRepository, RoleRepository roleRepository) {
	// 	return args -> {

	// 		Role studentRole = roleRepository.findByRole(UserRole.STUDENT);
	// 		if (studentRole == null) {
	// 			studentRole = new Role();
	// 			studentRole.setRole(UserRole.STUDENT);
	// 			roleRepository.save(studentRole);
	// 		}

	// 		Role parentRole = roleRepository.findByRole(UserRole.PARENTS);
	// 		if (parentRole == null) {
	// 			parentRole = new Role();
	// 			parentRole.setRole(UserRole.PARENTS);
	// 			roleRepository.save(parentRole);
	// 		}

	// 		Role schoolRole = roleRepository.findByRole(UserRole.SCHOOL);
	// 		if (schoolRole == null) {
	// 			schoolRole = new Role();
	// 			schoolRole.setRole(UserRole.SCHOOL);
	// 			roleRepository.save(schoolRole);
	// 		}

	// 		Role teacherRole = roleRepository.findByRole(UserRole.TEACHER);
	// 		if (teacherRole == null) {
	// 			teacherRole = new Role();
	// 			teacherRole.setRole(UserRole.TEACHER);
	// 			roleRepository.save(teacherRole);
	// 		}
	// 	};
	// }
}
