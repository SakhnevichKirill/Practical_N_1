package Base;

public abstract class Dog {

    protected String name;
    protected String weight;
    protected int count;

    public abstract void setName(String name);

    public abstract void setCount(int count);

    public abstract void setWeight(String weight);

    public abstract String getInfo();


}
