package com.example.manytomany.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private String id;

    private String name;

    @ManyToMany(mappedBy = "courses",cascade =  { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Students> students = new ArrayList<>();
    // Getters and setters, constructors, other methods
    @Override
    public String toString() {
        return "" +
                "id:" + id +
                " name:" + name +
                "";
    }
}

