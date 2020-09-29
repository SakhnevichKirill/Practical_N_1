package Base;

public abstract class Dish {

    protected String material;
    protected String type;
    protected int count;

    public abstract void setCount(int count);

    public abstract void setType(String type);

    public abstract String getInfo();


}
