package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject{
	private List<Observer> idList=new ArrayList<Observer>();
	
	public void attach(Observer observer){    //提供觀察者註冊
		idList.add(observer);
	}
	public void detach(Observer observer){    //提供觀察者退訂
		idList.remove(observer);
	}
	protected void notifyObserver(){        //通知
		for(int i=0;i<idList.size();i++){  
		    Observer observer=idList.get(i);
			observer.update(this);
		}
	}
}
