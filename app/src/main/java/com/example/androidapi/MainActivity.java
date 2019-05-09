package com.example.androidapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import EmployeeAPI.EmployeeAPI;
import Model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData = findViewById(R.id.tvData);
        loadData();
    }
    public void loadData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        EmployeeAPI api = retrofit.create(EmployeeAPI.class);

        Call<List<Employee>> listCall = api.getEmployee();

        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {


                List<Employee> employeeList = response.body();

                for (Employee employee : employeeList) {
                    String content = "";
                    content += "ID: " + employee.getId() + "\n";
                    content += "Employee name: " + employee.getEmployee_name() + "\n";
                    content += "Employee Salary: " + employee.getEmployee_salary() + "\n";
                    content += "Age: " + employee.getEmployee_age() + "\n";
                    content += "Image: " + employee.getProfile_image() + "\n";
                    content += "------------------------------------"+"\n";

                    tvData.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}
