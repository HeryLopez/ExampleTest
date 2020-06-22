package com.jetbrains.handson.mpp.formation.dao;


import com.jetbrains.handson.mpp.formation.domaine.CompteBancaire;

public class CompteBancaireDAO {
	private CompteBancaire account1 = new CompteBancaire(1, 0);
	private CompteBancaire account2 = new CompteBancaire(2, 0);

	public CompteBancaire getAccount(int accountId) {
		if(accountId == 1) {
			return account1;
		} else if(accountId == 2) {
			return account2;
		} else {
			return null;
		}
	}

	public void saveAccount(CompteBancaire account) {
		if(account.getId() == 1) {
			this.account1 = account;
		} else if(account.getId() == 2) {
			this.account2 = account;
		} 
	}
}
