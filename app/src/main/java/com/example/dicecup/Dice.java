package com.example.dicecup;

import android.content.Context;
import android.view.View;
import android.widget.TableLayout;

public class Dice extends TableLayout {
    int[] buttons = {R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};

    public Dice(Context context) {
        super(context);
        inflate(context, R.layout.dice, this);
    }


    public void setDice(int number){
        for (int button: buttons) {
            findViewById(button).setVisibility(View.INVISIBLE);
        }
        switch (number){
            case 1: {
                findViewById(buttons[4]).setVisibility(View.VISIBLE);
                break;
            }
            case 2: {
                findViewById(buttons[0]).setVisibility(View.VISIBLE);
                findViewById(buttons[8]).setVisibility(View.VISIBLE);
                break;
            }
            case 3: {
                findViewById(buttons[0]).setVisibility(View.VISIBLE);
                findViewById(buttons[4]).setVisibility(View.VISIBLE);
                findViewById(buttons[8]).setVisibility(View.VISIBLE);
                break;
            }
            case 4: {
                findViewById(buttons[0]).setVisibility(View.VISIBLE);
                findViewById(buttons[2]).setVisibility(View.VISIBLE);
                findViewById(buttons[6]).setVisibility(View.VISIBLE);
                findViewById(buttons[8]).setVisibility(View.VISIBLE);
                break;
            }
            case 5: {
                findViewById(buttons[0]).setVisibility(View.VISIBLE);
                findViewById(buttons[2]).setVisibility(View.VISIBLE);
                findViewById(buttons[4]).setVisibility(View.VISIBLE);
                findViewById(buttons[6]).setVisibility(View.VISIBLE);
                findViewById(buttons[8]).setVisibility(View.VISIBLE);
                break;
            }
            case 6: {
                findViewById(buttons[0]).setVisibility(View.VISIBLE);
                findViewById(buttons[1]).setVisibility(View.VISIBLE);
                findViewById(buttons[2]).setVisibility(View.VISIBLE);
                findViewById(buttons[6]).setVisibility(View.VISIBLE);
                findViewById(buttons[7]).setVisibility(View.VISIBLE);
                findViewById(buttons[8]).setVisibility(View.VISIBLE);
                break;
            }

        }
    }
}
