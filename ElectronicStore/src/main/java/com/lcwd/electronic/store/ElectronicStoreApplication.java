package com.lcwd.electronic.store;

import com.lcwd.electronic.store.entities.Role;
import com.lcwd.electronic.store.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
@EnableWebMvc
public class ElectronicStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicStoreApplication.class, args);
	}
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;
	@Value("${admin.role.id}")
	private String admin_role_id;
	@Value("${normal.role.id}")
	private String normal_role_id;
	@Override
	public void run(String... args) throws Exception {

		System.out.println(passwordEncoder.encode("123456"));

		try {
			Role role_admin = Role.builder().roleId(admin_role_id)
					.roleName("ROLE_ADMIN").build();
			Role role_normal = Role.builder().roleId(normal_role_id)
					.roleName("ROLE_NORMAL").build();
			roleRepository.save(role_admin);
			roleRepository.save(role_normal);

		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
