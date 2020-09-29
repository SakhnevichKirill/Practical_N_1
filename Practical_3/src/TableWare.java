import Base.Dish;

public class TableWare extends Dish {

    private String features;

    public void setFeatures(String features){
        this.features = features;
    }

    public String getFeatures() {
        return features;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String getInfo() {
        return " Материалы: " + material + " Тип: " + type + " Кол-во: " + count + " Особенности: " + features;
    }

}
