package model;

/**
 * In object oriented programming terminology, and interface is a contract. It
 * defines a set of methods with particular signatures. Any class that
 * implements that interface, must implement those methods. It's a guarantee
 * that those methods and other members of the class will be present. You can
 * then treat that object as an instance of the interface, passing it to methods
 * that expect objects that satisfy the contract. I
 * 
 * @author williamroymbp
 *
 */

public interface Product {

	/**
	 * When you define these methods in the interface, you don't add implementing
	 * code. These are known as 'abstract methods'. Methods that don't have any
	 * implementation, but justifying what they're suppose to do, not how they do
	 * it. They get type method returns a string, and that's all you need to know.
	 * 
	 * note: the lack of access modifiers is intentional. you dont need them.
	 * 
	 * @return
	 */
	String getType();

	String getSize();

	double getPrice();

}
