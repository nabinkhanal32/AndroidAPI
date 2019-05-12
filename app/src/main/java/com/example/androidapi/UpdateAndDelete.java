package com.example.androidapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import EmployeeAPI.EmployeeAPI;
import Model.Employee;
import Model.EmployeeCUD;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateAndDelete extends AppCompatActivity {
    private final static String BASE_URL = "http://dummy.restapiexample.com/api/v1/";
    private EditText etEmpName, etEmpSalary, etEmpAge,etEmpId;
    private Button btnEmpSearch,btnUpdate,btnDelete;
    EmployeeAPI employeeAPI;
    Retrofit retrofit;

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
        btnEmpSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEmployees();
            }
        });


    }

    private void CreateInstance() {
         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         employeeAPI = retrofit.create(EmployeeAPI.class);
    }
    private void loadData()
    {
        CreateInstance();

        Call<Employee> listCall = employeeAPI.getEmployeeByID(Integer.parseInt(etEmpId.getText().toString()));

        listCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                etEmpName.setText(response.body().getEmployee_name());
                etEmpSalary.setText(Float.toString(response.body().getEmployee_salary()));
                etEmpAge.setText(Integer.toString(response.body().getEmployee_age()));
                
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(UpdateAndDelete.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void updateEmployees()
    {
        CreateInstance();
        EmployeeCUD employee = new EmployeeCUD(
                etEmpName.getText().toString(),
                Float.parseFloat(etEmpSalary.getText().toString()),
                Integer.parseInt(etEmpAge.getText().toString())
        );
      Call<Void> voidCall = employeeAPI.updateEmployee(Integer.parseInt(etEmpId.getText().toString()),employee);
      voidCall.enqueue(new Callback<Void>() {
          @Override
          public void onResponse(Call<Void> call, Response<Void> response) {
              Toast.makeText(UpdateAndDelete.this, "Updated", Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onFailure(Call<Void> call, Throwable t) {
              Toast.makeText(UpdateAndDelete.this, "Error", Toast.LENGTH_SHORT).show();

          }
      });
    }

}
