package statediagram;

public class State extends Component {
	public State() {
		super();
		this.attachSubject();
	}

	@Override
	public String getClassName() {
		return "State";
	}

	@Override
	public void attachSubject() {
		mediator.attachStateSubject(this);
	}
}
