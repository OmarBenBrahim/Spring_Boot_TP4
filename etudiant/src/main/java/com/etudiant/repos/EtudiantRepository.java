package com.etudiant.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.etudiant.entities.Classe;
import com.etudiant.entities.Etudiant;

@RepositoryRestResource(path = "rest")
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	List<Etudiant> findByNom(String nom);
	List<Etudiant> findByNomContains(String nom);
	
	@Query("select e from Etudiant e where e.nom like %?1 and e.moy > ?2")
	List<Etudiant> findByNomMoy2 (String nom, Double moy);
		
	@Query("select e from Etudiant e where e.nom like %:nom and e.moy > :moy")
	List<Etudiant> findByNomMoy (@Param("nom") String nom,@Param("moy") Double moy);
	
	@Query("select e from Etudiant e where e.classe = ?1")
	List<Etudiant> findByClasse (Classe classe);
	
	List<Etudiant> findByClasseIdClasse(Long id);
	
	List<Etudiant> findByOrderByNomAsc();
	
	@Query("select e from Etudiant e order by e.nom ASC, e.moy DESC")
	List<Etudiant> trierEtudiantsNomsMoy ();

}
