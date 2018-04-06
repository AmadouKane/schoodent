/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amkane.schoodent.service;

import com.amkane.schoodent.entities.Etudiant;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author amkane
 */
public interface IEtudiantSercive {

    public List<Etudiant> findAll();

    public Etudiant findOne(Long id);

    public void suprimer(Long id);

    public Etudiant modifier(Etudiant e);

    public Etudiant enregistrer(Etudiant e);
    
    public Page<Etudiant> chercher(String clef, int size, int page);
    
    public Etudiant chercherParMatricule(String Mtricule);
}
