package corporalmeasures.ui.text;

public interface Menu {
    public String LINE_SEPARATOR = System.getProperty("line.separator");

    public String describe();

    public void execute(String input);

    public Menu next();

    public boolean requireInput();
}
