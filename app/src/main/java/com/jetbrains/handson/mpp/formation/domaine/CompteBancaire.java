package com.jetbrains.handson.mpp.formation.domaine;

public class CompteBancaire {
	private int id;
	private int solde;

	public CompteBancaire(int id, int solde) {
		this.solde = solde;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSolde() {
		return solde;
	}
	public void setSolde(int value) {
		this.solde = value;
	}

}


