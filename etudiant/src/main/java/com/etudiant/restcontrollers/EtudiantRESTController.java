package com.etudiant.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.etudiant.entities.Etudiant;
import com.etudiant.service.EtudiantService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EtudiantRESTController {

	@Autowired
	EtudiantService etudiantService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Etudiant> getAllProduits() {
	return etudiantService.getAllEtudiants();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Etudiant getEtudiant(@PathVariable("id") Long id) {
	return etudiantService.getEtudiant(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Etudiant createProduit(@RequestBody Etudiant etudiant) {
	return etudiantService.saveEtudiant(etudiant);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Etudiant updateProduit(@RequestBody Etudiant etudiant) {
	return etudiantService.updateEtudiant(etudiant);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
	etudiantService.deleteEtudiantById(id);
	}
	
	@RequestMapping(value="/prodscat/{idC}",method = RequestMethod.GET)
	public List<Etudiant> getProduitsByCatId(@PathVariable("idC") Long idC) {
	return etudiantService.findByClasseId(idC);
	}



	
	}

