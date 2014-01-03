package corporalmeasures.ui.text;

public class MainMenu implements Menu {

    private Menu next;

    @Override
    public String describe() {
        StringBuilder description = new StringBuilder("Menu:" + LINE_SEPARATOR);
        description.append("1 - Peso Ideal" + LINE_SEPARATOR);
        description.append("2 - Gasto Calórico Basal");
        return description.toString();
    }

    @Override
    public void execute(String input) {
        Integer option = Integer.parseInt(input);
        switch(option) {
            case 1: {
                next = new WeightMenu();
                break;
            }
            case 2: {
                next = new GastoCaloricoMenu();
            }
            default: {
                throw new ExecutionError();
            }
        }
    }

    @Override
    public Menu next() {
        return next;
    }

    @Override
    public boolean requireInput() {
        return true;
    }


}
