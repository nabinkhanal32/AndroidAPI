package com.example.androidapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    private Button btnView, btnsearch,btnRegister,btnUpdateDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnsearch = findViewById(R.id.btnSearch);
        btnView = findViewById(R.id.btnView);
        btnRegister= findViewById(R.id.btnRegister);
        btnUpdateDelete= findViewById(R.id.btnUpdateDelete);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);


            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, SearchActivity.class);
                startActivity(intent);

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
        btnUpdateDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, UpdateAndDelete.class);
                startActivity(intent);

            }
        });
    }
}
