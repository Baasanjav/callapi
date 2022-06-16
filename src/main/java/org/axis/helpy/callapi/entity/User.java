package org.axis.helpy.callapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "API_USER")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
}