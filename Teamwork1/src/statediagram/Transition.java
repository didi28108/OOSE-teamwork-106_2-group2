package statediagram;

public class Transition extends Component {
	public Transition() {
		super();
		this.attachSubject();
	}

	@Override
	public String getClassName() {
		return "Transition";
	}

	@Override
	public void attachSubject() {
		mediator.attachTransitionSubject(this);
	}
}
