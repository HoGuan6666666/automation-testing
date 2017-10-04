package com.ecvictor.testng.employee;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class EmpBusinessLogicTest {

    private EmployeeDetails employeeDetails;
    private EmpBusinessLogic empBusinessLogic;


    @BeforeClass
    public void setUp() throws Exception {
        empBusinessLogic = new EmpBusinessLogic();
        employeeDetails = new EmployeeDetails();

    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("Testing Complete!");
    }

    @Test
    public void calculateYearlySalary() throws Exception {
        employeeDetails.setMonthlySalary(2000);
        double salary = empBusinessLogic.calculateYearlySalary(employeeDetails);

        assertEquals("leia's salary should be 24000", 24000,salary, 0.0); //delta是expected，actual的difference
    }

    @Test
    public void calculateAppraisalLess() throws Exception {
        employeeDetails.setMonthlySalary(2000);
        double appraisal = empBusinessLogic.calculateAppraisal(employeeDetails);
        assertEquals("leia", 500, appraisal, 0.0);
    }

    @Test
    public void calculateAppraisalMore() throws Exception {
        employeeDetails.setMonthlySalary(10000);
        assertEquals("leia",1000, empBusinessLogic.calculateAppraisal(employeeDetails), 0.0);
    }

    @Test
    public void getName() {
        employeeDetails.setName("Leia");
        assertEquals("Leia", employeeDetails.getName());
    }

    @Test
    public void getAge() {
        employeeDetails.setAge(20);
        assertEquals(20, employeeDetails.getAge());
    }

}