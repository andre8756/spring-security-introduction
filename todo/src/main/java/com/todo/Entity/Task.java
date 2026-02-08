package com.todo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_listas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    // CheckBox
    @Column
    private Boolean completed;

}
