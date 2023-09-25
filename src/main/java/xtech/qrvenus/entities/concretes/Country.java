package xtech.qrvenus.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // todo: srht -> buna gerek var mı kontrol et.
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "country")
    private List<City> cities;
}
