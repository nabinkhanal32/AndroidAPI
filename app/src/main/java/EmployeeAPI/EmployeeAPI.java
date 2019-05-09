package EmployeeAPI;

import java.util.List;

import Model.Employee;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeAPI {
    @GET("employees")
    Call<List<Employee>> getEmployee();
    @GET("employee/{empID}")
    Call<List<Employee>> getEmployeeByID(@Path(".empID") int empId);



}
