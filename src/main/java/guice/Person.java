package guice;

import javax.inject.Inject;

public class Person implements Feed{
    private Animal pet;
    private Food food;

    @Inject
    public Person(Animal pet, Food food){
        this.pet = pet;
        this.food = food;
    }
    @Override
    public void feed() {
        pet.eat(food);
    }
}
