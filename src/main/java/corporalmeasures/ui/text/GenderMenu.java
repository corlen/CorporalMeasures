package corporalmeasures.ui.text;

public class GenderMenu implements Menu {

    @Override
    public String describe() {
        StringBuilder description = new StringBuilder("Sexo: " + LINE_SEPARATOR);
        description.append("1 - Masculino" + LINE_SEPARATOR);
        description.append("2 - Feminino");
        return description.toString();
    }

    @Override
    public void execute(String input) {

    }

    @Override
    public Menu next() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean requireInput() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
