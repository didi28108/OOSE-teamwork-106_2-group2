package observer;

public class StateSubject extends Subject { //��ڪ��ؼй�{���O�A�ΨӺ��@�ؼЪ��A�A���A�@�����ܡA�K���q���U���[���
	private String statesubject;

	public String getSubject() {
		return statesubject;
	}

	public void setSubject(String statesubject) {
		this.statesubject = statesubject;
		this.notifyObserver();
	}
}
