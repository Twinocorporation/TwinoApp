/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twinoserver.modele;

public class Evaluation {
	private int note;
	private String commentaire;
    
	public Evaluation(int note, String commentaire){
    	this.note = note;
    	this.commentaire = commentaire;
	}
    
	public int getNote(){
    	return this.note;
	}
    
	public String getCommentaire(){
    	return this.commentaire;
	}
}
