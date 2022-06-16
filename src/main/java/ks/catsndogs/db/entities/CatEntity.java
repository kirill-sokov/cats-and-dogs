package ks.catsndogs.db.entities;

import ks.catsndogs.model.Cat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class CatEntity implements ModeledEntity<Cat> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private String color;

    @Column
    private String breed;

    @Column
    private Integer age;

    @Override
    public Cat toModel() {
        return new Cat()
                .age(this.age)
                .breed(this.breed)
                .color(this.color)
                .name(this.name);
    }

    public static CatEntity fromModel(Cat cat) {
        CatEntity entity = new CatEntity();
        entity.setAge(cat.getAge());
        entity.setName(cat.getName());
        entity.setColor(cat.getColor());
        entity.setBreed(cat.getBreed());

        return entity;

    }
}
