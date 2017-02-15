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
 * Filename : RationalTest.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class RationalTest{
public static void main(String[] args) { 
	Rational b =  new Rational(3,4); // b = 0/1 
	Rational a = new Rational(1, 2); // a = 1/2 
	Rational c = a.plus(b); //it returns (a.numer / a.denom) + (b.numer / b.denom) 
	Rational d = a.minus(b);
	Rational e = a.mult(b);
	Rational f = a.div(b);
	//and stores the value in c 
	System.out.println(a.numer+"/"+a.denom+" + "+ b.numer+"/"+b.denom + " = " + c.numer+"/"+c.denom); 
	System.out.println(a.numer+"/"+a.denom+" - "+ b.numer+"/"+b.denom + " = " + d.numer+"/"+d.denom); 
	System.out.println(a.numer+"/"+a.denom+" * "+ b.numer+"/"+b.denom + " = " + e.numer+"/"+e.denom); 
	System.out.println(a.numer+"/"+a.denom+" / "+ b.numer+"/"+b.denom + " = " + f.numer+"/"+f.denom); 
}
}