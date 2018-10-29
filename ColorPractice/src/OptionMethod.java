public class OptionMethod {

    private String name;
    private Runnable method;
    private Class clas;

    public OptionMethod(String name, Runnable method) {
        this.name = name;
        this.method = method;
        //this.clas = clas;
    }

    @Override
    public String toString() {
        return name;
    }

    public void invoke() {
        method.run();
    }
}