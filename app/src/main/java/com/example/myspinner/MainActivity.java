package com.example.myspinner;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    List<String> fruitsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        fruitsList = new ArrayList<>();

        fruitsList.add("Apples");
        fruitsList.add("Apricots");
        fruitsList.add("Bananas");
        fruitsList.add("Blackberry");
        fruitsList.add("Blueberry");
        fruitsList.add("Cherries");
        fruitsList.add("Cranberry");
        fruitsList.add("Sugar-apple");
        fruitsList.add("Pitaya");
        fruitsList.add("Common fig");
        fruitsList.add("Cranberry");
        fruitsList.add("Jackfruit");
        fruitsList.add("Mangos");
        fruitsList.add("Papayas");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, fruitsList);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You Selected " +
                        fruitsList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
