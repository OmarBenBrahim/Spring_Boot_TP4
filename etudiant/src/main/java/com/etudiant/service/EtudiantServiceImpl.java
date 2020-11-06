package com.etudiant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.etudiant.entities.Classe;
import com.etudiant.entities.Etudiant;
import com.etudiant.repos.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService{

	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Override
	public Etudiant saveEtudiant(Etudiant p) {
		return etudiantRepository.save(p);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant p) {
		return etudiantRepository.save(p);
	}

	@Override
	public void deleteEtudiant(Etudiant p) {
		etudiantRepository.delete(p);
		
	}

	@Override
	public void deleteEtudiantById(Long id) {
		etudiantRepository.deleteById(id);
		
	}

	@Override
	public Etudiant getEtudiant(Long id) {
		return etudiantRepository.findById(id).get();
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		
		return etudiantRepository.findAll();
	}

	@Override
	public Page<Etudiant> getAllEtudiantsParPage(int page, int size) {
		return etudiantRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Etudiant> findByNomEtudiant(String nom) {
		return etudiantRepository.findByNom(nom);
	}

	@Override
	public List<Etudiant> findByNomEtudiantContains(String nom) {
		return etudiantRepository.findByNomContains(nom);
	}

	@Override
	public List<Etudiant> findByNomMoy(String nom, Double moy) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByNomMoy(nom, moy);
	}

	@Override
	public List<Etudiant> findByClasse(Classe c) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByClasse(c);
	}

	@Override
	public List<Etudiant> findByClasseId(Long id) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByClasseIdClasse(id);
	}

	@Override
	public List<Etudiant> findByOrderByNomEtudiantAsc() {
		// TODO Auto-generated method stub
		return etudiantRepository.findByOrderByNomAsc();
	}

	@Override
	public List<Etudiant> trierEtudiantsNomsMoy() {
		// TODO Auto-generated method stub
		return etudiantRepository.trierEtudiantsNomsMoy();
	}
	
	

}
