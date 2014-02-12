package corporalmeasures;

public class GastoCaloricoBasal {

    private PersonData data;

    public GastoCaloricoBasal(PersonData data) {
        this.data = data;

    }

    public Double getGastoCaloricoBasal(PhysicalActivityLevel activityLevel) {
        return ((10 * data.getWeight()) + (6.25 * data.getHeight()) - (5 * data.getAge()) + 5) * activityLevel.getValue();
    }

    public Double getGastoCaloricoBasalNivelDietaEmagrecimento(PhysicalActivityLevel activityLevel) {
        return getGastoCaloricoBasal(activityLevel) * 0.8;
    }

    public Double getGastoCaloricoBasalNivelDietaHipertrofia(PhysicalActivityLevel activityLevel) {
        return getGastoCaloricoBasal(activityLevel) * 1.2;
    }
}
