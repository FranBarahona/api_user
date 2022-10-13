package com.user.api_user.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idUser;

    @Column(name = "names")
    private String names;

    @Column(name = "last_names")
    private String lastNames;

    @Override
    public String toString() {
        return "Users{" +
                "idUser=" + idUser +
                ", names='" + names + '\'' +
                ", lastNames='" + lastNames + '\'' +
                '}';
    }
}
