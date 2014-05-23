package corporalmeasures;

public class BasalCaloricConsume {

    private PersonData data;

    public BasalCaloricConsume(PersonData data) {
        this.data = data;

    }

    public Double getGastoCaloricoBasal() {
        return ((10 * data.getWeight()) + (6.25 * data.getHeight()) - (5 * data.getAge()) + 5) * data.getPhysicalActivityLevel();
    }

    public Double getGastoCaloricoBasalNivelDietaEmagrecimento() {
        return getGastoCaloricoBasal() * 0.8;
    }

    public Double getGastoCaloricoBasalNivelDietaHipertrofia() {
        return getGastoCaloricoBasal() * 1.2;
    }
}
