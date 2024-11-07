package org.example;

import org.example.Components.JobComponent;
import org.example.Components.MainComponent;
import org.example.Components.PersonComponent;
import org.example.Components.SalaryComponent;

public class Main {

    public static void main(String[] args) {
        PersonComponent Applicant1 = new PersonComponent("Melanio Flores", 24,"Gaming");
        JobComponent Wilcon = new JobComponent("Programming","Jr. System Developer", "Quezon Libis");
        SalaryComponent BasicPay = new SalaryComponent(19500, 22000);

        MainComponent Job = new MainComponent(Applicant1,Wilcon,BasicPay);

        System.out.println(Job.getPersonComponent().getName());
        System.out.println(Job.getPersonComponent().getAge());
        System.out.println(Job.getPersonComponent().getHobby());

        System.out.println(Job.getJobComponent().getJob());
        System.out.println(Job.getJobComponent().getPosition());
        System.out.println(Job.getJobComponent().getLocation());

        System.out.println(Job.getSalaryComponent().getMinSalary());
        System.out.println(Job.getSalaryComponent().getMaxSalary());
    }

}