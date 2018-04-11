package observer;

import java.util.*;

public class ObserverTest {
	public static void main(String[] args) {
		StateSubject statesubject = new StateSubject();
		TransitionSubject transitionsubject = new TransitionSubject();
		
		StateObserver s1 = new StateObserver();		
		s1.setName("State_1");
		StateObserver s2 = new StateObserver();
		s2.setName("State_2");
		StateObserver s3 = new StateObserver();
		s3.setName("State_3");

		TransitionObserver t1 = new TransitionObserver();
		t1.setName("Transition_1");
		TransitionObserver t2 = new TransitionObserver();
		t2.setName("Transition_2");
		
		statesubject.attach(s1);
		statesubject.attach(s2);
		statesubject.attach(s3);
		statesubject.detach(s3);
		
		transitionsubject.attach(t1);
		transitionsubject.attach(t2);
		transitionsubject.detach(t2);

		
		statesubject.setSubject("blue");
		transitionsubject.setSubject("red");
	}

}
