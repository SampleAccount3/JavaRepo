package org.example;

import org.example.Components.JobComponent;
import org.example.Components.MainComponent;
import org.example.Components.PersonComponent;
import org.example.Components.SalaryComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static String randomStrings = "kjoasdjfasdjfkasdfklasdlkfjaslkdfjalksdjf431027439710283749182374";
    public static void main(String[] args) {


        List<MainComponent> JobApplications =  new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            PersonComponent Applicant1 = new PersonComponent(generateRandomString(10), 24,generateRandomString(10));
            JobComponent Wilcon = new JobComponent(generateRandomString(10),generateRandomString(10), generateRandomString(10));
            SalaryComponent BasicPay = new SalaryComponent(19500, 22000);
            MainComponent JobApplication = new MainComponent(Applicant1,Wilcon,BasicPay);
            JobApplications.add(JobApplication);
        }

        for(MainComponent JobApplication:JobApplications){
            JobApplication.getPersonComponent().toString();
            JobApplication.getJobComponent().toString();
            JobApplication.getSalaryComponent().toString();
        }
    }

    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(randomStrings.length());
            randomString.append(randomStrings.charAt(index));
        }
        return randomString.toString();
    }
}