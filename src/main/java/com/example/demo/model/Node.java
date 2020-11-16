package com.example.demo.model;

import java.util.Objects;
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
@Table(name = "nodes")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pointFrom;
    private Long pointTo;
    private Long length;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(pointFrom, node.pointFrom) &&
                Objects.equals(pointTo, node.pointTo) &&
                Objects.equals(length, node.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointFrom, pointTo, length);
    }

    public Node(Long from, Long to, Long length) {
        this.pointFrom = from;
        this.pointTo = to;
        this.length = length;
    }
}
