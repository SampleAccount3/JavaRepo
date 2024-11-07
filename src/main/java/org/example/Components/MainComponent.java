package org.example.Components;

public class MainComponent {
    PersonComponent personComponent;
    JobComponent jobComponent;
    SalaryComponent salaryComponent;


    public MainComponent(PersonComponent personComponent, JobComponent jobComponent, SalaryComponent salaryComponent) {
        this.personComponent = personComponent;
        this.jobComponent = jobComponent;
        this.salaryComponent = salaryComponent;
    }

    public PersonComponent getPersonComponent() {
        return personComponent;
    }

    public JobComponent getJobComponent() {
        return jobComponent;
    }

    public SalaryComponent getSalaryComponent() {
        return salaryComponent;
    }
}
