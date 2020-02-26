package com.example.dicecup;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public List<Dice> dices = new ArrayList<>();
    public List<TableRow> rows = new ArrayList<>();
    public ArrayList<String> rollHistory = new ArrayList<>();
    TableLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl = findViewById(R.id.diceContainer);
    }

    public void addDice(View view) {
        Dice dice = new Dice(this);
        dices.add(dice);
        setUpDices(dice);
    }
    public void deleteDice(View view) {
        Dice dice = dices.get(dices.size() - 1);
        dices.remove(dice);
        for (TableRow row : rows) {
            row.removeView(dice);
        }
    }

    public void setUpDices(Dice dice){
        if(dices.size() % 3 == 0){
            TableRow tr2 = new TableRow(this);
            tr2.addView(dice);
            tl.addView(tr2);
            rows.add(tr2);
            return;
        }
        TableRow tr = rows.get(rows.size() - 1);
        tr.addView(dice);
    }

    public void rollDices(View view) {
        StringBuilder results = new StringBuilder();
        for (Dice dice : dices) {
            int roll = getRandomNumber();
            results.append(roll);
            dice.setDice(roll);
        }
        rollHistory.add(results.toString());
    }
    public int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

    public void openHistory(View view) {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        intent.putStringArrayListExtra("RollHistory", rollHistory);
        startActivity(intent);
    }
}
