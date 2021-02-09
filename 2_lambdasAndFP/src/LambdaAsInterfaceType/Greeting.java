package LambdaAsInterfaceType;

@FunctionalInterface
//functional interface makes it invalid to add more than one abstract method to the interface,
// thus making it compatible only as a functional interface, most readily for use with lambdas
public interface Greeting {
	public void perform();

}
