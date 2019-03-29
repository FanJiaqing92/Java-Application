package guice;

public class CatFood implements Food{
    private String foodName = "catFood";
    @Override
    public String getFoodName() {
        return foodName;
    }
}
