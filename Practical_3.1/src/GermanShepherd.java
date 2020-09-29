import Base.Dog;

public class GermanShepherd extends Dog {
    private String features;

    public void setFeatures(String features){
        this.features = features;
    }

    public String getFeatures() {
        return features;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String getInfo() {
        return "Имя: " + name + " Вес: " + weight + " Кол-во: " + count + " Особенности: " + features;
    }
}
