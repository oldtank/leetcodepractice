package xin.ctci.c3q7;

/**
 * Created by Xin on 8/21/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.addAnimal(new Cat("cat1"));
        shelter.addAnimal(new Cat("cat3"));
        shelter.addAnimal(new Dog("dog1"));
        shelter.addAnimal(new Cat("cat2"));
        shelter.addAnimal(new Dog("dog2"));
        System.out.println(shelter.getDog().getName());
        System.out.println(shelter.getDog().getName());
    }
}
