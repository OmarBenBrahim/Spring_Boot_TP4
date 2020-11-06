package com.etudiant.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.etudiant.entities.Classe;
import com.etudiant.entities.Etudiant;

public interface EtudiantService {
	Etudiant saveEtudiant(Etudiant e);
	Etudiant updateEtudiant(Etudiant e);
	void deleteEtudiant(Etudiant e);
	void deleteEtudiantById(Long id);
	Etudiant getEtudiant(Long id);
	List<Etudiant> getAllEtudiants();

	
	Page<Etudiant> getAllEtudiantsParPage(int page, int size);
	
	List<Etudiant> findByNomEtudiant(String nom);
	List<Etudiant> findByNomEtudiantContains(String nom);
	List<Etudiant> findByNomMoy (String nom, Double prix);
	List<Etudiant> findByClasse (Classe c);
	List<Etudiant> findByClasseId(Long id);
	List<Etudiant> findByOrderByNomEtudiantAsc();
	List<Etudiant> trierEtudiantsNomsMoy();

	
	
}
