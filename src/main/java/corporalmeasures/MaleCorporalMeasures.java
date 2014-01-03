package corporalmeasures;

import static java.lang.Math.log;

public class MaleCorporalMeasures extends CorporalMeasures {

    protected MaleCorporalMeasures(PersonData data) {
        super(data);
    }

    public Double getFatPercentage() {
        return ((495 / ((1.0324-((log(getData().getWaist() - getData().getNeck()) / log(10)) * 0.19077)) +
               (log(getData().getHeight()) / log(10)) * 0.15456)) - 450) / 100;
    }
}
