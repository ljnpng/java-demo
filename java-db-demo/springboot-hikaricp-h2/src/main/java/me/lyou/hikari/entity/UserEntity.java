package me.lyou.hikari.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserEntity {

    @Id
    private Long id;

    private String name;

}
