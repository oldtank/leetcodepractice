package xin.ctci.c3q7;

/**
 * Created by Xin on 8/21/2016.
 */

import lombok.Data;

@Data
public abstract class Animal {
    String name;
    AnimalType type;

    public Animal(String name) {
        this.name = name;
    }
}
