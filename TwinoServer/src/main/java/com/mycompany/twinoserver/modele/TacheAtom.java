/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twinoserver.modele;

/**
 *
 * @author Jingyuan
 */
public class TacheAtom {

    private int numTacheAtom;
    private int numTache;
    private float latitudeT;
    private float longitudeT;
    private String dateTot;
    private String dateTard;
    private String description;
    private String titre;
    private float remuneration;
    private int estPaye;
    private int estEffectue;
    private String adresseMailExec;

    public TacheAtom(int numTacheAtom, int numTache, float latitudeT, float longitudeT,
            String dateTot, String dateTard, String titre, String description,
            float Remuneration, int estPaye, int estEffectue, String adresseMail) {
        this.numTacheAtom = numTacheAtom;
        this.numTache = numTache;
        this.adresseMailExec = adresseMail;
        this.latitudeT = latitudeT;
        this.longitudeT = longitudeT;
        this.dateTot = dateTot;
        this.dateTard = dateTard;
        this.titre = titre;
        this.description = description;
        this.estEffectue = estEffectue;
        this.estPaye = estPaye;
        this.remuneration = Remuneration;
    }

    public int getNumTacheAtom() {
        return this.numTacheAtom;
    }

    public int getNumTache() {
        return this.numTache;
    }

    public String getAdresseMailExec() {
        return this.adresseMailExec;
    }

    public float getLatitudeT() {
        return this.latitudeT;
    }

    public float getLongitudeT() {
        return this.longitudeT;
    }

    public String getDateTot() {
        return this.dateTot;
    }

    public String getDateTard() {
        return this.dateTard;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getDescription() {
        return this.description;
    }

    public float getRemuneration() {
        return this.remuneration;
    }

    public int getEstEffectue() {
        return this.estEffectue;
    }

    public int getEstPaye() {
        return this.estPaye;
    }

    @Override
    public String toString() {
        return "TacheAtom{" + "numTacheAtom=" + numTacheAtom + "numTache=" + numTache + "adresseMail=" + adresseMailExec + ",latitudeT=" + latitudeT + ", longitudeT=" + longitudeT + "dateTot=" + dateTot + ",dateTard=" + dateTard + ", titre=" + titre + ", description=" + description + "remuneration=" + remuneration + ",estEffectue=" + estEffectue + ", estPaye=" + estPaye + '}';
    }
}
