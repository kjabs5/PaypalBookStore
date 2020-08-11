package com.kishor.paypalbookstore.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String passsword="kjabs6974";
		String encodedpass=encoder.encode(passsword);
		
		System.out.println(""+encodedpass);
		
		
		

	}

}
