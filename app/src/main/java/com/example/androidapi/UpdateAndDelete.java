package com.example.androidapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UpdateAndDelete extends AppCompatActivity {
    private final static String BASE_URL = "http://dummy.restapiexample.com/api/v1/";
    private EditText etEmpName, etEmpSalary, etEmpAge,etEmpId;
    private Button btnEmpSearch,btnUpdate,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_and_delete);
        etEmpAge = findViewById(R.id.etEmpAge);
        etEmpId = findViewById(R.id.etempId);
        etEmpName = findViewById(R.id.etEmpName);
        etEmpSalary = findViewById(R.id.etEmpSalary);

        btnDelete = findViewById(R.id.btnDelete);
        btnEmpSearch = findViewById(R.id.btnEmpSearch);
        btnUpdate = findViewById(R.id.btnUpdate);


    }
}
