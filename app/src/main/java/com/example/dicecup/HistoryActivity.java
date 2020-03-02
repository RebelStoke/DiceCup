package com.example.dicecup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> rollHistoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        lv = findViewById(R.id.rollList);
        Intent intent = getIntent();
        rollHistoryList = intent.getStringArrayListExtra("RollHistory");
        populateHistory();
    }

    public void populateHistory(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, prepareValues(rollHistoryList));
        lv.setAdapter(arrayAdapter);
    }

    public void closeHistory(View view) {
        finish();
    }

    public void clearHistory(View view){
        MainActivity.rollHistory.clear();
        rollHistoryList.clear();
        populateHistory();
    };

    public ArrayList<String> prepareValues(ArrayList<String> list){
        ArrayList<String> newList = new ArrayList<>();
        for (String string: list) {
            String formatedString = "";
            for(int i = 0; i < string.length(); i++){
                formatedString += string.charAt(i);
                if(i != string.length() - 1){
                    formatedString += "-";
                }
            }
            newList.add(formatedString);
        }
        return newList;
    }
}
