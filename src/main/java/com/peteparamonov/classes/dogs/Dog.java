package com.peteparamonov.classes.dogs;

import com.peteparamonov.api.Active;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
        (
                name="Dog_category",
                discriminatorType=DiscriminatorType.STRING
        )
public abstract class Dog implements Active {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private  String name;
    @Column
    private int age;
    @Column
    private boolean isHealthy;
    @Column
    private boolean isFed = false;
    @Column
    private boolean isTrained;


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }


    public enum Food{
        MEAT,
        BONES,
        PORRIDGE
    }
    public abstract boolean feedDog();

    public int getAge() {
        return age;
    }
    private void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }

    public boolean isHealthy() {
        return isHealthy;
    }
    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public boolean isFed() {
        return isFed;
    }
    public void setFed(boolean fed) {
        isFed = fed;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    public Dog() {
    }

    public Dog(int age, String name, boolean isHealthy) {
        this.age = age;
        this.name = name;
        this.isHealthy = isHealthy;
    }

    @Override
    public String toString() {
        return  name +
                "age =" + age +
                ", isHealthy =" + isHealthy +
                ", isFed =" + isFed +
                ", isTrained =" + isTrained;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return new EqualsBuilder().append(name, dog.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name).toHashCode();
    }
}
