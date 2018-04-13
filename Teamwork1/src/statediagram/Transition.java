package statediagram;

public class Transition extends Component {
	public Transition() {
		super();
		mediator.attachTransitionSubject(this);
	}
}
