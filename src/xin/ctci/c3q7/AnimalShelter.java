package xin.ctci.c3q7;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by Xin on 8/21/2016.
 */
public class AnimalShelter {
    ArrayDeque<Animal> animals;
    int catCount;
    int dogCount;

    public AnimalShelter() {
        animals = new ArrayDeque<>();
        catCount=0;
        dogCount = 0;
    }

    public void addAnimal(Animal animal) {
        animals.addLast(animal);
        if (animal.getType() == AnimalType.CAT) {
            catCount ++;
        } else {
            dogCount ++;
        }
    }

    public Animal getAny() {
        if (animals.isEmpty()) {
            throw new RuntimeException("shelter is empty now");
        }
        Animal animal = animals.poll();
        if (animal.getType() == AnimalType.CAT) {
            catCount --;
        } else {
            dogCount --;
        }
        return animal;
    }

    public Dog getDog() {
        if (dogCount == 0) {
            throw new RuntimeException("no dogs now");
        }

        Stack<Animal> catsInFront = new Stack<>();
        while (animals.peek().getType() != AnimalType.DOG) {
            catsInFront.push(animals.poll());
        }
        Dog toReturn = (Dog) animals.poll();
        dogCount--;
        while (!catsInFront.isEmpty()) {
            animals.addFirst(catsInFront.pop());
        }
        return toReturn;
    }
}
