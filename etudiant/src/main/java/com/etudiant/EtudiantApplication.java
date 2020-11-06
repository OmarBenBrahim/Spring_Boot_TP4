package com.etudiant;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.etudiant.entities.Etudiant;
import com.etudiant.service.EtudiantService;

@SpringBootApplication
public class EtudiantApplication  implements CommandLineRunner {

	@Autowired
	EtudiantService etudiantservice ;
	public static void main(String[] args) {
		SpringApplication.run(EtudiantApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		etudiantservice.saveEtudiant(new Etudiant("Omar",12.5,new Date()));
//		etudiantservice.saveEtudiant(new Etudiant("Hichem",16.0,new Date()));
//		etudiantservice.saveEtudiant(new Etudiant("Imen",14.0,new Date()));
		
		
		
	}

}
