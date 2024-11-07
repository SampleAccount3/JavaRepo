package org.example.Components;

public class JobComponent {
    private String job;
    private String position;
    private String Location;

    public JobComponent(String job, String position, String location) {
        this.job = job;
        this.position = position;
        Location = location;
    }

    public String getJob() {
        return job;
    }

    public String getPosition() {
        return position;
    }

    public String getLocation() {
        return Location;
    }

    @Override
    public String toString() {
        return "JobComponent{" +
                "job='" + job + '\'' +
                ", position='" + position + '\'' +
                ", Location='" + Location + '\'' +
                '}';
    }
}
