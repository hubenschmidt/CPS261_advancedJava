package model;

/**
 * When designing an object-oriented contract based programming architecture,
 * you can frequently choose between using interfaces and abstract classes. You
 * mark an abstract class with the abstract keyword in the class declaration.
 * When it's abstract, it can't be instantiated directly. You have to use one of
 * its subclasses
 * 
 * @author williamroymbp
 *
 */

public abstract class ClothingItem implements Product {
	private String type;
	private String size;
	private double price;

	public ClothingItem(String type, String size, double price) {
		this.type = type;
		this.size = size;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public abstract double getPrice();

//	public double getPrice() {
//		return price;
//	}

//	public void setPrice(double price) {
//		this.price = price;
//	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "ClothingItem [type=" + type + ", size=" + size + ", price=" + price + "]";
	}

}
