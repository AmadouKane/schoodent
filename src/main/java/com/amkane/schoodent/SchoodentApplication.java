package com.amkane.schoodent;

import com.amkane.schoodent.entities.Classe;
import com.amkane.schoodent.entities.Etudiant;
import com.amkane.schoodent.repositories.ClasseRepository;
import com.amkane.schoodent.repositories.EtudiantRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoodentApplication implements CommandLineRunner {

    @Autowired
    private EtudiantRepository er;

    @Autowired
    private ClasseRepository cr;

    public static void main(String[] args) {
        SpringApplication.run(SchoodentApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Etudiant e1 = new Etudiant("M1", "KANE", "Amadou", df.parse("31/12/2019"), "77000000", "amkane@gm.com", "amkane.jpeg", "sn", null);
        Etudiant e2 = new Etudiant("M2", "LY", "Salif", df.parse("31/12/2019"), "77000000", "salif@gm.com", "salif.jpeg", "sn", null);
        Etudiant e3 = new Etudiant("M3", "DIAGNE", "Blaise", df.parse("31/12/2019"), "77000000", "blaise@gm.com", "blaise.jpeg", "sn", null);
        Etudiant e4 = new Etudiant("M4", "SALL", "Macky", df.parse("31/12/2019"), "77000000", "macky@gm.com", "macky.jpeg", "sn", null);
        Etudiant e5 = new Etudiant("M5", "DIOP", "Cheikh Anta", df.parse("31/12/2019"), "77000000", "cheikh@gm.com", "cheikh.jpeg", "sn", null);

        Classe c1 = new Classe("M2", "2014/2015");
        Classe c2 = new Classe("L1", "2018/2019");

        System.out.println(cr.save(c1));
        System.out.println(cr.save(c2));
        System.out.println("**********************************");

        e1.setClasse(c1);
        e2.setClasse(c1);

        e3.setClasse(c2);
        e4.setClasse(c2);
        e5.setClasse(c2);

        System.out.println(er.save(e1));
        System.out.println(er.save(e2));
        System.out.println(er.save(e3));
        System.out.println(er.save(e4));
        System.out.println(er.save(e5));
        System.out.println("**********************************");
        System.out.println(cr.save(e1.getClasse()));
        System.out.println("**********************************");
    }

}
