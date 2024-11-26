package decorator;

public class ConcreteComponent extends Component { // 주스트림
    private String text;

    public ConcreteComponent(String text) {
        this.text = text;
    }

    @Override
    public String operation() {
        return text;
    }
}