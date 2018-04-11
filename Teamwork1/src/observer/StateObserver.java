package observer;

public class StateObserver implements Observer {
	private String color;
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public void update(Subject subject){
		color=((StateSubject)subject).getSubject();
		System.out.println(name+"'s color is "+color);
	}
}
