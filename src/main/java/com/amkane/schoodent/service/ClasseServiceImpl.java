/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amkane.schoodent.service;

import com.amkane.schoodent.entities.Classe;
import com.amkane.schoodent.repositories.ClasseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amkane
 */
@RestController
@CrossOrigin("*")
public class ClasseServiceImpl implements IClasseService {

    @Autowired
    private ClasseRepository cr;
    
     private static final String URL_PREFIX = "";
    private static final String ALL_CLASSE = "/classe/all";
    private static final String ONE_CLASSE = "/classe/{id}";
    private static final String DEL_CLASSE = "/classe/delete/{id}";
    private static final String UP_CLASSE = "/classe/update";
    private static final String SAVE_CLASSE = "/classe/save";
   

    @Override
    @RequestMapping(value = ALL_CLASSE, method = RequestMethod.GET)
    public List<Classe> findAll() {
        return cr.findAll();
    }

    @Override
    @RequestMapping(value = ONE_CLASSE, method = RequestMethod.GET)
    public Classe findOne(@PathVariable("id") Long id) {
        return cr.findOne(id);
    }

    @Override
    @RequestMapping(value = DEL_CLASSE, method = RequestMethod.GET)
    public void suprimer(@PathVariable("id") Long id) {
        cr.delete(id);
    }

    @Override
    @RequestMapping(value = UP_CLASSE, method = RequestMethod.PUT)
    public Classe modifier(@RequestBody Classe c) {
        return cr.saveAndFlush(c);
    }

    @Override
    @RequestMapping(value = SAVE_CLASSE, method = RequestMethod.POST)
    public Classe enregistrer(@RequestBody Classe c) {
        return cr.save(c);
    }

}
