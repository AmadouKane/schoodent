/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amkane.schoodent.repositories;

import com.amkane.schoodent.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amkane
 */
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    @Query("select e from Etudiant e where e.nom like :clef or e.prenom like :clef")
    public Page<Etudiant> rechercher(@Param("clef") String clef, Pageable pg);

    public Etudiant findByMatricule(String matricule);
}
