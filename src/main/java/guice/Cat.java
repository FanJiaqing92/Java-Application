package guice;

public class Cat implements Animal{
    @Override
    public void eat(Food food) {
        System.out.println("A cat eat " + food.getFoodName());
    }
}
