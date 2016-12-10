package xin.misc;

import java.util.Optional;

/**
 * Created by Xin on 8/17/2016.
 */
public class Person {
    private Optional<Car> car;
    public Optional<Car> getCar() {
        return car;
    }
    public void test() {
        Optional<String> name = car.flatMap(Car::getInsurance)
                .map(Insurance::getName);
    }
}
