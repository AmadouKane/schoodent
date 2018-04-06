/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amkane.schoodent.service;

import com.amkane.schoodent.entities.Classe;
import java.util.List;

/**
 *
 * @author amkane
 */
public interface IClasseService {

    public List<Classe> findAll();

    public Classe findOne(Long id);

    public void suprimer(Long id);

    public Classe modifier(Classe c);

    public Classe enregistrer(Classe c);
}
