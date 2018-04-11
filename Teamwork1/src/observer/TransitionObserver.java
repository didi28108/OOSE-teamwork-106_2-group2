package observer;

class TransitionObserver implements Observer{ //觀察者的實作方式類別，用來接收目標，更新自己的狀態以保持和目標狀態一致
	private String color;
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public void update(Subject subject){
		color=((TransitionSubject)subject).getSubject();
		System.out.println(name+"'s color is "+color);
	}
}
