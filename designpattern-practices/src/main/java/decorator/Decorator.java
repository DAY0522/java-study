package decorator;

public abstract class Decorator extends Component { // 보조스트림
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}
