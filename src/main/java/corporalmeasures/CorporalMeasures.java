package corporalmeasures;

public abstract class CorporalMeasures {

    private PersonData data;
	private Double expectedFatPercentage;

    protected CorporalMeasures(PersonData data) {
        this.data = data;
    }

	public Double getPesoIdeal() {
		return  (data.getWeight() - (getFatPercentage()/100 * data.getWeight())) / (1 - expectedFatPercentage/100);
	}

	public abstract Double getFatPercentage();

    public Double getMusclePercentage() {
        return 100 - getFatPercentage();
    }

	public Double getMassaMagraKgs(){
		return getMusclePercentage()/100 * data.getWeight();
	}
	
	public Double getMassaGordaKgs(){ return getFatPercentage()/100 * data.getWeight();
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
