package corporalmeasures;

public class GastoCaloricoBasal {

    private Double weight;
    private Double height;
    private Integer age;

    public GastoCaloricoBasal(Double weight, Double height, Integer age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public Double getGastoCaloricoBasal(PhysicalActivityLevel activityLevel) {
        return ((10 * weight) + (6.25 * height) - (5 * age) + 5) * activityLevel.getValue();
    }

    public Double getGastoCaloricoBasalNivelDietaEmagrecimento(PhysicalActivityLevel activityLevel) {
        return getGastoCaloricoBasal(activityLevel) * 0.8;
    }

    public Double getGastoCaloricoBasalNivelDietaHipertrofia(PhysicalActivityLevel activityLevel) {
        return getGastoCaloricoBasal(activityLevel) * 1.2;
    }
}
