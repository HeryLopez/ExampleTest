package com.jetbrains.handson.mpp.formation.mockito;

import com.jetbrains.handson.mpp.formation.dao.CompteBancaireDAO;
import com.jetbrains.handson.mpp.formation.domaine.CompteBancaire;
import com.jetbrains.handson.mpp.formation.service.CompteBancaireService;

import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MockitoTest {

    @Test
    public void testVirement(){
        // Initialize testing objects
        CompteBancaireDAO dao = Mockito.mock(CompteBancaireDAO.class);
        CompteBancaireService service = new CompteBancaireService(dao);

        // Mock methods
        int account1 = 1, account2 = 2;
        Mockito.when(dao.getAccount(account1)).thenReturn(new CompteBancaire(account1, 100));
        // Mockito.when(dao.getAccount(account2)).thenReturn(new CompteBancaire(account2, 1000));
        Mockito.doReturn(new CompteBancaire(account2,1000)).when(dao).getAccount(account2);

        // Call testing service
        service.virement(account1, account2, 100);

        // Verify result
        int account1Solde = service.getAccount(account1).getSolde();
        assertThat(account1Solde, is(equalTo(200)));

        int account2Solde = service.getAccount(account2).getSolde();
        assertThat(account2Solde, is(equalTo(900)));

        Mockito.verify(dao, Mockito.times(2)).getAccount(account1);
        Mockito.verify(dao, Mockito.atLeast(1)).getAccount(account2);
    }
}
