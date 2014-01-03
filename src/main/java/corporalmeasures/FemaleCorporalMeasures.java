package corporalmeasures;

import static java.lang.Math.log;

public class FemaleCorporalMeasures extends CorporalMeasures {

    public FemaleCorporalMeasures(FemalePersonData data) {
        super(data);
    }

    protected Double getFatPercentage(){
        double hipPlusWaist = ((FemalePersonData)getData()).getHip() + getData().getWaist();

        return (495 / ((1.29579 - (0.35004 * (log(hipPlusWaist - getData().getNeck()) / log(10)))) +
               (log(getData().getHeight()) / log(10)) * 0.22100)) - 450;
    }


}
