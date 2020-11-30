package com.etudiant.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etudiant.entities.Etudiant;
import com.etudiant.service.EtudiantService;

@Controller
public class EtudiantController {

	@Autowired
	EtudiantService etudiantService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("etudiant", new Etudiant());
	modelMap.addAttribute("mode", "new");
	return "formEtudiant";
	}
	
	@RequestMapping("/AjoutEtudiant")
	public String showCreate()
	{
	return "AjoutEtudiant";
	}

	@RequestMapping("/saveEtudiant")
	public String saveProduit(@Valid Etudiant etudiant, BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formEtudiant";
	 etudiantService.saveEtudiant(etudiant);
	 return "formEtudiant";
	}

	/*public String saveEtudiant(@RequestParam("date") String date,@RequestParam("nom") String nom,@RequestParam("moy") double moy , ModelMap modelMap) throws ParseException {
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 Etudiant etudiant = new Etudiant() ; 
		 etudiant.setDate(dateCreation);
		 etudiant.setNom(nom);
		 etudiant.setMoy(moy);
		 

		Etudiant saveEtudiant = etudiantService.saveEtudiant(etudiant);
		String msg ="etudiant enregistré avec Id "+saveEtudiant.getId();
		modelMap.addAttribute("msg", msg);
		return "AjoutEtudiant";
		*/
	
	
	@RequestMapping("/ListeEtudiant")
	public String listeetudiants(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size
			)
	{
		Page<Etudiant> etud = etudiantService.getAllEtudiantsParPage(page, size);
		modelMap.addAttribute("etudiants", etud);
		modelMap.addAttribute("pages", new int[etud.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeEtudiant";
	}
	
	
	@RequestMapping("/supprimerEtudiant")
	public String supprimerEtudiant(@RequestParam("id") Long id,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size ,
			ModelMap modelMap)
	{
	etudiantService.deleteEtudiantById(id);
	Page<Etudiant> etud = etudiantService.getAllEtudiantsParPage(page, size);
	modelMap.addAttribute("etudiants", etud);
	modelMap.addAttribute("pages", new int[etud.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeEtudiant";
	}
	
	@RequestMapping("/modifierEtudiant")
	public String editerEtudiant(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Etudiant e= etudiantService.getEtudiant(id);
	modelMap.addAttribute("e", e);
	modelMap.addAttribute("mode", "edit");
	return "formProduit";
	}
	
	@RequestMapping("/updateEtudiant")
	public String updateProduit(@RequestParam("nom") String nom,@RequestParam("moy") double moy,@RequestParam("id") Long id,
	@RequestParam("date") String date,
	
	 ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 Etudiant etudiant = new Etudiant(); 
	 etudiant.setId(id);
	 etudiant.setNom(nom);
	 etudiant.setMoy(moy);
	 etudiant.setDate(dateCreation);

	 etudiantService.updateEtudiant(etudiant);
	 List<Etudiant> e = etudiantService.getAllEtudiants();
	 modelMap.addAttribute("etudiants", e);
	return "listeEtudiant";
	}
	

}
