package dao;

public class Producto {
	
	private int id;
	private String name;
	private float prices;
	//constructor constructores
	public Producto() {
		
		// TODO Auto-generated constructor stub
	}
	
	public Producto(int id, String name, float prices) {
		this.id = id;
		this.name = name;
		this.prices = prices;
	}

	
	public Producto(String name, float prices) {
		this.name = name;
		this.prices = prices;
	}

	//getters y setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrices() {
		return prices;
	}
	public void setPrices(float prices) {
		this.prices = prices;
	}
	public int getId() {
		return id;
	}
	//toSring
	@Override
	public String toString() {
		return String.format("%s,%s,%s", id, name, prices);
	}
	
}
