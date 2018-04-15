package observer;

class TransitionObserver implements Observer { //�[��̪���@�覡���O�A�Ψӱ����ؼСA��s�ۤv�����A�H�O���M�ؼЪ��A�@�P
	private String color;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void update(Subject subject) {
		color = ((TransitionSubject) subject).getSubject();
		System.out.println(name + "'s color is " + color);
	}
}
