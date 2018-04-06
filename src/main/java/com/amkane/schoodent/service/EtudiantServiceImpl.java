/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amkane.schoodent.service;

import com.amkane.schoodent.entities.Etudiant;
import com.amkane.schoodent.repositories.EtudiantRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amkane
 */
@RestController
@CrossOrigin("*")
public class EtudiantServiceImpl implements IEtudiantSercive {

    private static final String URL_PREFIX = "";
    private static final String ALL_STUDENT = "/etudiant/all";
    private static final String ONE_STUDENT = "/etudiant/{id}";
    private static final String DEL_STUDENT = "/etudiant/delete/{id}";
    private static final String UP_STUDENT = "/etudiant/update";
    private static final String SAVE_STUDENT = "/etudiant/save";
    private static final String BY_KEY_STUDENT = "/etudiant/all/byKey";
    private static final String BY_MAT_STUDENT = "/etudiant/find/{matricule}";

    
    @Autowired
    private EtudiantRepository er;

    @Override
    @RequestMapping(value = ALL_STUDENT, method = RequestMethod.GET)
    public List<Etudiant> findAll() {
        return er.findAll();
    }

    @Override
    @RequestMapping(value = ONE_STUDENT, method = RequestMethod.GET)
    public Etudiant findOne(@PathVariable("id") Long id) {
        return er.findOne(id);
    }

    @Override
    @RequestMapping(value = DEL_STUDENT, method = RequestMethod.DELETE)
    public void suprimer(@PathVariable("id") Long id) {
        er.delete(id);

    }

    @Override
    @RequestMapping(value = UP_STUDENT, method = RequestMethod.PUT)
    public Etudiant modifier(Etudiant e) {
        return er.save(e);
    }

    @Override
    @RequestMapping(value = SAVE_STUDENT, method = RequestMethod.POST)
    public Etudiant enregistrer(@RequestBody Etudiant e) {
        return er.save(e);
    }

    @Override
    @RequestMapping(value = BY_KEY_STUDENT, method = RequestMethod.GET)
    public Page<Etudiant> chercher(
            @RequestParam("clef") String clef,
            @RequestParam("size") int size,
            @RequestParam("page") int page) {

        return er.rechercher("%"+clef+"%", new PageRequest(page, size));
    }

    @Override
    @RequestMapping(value = BY_MAT_STUDENT, method = RequestMethod.GET)
    public Etudiant chercherParMatricule(@PathVariable("matricule") String Mtricule) {
        return er.findByMatricule(Mtricule);
    }

}
