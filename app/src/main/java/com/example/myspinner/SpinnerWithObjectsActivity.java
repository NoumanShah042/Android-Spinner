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

public class SpinnerWithObjectsActivity extends AppCompatActivity {
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        List<User> userList = new ArrayList<>();
        User user1 = new User("Jim", 20, "jim@gmail.com");
        userList.add(user1);
        User user2 = new User("John", 23, "john@gmail.com");
        userList.add(user2);
        User user3 = new User("Jenny", 25, "jenny@gmail.com");
        userList.add(user3);

        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this,
                android.R.layout.simple_spinner_item, userList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                User user = (User) parent.getSelectedItem();
                displayUserData(user);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void getSelectedUser(View v) {  // called when we press button
        User user = (User) spinner.getSelectedItem();
        displayUserData(user);
    }

    private void displayUserData(User user) {
        String name = user.getName();
        int age = user.getAge();
        String mail = user.getMail();

        String userData = "Name: " + name + "\nAge: " + age + "\nMail: " + mail;

        Toast.makeText(this, userData, Toast.LENGTH_LONG).show();
    }
}