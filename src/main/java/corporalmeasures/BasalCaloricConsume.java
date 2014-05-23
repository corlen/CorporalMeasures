package corporalmeasures;

public class BasalCaloricConsume {

    private PersonData data;

    public BasalCaloricConsume(PersonData data) {
        this.data = data;

    }

    public Double getBasalCaloricConsume() {
        return ((10 * data.getWeight()) + (6.25 * data.getHeight()) - (5 * data.getAge()) + 5) * data.getPhysicalActivityLevel();
    }

    public Double getBasalCaloricConsumeForWeightLoss() {
        return getBasalCaloricConsume() * 0.8;
    }

    public Double getBasalCaloricConsumeForIncreaseMuscleMass() {
        return getBasalCaloricConsume() * 1.2;
    }
}
