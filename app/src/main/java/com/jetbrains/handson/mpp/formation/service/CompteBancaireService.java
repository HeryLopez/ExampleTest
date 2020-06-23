package com.jetbrains.handson.mpp.formation.service;

import com.jetbrains.handson.mpp.formation.dao.CompteBancaireDAO;
import com.jetbrains.handson.mpp.formation.domaine.CompteBancaire;

public class CompteBancaireService {

	private CompteBancaireDAO dao = new CompteBancaireDAO();

	public CompteBancaireService(CompteBancaireDAO dao){
		this.dao = dao;
	}

	public void virement(int accountIn, int accountOut, int value) {
		CompteBancaire account1 = dao.getAccount(accountIn);
		CompteBancaire account2 = dao.getAccount(accountOut);
		
		account1.setSolde(account1.getSolde() + value);
		account2.setSolde(account2.getSolde() - value);
		
		dao.saveAccount(account1);
		dao.saveAccount(account2);
	}

	public CompteBancaire getAccount(int accountId) {
		return dao.getAccount(accountId);
	}
}
