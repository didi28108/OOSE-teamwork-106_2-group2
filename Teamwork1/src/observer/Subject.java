package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private List<Observer> idList = new ArrayList<Observer>();

	public abstract String getSubject();

	public void attach(Observer observer) { //�����[��̵��U
		idList.add(observer);
	}

	public void detach(Observer observer) { //�����[��̰h�q
		idList.remove(observer);
	}

	public void detachAll() {
		idList.clear();
	}

	protected void notifyObserver() { //�q��
		for (int i = 0; i < idList.size(); i++) {
			Observer observer = idList.get(i);
			observer.update(this);
		}
	}
}
