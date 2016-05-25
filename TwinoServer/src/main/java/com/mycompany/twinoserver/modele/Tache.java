/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twinoserver.modele;

import java.util.LinkedList;


public class Tache {

    private int numTache;
    private String descriptionT;
    private String adresseMail;
    private LinkedList<TacheAtom> tacheAtom;

    public Tache(int numTache, String descriptionT, String adresseMail, LinkedList<TacheAtom> tacheAtom) {
        this.numTache = numTache;
        this.descriptionT = descriptionT;
        this.adresseMail = adresseMail;
        this.tacheAtom = tacheAtom;
    }

    public int getNumTache() {
        return this.numTache;
    }

    public String getDescriptionT() {
        return this.descriptionT;
    }

    public String getAdresseMail() {
        return this.adresseMail;
    }

    public LinkedList<TacheAtom> getTacheAtom() {
        return this.tacheAtom;
    }

    @Override
    public String toString() {
        return "Tache{" + "numTache=" + numTache + "descriptionT=" + descriptionT + "adresseMail=" + adresseMail + '}';
    }
}
