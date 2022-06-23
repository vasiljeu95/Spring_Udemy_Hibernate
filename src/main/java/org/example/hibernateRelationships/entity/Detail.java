package org.example.hibernateRelationships.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * Detail
 *
 * @author Stepan Vasilyeu
 * @since 04.06.2022
 */
@Entity
@Table(name = "details")
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "city")
    private String city;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @OneToOne(mappedBy = "employeeDetail", cascade = CascadeType.ALL)
    private Employee employee;

    public Detail() {}
    public Detail(String city, String phoneNumber, String email) {
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
