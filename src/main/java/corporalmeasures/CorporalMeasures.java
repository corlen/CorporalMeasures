package corporalmeasures;

public abstract class CorporalMeasures {

    private PersonData data;
	private Double expectedFatPercentage;

    protected CorporalMeasures(PersonData data) {
        this.data = data;
    }

	public Double getPesoIdeal() {
		return  (data.getWeight() - (getFatPercentage() * data.getWeight())) / (1 - expectedFatPercentage);
	}

	protected abstract Double getFatPercentage();

    protected Double getMusclePercentage() {
        return 1 - getFatPercentage();
    }

	public Double getMassaMagraKgs(){
		return getMusclePercentage() * data.getWeight();
	}
	
	public Double getMassaGordaKgs(){
		return getFatPercentage() * data.getWeight();
	}

    public void setExpectedFatPercentage(Double expectedFatPercentage) {
        this.expectedFatPercentage = expectedFatPercentage;
    }

    public Double getExpectedFatPercentage() {
        return this.expectedFatPercentage;
    }

    public PersonData getData() {
        return data;
    }
}
