package java15.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private int jobId;//(reference)

    public Employee(int jobId, String email, int age, String lastName, String firstName) {
        this.jobId = jobId;
        this.email = email;
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
