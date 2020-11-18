package com.etudiant;



import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.etudiant.entities.Classe;
import com.etudiant.entities.Etudiant;
import com.etudiant.repos.EtudiantRepository;
import com.etudiant.service.EtudiantService;


@SpringBootTest
class EtudiantApplicationTests {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private EtudiantService etudiantService;
	
	@Test
	public void testCreateEtudiant() {
	Etudiant prod = new Etudiant("PC Asus",1500.500,new Date());
	etudiantRepository.save(prod);
	}
	
	@Test
	public void testFindEtudiant()
	{
	Etudiant p = etudiantRepository.findById(1L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdateEtudiant()
	{
	Etudiant p = etudiantRepository.findById(1L).get();
	p.setMoy(2000.0);
	etudiantRepository.save(p);
	
	System.out.println(p);
	}
	
	@Test
	public void testDeleteEtudiant()
	{
		etudiantRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllEtudiant()
	{
		List<Etudiant> prods = etudiantRepository.findAll();
		
		for (Etudiant p:prods)
			 System.out.println(p);
		
	}
	@Test
	public void testFindByNomEtudiantContains()
	{
	Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(0,2);
	System.out.println(etuds.getSize());
	
	System.out.println(etuds.getTotalElements());
	System.out.println(etuds.getTotalPages());
	etuds.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien 
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	@Test
	public void testFindByNomEtudiant()
	{
		List<Etudiant> etuds = etudiantRepository.findByNom("omar");
		for (Etudiant e : etuds)
		{
		System.out.println(e);
		}
	}
	@Test
	public void testFindByNomContains()
	{
		List<Etudiant> etuds = etudiantRepository.findByNomContains("m");
		for (Etudiant e : etuds)
		{
		System.out.println(e);
		}
	}
	
	@Test
	public void testfindByNomMoy()
		{
			List<Etudiant> etuds = etudiantRepository.findByNomMoy("Omar", 10.0);
				for (Etudiant e : etuds)
				{
				System.out.println(e);
				}
		}
	@Test
	public void testfindByNomMoy2()
		{											
			List<Etudiant> etuds = etudiantRepository.findByNomMoy2("Omar", 10.0);
				for (Etudiant e : etuds)
				{
				System.out.println(e);
				}
		}
	
	@Test
	public void testfindByClasse()
	{
	Classe c = new Classe();
	c.setIdClasse(1L);
	List<Etudiant> etuds = etudiantRepository.findByClasse(c);
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Etudiant> etuds = etudiantRepository.findByClasseIdClasse(1L);
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	}
	 }
	
	@Test
	public void testfindByOrderByNomEtudiantAsc()
	{
	List<Etudiant> etuds =etudiantRepository.findByOrderByNomAsc();
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void testTrierEtudiantNomsMoy()
	{
		List<Etudiant> prods = etudiantRepository.trierEtudiantsNomsMoy();
		for (Etudiant p : prods)
		{
		System.out.println(p);
		}
	}
	
	
}
