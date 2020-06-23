package com.jetbrains.handson.mpp.formation.mockito;

import com.jetbrains.handson.mpp.formation.categories.SlowTests;
import com.jetbrains.handson.mpp.formation.dao.CompteBancaireDAO;
import com.jetbrains.handson.mpp.formation.domaine.CompteBancaire;
import com.jetbrains.handson.mpp.formation.service.CompteBancaireService;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Category({SlowTests.class})
public class MockitoSpyTest {

    @Spy
    CompteBancaireDAO dao = new CompteBancaireDAO();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVirementNoMock(){
        CompteBancaireService service = new CompteBancaireService(dao);
        int account1 = 1, account2 = 2;
        service.virement(account1, account2, 100);

        // Account solde is 0 par defaut

        int account1Solde = service.getAccount(account1).getSolde();
        assertThat(account1Solde, is(equalTo(100)));

        int account2Solde = service.getAccount(account2).getSolde();
        assertThat(account2Solde, is(equalTo(-100)));
    }

    @Test
    public void testVirement() {
        // Initialize testing objects

        CompteBancaireService service = new CompteBancaireService(dao);

        // Mock methods
        int account1 = 1, account2 = 2;
        Mockito.when(dao.getAccount(account1)).thenReturn(new CompteBancaire(account1, 100));
        Mockito.when(dao.getAccount(account2)).thenReturn(new CompteBancaire(account2, 1000));

        // Call testing service
        service.virement(account1, account2, 100);

        // Verify result
        int account1Solde = service.getAccount(account1).getSolde();
        assertThat(account1Solde, is(equalTo(200)));

        int account2Solde = service.getAccount(account2).getSolde();
        assertThat(account2Solde, is(equalTo(900)));

        Mockito.verify(dao, Mockito.times(2)).getAccount(account1);
        Mockito.verify(dao, Mockito.times(2)).getAccount(account2);
    }

}
