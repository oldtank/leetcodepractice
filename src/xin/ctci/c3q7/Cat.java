package xin.ctci.c3q7;

import lombok.Data;

/**
 * Created by Xin on 8/21/2016.
 */
@Data
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        this.type = AnimalType.CAT;
    }
}
