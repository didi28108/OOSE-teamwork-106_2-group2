package observer;

public class StateSubject extends Subject{  //實際的目標實現類別，用來維護目標狀態，當狀態一有改變，便須通知各個觀察者
	private String statesubject;

	public String getSubject() {
		return statesubject;
	}

	public void setSubject(String statesubject) {
		this.statesubject = statesubject;
		this.notifyObserver();
	}
}
