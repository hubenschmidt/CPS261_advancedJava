package models;

public class Die {
    private int sides;
    private int face;

    public Die(int sides, int face) {
	this.sides = sides;
	this.face = face;

    }

    public int getSides() {
	return sides;
    }

    public int getFace() {
	return face;
    }

    public void setSides(int sides) {
	this.sides = sides;
    }

    public void setFace(int top) {
	if (top > 0 && face <= sides) {
	    this.face = face;
	}
    }

    public void roll() {
	face = 1 + (int) (Math.random() * sides); // cast from double to int in view of physical constraints of a die
    }

}
