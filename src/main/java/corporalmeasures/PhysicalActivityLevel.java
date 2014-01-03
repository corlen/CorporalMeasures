package corporalmeasures;

import java.util.ResourceBundle;

public enum PhysicalActivityLevel {
    SEDENTARY {
        @Override
        public String getDescription(ResourceBundle bundle) {
            return bundle.getString("physicalActivity.sedentary");
        }

        @Override
        public Double getValue() {
            return 1.2;
        }
    },
    LIGHTLY_ACTIVE {
        @Override
        public String getDescription(ResourceBundle bundle) {
            return bundle.getString("physicalActivity.lightlyActive");
        }

        @Override
        public Double getValue() {
            return 1.375;
        }
    },
    MODERATELY_ACTIVE {
        @Override
        public String getDescription(ResourceBundle bundle) {
            return bundle.getString("physicalActivity.moderatelyActive");
        }

        @Override
        public Double getValue() {
            return 1.55;
        }
    },
    VERY_ACTIVE {
        @Override
        public String getDescription(ResourceBundle bundle) {
            return bundle.getString("physicalActivity.veryActive");
        }

        @Override
        public Double getValue() {
            return 1.725;
        }
    },
    EXTRA_ACTIVE {
        @Override
        public String getDescription(ResourceBundle bundle) {
            return bundle.getString("physicalActivity.extraActive");
        }

        @Override
        public Double getValue() {
            return 1.9;
        }
    };

    public abstract String getDescription(ResourceBundle bundle);
    public abstract Double getValue();
}
