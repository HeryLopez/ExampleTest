package com.jetbrains.handson.mpp.formation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jetbrains.handson.mpp.formation.service.CompteBancaireService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CompteBancaireService service = new CompteBancaireService();
        showMessage(service);
        service.virement(1, 2, 100);
        showMessage(service);
        service.virement(2, 1, 50);
        showMessage(service);
    }

    private void showMessage(CompteBancaireService service){
        addTextView(
                formatString(service.getAccount(1).getSolde(), service.getAccount(2).getSolde())
        );
    }

    private String formatString(int solde1, int solde2){
        return "T1 : Account 1 = " + solde1 + " Account 2 = " + solde2;
    }

    private void addTextView(String text){
        LinearLayout view = findViewById(R.id.root);

        TextView textView = new TextView(this);
        textView.setText(text);
        view.addView(textView);
    }
}
