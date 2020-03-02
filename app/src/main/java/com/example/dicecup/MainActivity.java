package com.example.dicecup;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
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
    public static ArrayList<String> rollHistory = new ArrayList<>();
    TableLayout tl;
    int orientNum = 2;
    int dicesInView = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl = findViewById(R.id.diceContainer);
        addDice(null);
    }

    public Dice addDice(View view) {
        if(dices.size() > 5)
            return null;
        Dice dice = new Dice(this);
        dices.add(dice);
        setUpDices(dice, orientNum);
        return dice;
    }
    public void deleteDice(View view) {
        if(dices.size() == 1)
            return;
        dicesInView--;
        Dice dice = dices.get(dices.size() - 1);
        dices.remove(dice);
        for (TableRow row : rows) {
            row.removeView(dice);
            if(row.getVirtualChildCount() == 0)
                rows.remove(row);
        }
    }

    public void setUpDices(Dice dice, int number){
        dicesInView++;
        if((dicesInView - 1)  % number == 0){
            TableRow tr2 = new TableRow(this);
            tr2.setGravity(Gravity.CENTER);
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
        return random.nextInt(6) + 1;
    }

    public void openHistory(View view) {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        intent.putStringArrayListExtra("RollHistory", rollHistory);
        startActivity(intent);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        dicesInView = 0;
        super.onConfigurationChanged(newConfig);
        tl.removeAllViews();
        rows.clear();
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            orientNum = 3;
            for (Dice dice: dices) {
               TableRow t = (TableRow)dice.getParent();
               t.removeView(dice);
                setUpDices(dice, 3);
            }
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            orientNum = 2;
            for (Dice dice: dices) {
                TableRow t = (TableRow)dice.getParent();
                t.removeView(dice);
                setUpDices(dice, 2);
            }
        }
    }
}
