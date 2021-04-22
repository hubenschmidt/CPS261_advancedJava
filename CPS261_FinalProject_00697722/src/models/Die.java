package models;

public class Die {
    private int sides;
    private int top;

//    public Die() {
//    }

    public Die(int sides, int top) {
	this.sides = sides;
	this.top = top;

    }

    public int getSides() {
	return sides;
    }

    public int getTop() {
	return top;
    }

    public void setSides(int sides) {
	this.sides = sides;
    }

    public void setTop(int top) {
	if (top > 0 && top <= sides) {
	    this.top = top;
	}
    }

    public void roll() {
	top = 1 + (int) (Math.random() * sides); // cast from double to int in view of physical constraints of a die
	System.out.println(top);

    }

}
