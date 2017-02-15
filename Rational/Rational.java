/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Austin
 * Last Name: Raun
 * Lab Section: 3A
 * email address: araun@uci.edu
 *
 *
 * Assignment: lab1
 * Filename : Rational.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */


public class Rational{
public int numer; 
public int denom;

public Rational(){} 
public Rational(int aNumer, int aDenom) {
	
	this.numer=aNumer;
	this.denom=aDenom;
	
}
//(this.numer / this.denom) + (b.numer / b.denom) = ((this.numer * b.denom) / (this.denom * b.denom)) + ((b.numer * this.denom) / (b.denom * this.denom)) 
public Rational plus(Rational b) {
	int d1 = (this.numer * b.denom) + (this.denom * b.numer);
	int d2 = (b.denom * this.denom);
	Rational d = new Rational (d1,d2);
	return d;
	
} 
//(this.numer / this.denom) - (b.numer / b.denom) = ((this.numer * b.denom) / (this.denom * b.denom)) - ((b.numer * this.denom) / (b.denom * this.denom)) 
public Rational minus(Rational b) {
	int e1 = (this.numer * b.denom) - (this.denom * b.numer);
	int e2 = (b.denom * this.denom);
	Rational e = new Rational (e1,e2);
	return e;
	
} 
//(this.numer / this.denom) * (b.numer / b.denom) 
public Rational mult(Rational b) {
	int f1 = (this.numer * b.numer);
	int f2 = (this.denom * b.denom);
	Rational f = new Rational (f1,f2);
	return f;
} 
//(this.numer / a.denom) / (b.numer / b.denom) = (this.numer / this.denom) * (b.denom / b.numer) 
public Rational div(Rational b) {
	int g1 = (this.numer * b.denom);
	int g2 = (this.denom * b.numer);
	Rational g = new Rational (g1,g2);
	return g;
	
	
}

}