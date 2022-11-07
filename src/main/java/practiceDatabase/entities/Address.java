package practiceDatabase.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Address {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private int postalCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Address address = (Address) o;
        return id != null && Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
