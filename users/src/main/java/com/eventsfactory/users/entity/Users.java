package com.eventsfactory.users.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity {

    @Id
    private Long userId;

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNumber;
}

