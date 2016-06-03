/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twinoserver.modele;

public class Message {

    private int numMessage;
    private String titre;
    private String message;
    private String adresseMailExp; //expéditeur
    private String adresseMailDest; //destinataire
    private String dateHeure;
    private int estLu;

    public Message(int numMessage, String titre, String message, String adresseMailExp, String adresseMailDest, String dateHeure, int estLu) {
        this.numMessage = numMessage;
        this.titre = titre;
        this.adresseMailDest = adresseMailDest;
        this.adresseMailExp = adresseMailExp;
        this.estLu = estLu;
        this.message = message;
        this.dateHeure = dateHeure;
    }

    public int getNumMessage() {
        return numMessage;
    }

    public String getTitre() {
        return titre;
    }

    public String getMessage() {
        return message;
    }

    public String getAdresseMailExp() {
        return adresseMailExp;
    }

    public String getAdresseMailDest() {
        return adresseMailDest;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public int getEstLu() {
        return estLu;
    }

}
