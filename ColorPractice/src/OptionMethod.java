public class OptionMethod {

    private String name;
    private Runnable method;

    public OptionMethod(String name, Runnable method) {
        this.name = name;
        this.method = method;
    }

    @Override
    public String toString() {
        return name;
    }

    public void invoke() {
        method.run();
    }

}