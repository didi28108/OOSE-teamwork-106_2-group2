package observer;

public class TransitionSubject extends Subject {
private String transitionsubject;
	
	public String getSubject(){
		return transitionsubject;
	}
	public void setSubject(String transitionsubject){
		this.transitionsubject=transitionsubject;
		this.notifyObserver();
	}
}
