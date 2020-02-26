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
                this, android.R.layout.simple_list_item_1, rollHistoryList);
        lv.setAdapter(arrayAdapter);
    }

    public void closeHistory(View view) {
        finish();
    }
}
