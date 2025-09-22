package com.github.thiagogarbazza.pocs.app.core.employee;


import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(schema = "employee", name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "name", length = 500)
    private String name;
    @Column(name = "email", length = 1000)
    private String email;
}
