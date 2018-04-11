package observer;

interface Observer{
	public void setName(String name);
	public String getName();
	public void update(Subject subject);
}
