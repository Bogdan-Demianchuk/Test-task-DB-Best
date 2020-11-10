package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="graphs")
public class Graph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long pointFrom;
    Long pointTo;
    Long length;

    public Graph(Long from, Long to, Long length) {
        this.pointFrom = from;
        this.pointTo = to;
        this.length = length;
    }
}
