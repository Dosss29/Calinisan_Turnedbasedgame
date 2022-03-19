package com.example.calinisan_turnedbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtHeroName, txtHerodps, txtHerohp, txtEnemyname, txtEnemydps, txtEnemyhp, txtCombatLog;
    Button btnNextTurn;


    String heroName = "Sauron";
    int heroHP = 1500;
    int heroMindDamage = 100;
    int heroMaxDamage = 175;

    String enemyName = "Carnage";
    int enemyHP = 3000;
    int enemyMinDamage = 55;
    int enemyMaxDamage = 75;

    int turnNumber = 1;

    public void OnNextTurn(int herodps, int enemydps) {
        if (turnNumber % 2 == 1) {
            enemyHP = enemyHP - herodps;
            turnNumber++;
            txtEnemyhp.setText(String.valueOf(enemyHP));
            btnNextTurn.setText("Next Turn(" + String.valueOf(turnNumber) + ")");

            txtCombatLog.setText("Our Hero " + String.valueOf(heroName) + " dealt " + String.valueOf(herodps) + " to the enemy.");

            if (enemyHP < 0) {
                txtCombatLog.setText("Our Hero " + String.valueOf(heroName) + " dealt " + String.valueOf(herodps) + " to the enemy. The Hero is Victorious ");
                heroHP = 1500;
                enemyHP = 3000;
                turnNumber = 1;
                btnNextTurn.setText(" Play Again? ");


            }

        } else if (turnNumber % 2 != 1) {
            heroHP = heroHP - enemydps;
            turnNumber++;
            txtHerohp.setText(String.valueOf(heroHP));
            btnNextTurn.setText("Next Turn(" + String.valueOf(turnNumber) + ")");

            txtCombatLog.setText("The Enemy " + String.valueOf(enemyName) + " dealt " + String.valueOf(enemydps) + " to the Hero.");

            if (heroHP < 0) {
                txtCombatLog.setText("The Enemy " + String.valueOf(enemyName) + " dealt " + String.valueOf(enemydps) + " to the Hero. Hero has been DECAPITATED ");
                heroHP = 1500;
                enemyHP = 3000;
                turnNumber = 1;
                btnNextTurn.setText(" Play Again? ");


            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHeroName = findViewById(R.id.txtHeroName);
        txtEnemyname = findViewById(R.id.txtEnemyname);
        txtHerodps = findViewById(R.id.txtHerodps);
        txtEnemydps = findViewById(R.id.txtEnemydps);
        txtHerohp = findViewById(R.id.txtHerohp);
        txtEnemyhp = findViewById(R.id.txtEnemyhp);
        btnNextTurn = findViewById(R.id.btnNextTurn);
        txtHerodps = findViewById(R.id.txtHerodps);
        txtEnemydps = findViewById(R.id.txtEnemydps);
        txtCombatLog = findViewById(R.id.txtCombatLog);

        txtCombatLog = findViewById(R.id.txtCombatLog);


        txtHeroName.setText(heroName);
        txtHerohp.setText(String.valueOf(heroHP));


        txtEnemyname.setText(enemyName);
        txtEnemyhp.setText(String.valueOf(enemyHP));


        txtHerodps.setText(String.valueOf(heroMindDamage) + " ~ " + String.valueOf(heroMaxDamage));
        txtEnemydps.setText(String.valueOf(enemyMinDamage) + " ~ " + String.valueOf(enemyMaxDamage));


        btnNextTurn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


        txtCombatLog = findViewById(R.id.txtCombatLog);

int testtest = 0;
        Random radomizer = new Random();
        int herodps = radomizer.nextInt(heroMaxDamage - heroMindDamage) + heroMindDamage;
        int enemydps = radomizer.nextInt(enemyMaxDamage - enemyMinDamage) + enemyMinDamage;

        OnNextTurn(herodps, enemydps);
    }
}











