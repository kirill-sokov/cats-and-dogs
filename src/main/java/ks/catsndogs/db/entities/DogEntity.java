package ks.catsndogs.db.entities;

import ks.catsndogs.model.Dog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class DogEntity implements ModeledEntity<Dog> {

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
    public Dog toModel() {
        return new Dog()
                .age(this.age)
                .breed(this.breed)
                .color(this.color)
                .name(this.name);
    }

    public static DogEntity fromModel(Dog dog) {
        DogEntity entity = new DogEntity();
        entity.setAge(dog.getAge());
        entity.setName(dog.getName());
        entity.setColor(dog.getColor());
        entity.setBreed(dog.getBreed());

        return entity;

    }
}
