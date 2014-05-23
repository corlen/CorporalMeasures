package corporalmeasures;

public class PersonData {

    private Double weight;
    private Double waist;
    private Double neck;
    private Double height;
    private Integer age;
    private Double physicalActivityLevel;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }

    public Double getWaist() {
        return this.waist;
    }

    public void setNeck(Double neck) {
        this.neck = neck;
    }

    public Double getNeck() {
        return this.neck;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getHeight() {
        return this.height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "weight=" + weight +
                ", waist=" + waist +
                ", neck=" + neck +
                ", height=" + height +
                ", age=" + age +
                '}';
    }

    public Double getPhysicalActivityLevel() { return physicalActivityLevel; }

    public void setPhysicalActivityLevel(Double physicalActivityLevel) {
        this.physicalActivityLevel = physicalActivityLevel;
    }
}
