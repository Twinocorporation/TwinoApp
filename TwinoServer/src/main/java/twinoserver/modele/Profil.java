/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twinoserver.modele;

import java.util.LinkedList;

public class Profil {

    private String adresseMail;
    private String mdp;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String sexe;
    private float latitudeU;
    private float longitudeU;
    private LinkedList<String> competences;

    public Profil(String adresseMail, String mdp, String nom, String prenom,
            String sexe, String dateNaissance, float latitudeU, float longitudeU,
            LinkedList<String> competences) {
        this.adresseMail = adresseMail;
        this.dateNaissance = dateNaissance;
        this.latitudeU = latitudeU;
        this.longitudeU = longitudeU;
        this.nom = nom;
        this.mdp = mdp;
        this.prenom = prenom;
        this.sexe = sexe;
        this.competences = competences;
    }

    public String getAdresseMail() {
        return this.adresseMail;
    }

    public String getDateNaissance() {
        return this.dateNaissance;
    }

    public float getLatitudeU() {
        return this.latitudeU;
    }

    public float getLongitudeU() {
        return this.longitudeU;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getMdp() {
        return this.mdp;
    }

    public String getSexe() {
        return this.sexe;
    }

    public LinkedList<String> getCompetences() {
        return this.competences;
    }

    @Override
    public String toString() {
        String result = "TacheAtom{" + "adresseMail=" + adresseMail + "password="
                + mdp + "nom=" + nom + ",prenom=" + prenom + ", sexe=" + sexe
                + "dateNaissance=" + dateNaissance + ",latitudeU=" + latitudeU
                + ", longitudeU=" + longitudeU + "competences=";
        for (String s : competences) {
            result = result + s + ", ";
        }
        result += "}";
        return result;
    }
}
