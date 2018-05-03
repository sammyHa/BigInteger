package Exercise1317;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise13_17 {
    public static void main(String[] args) throws CloneNotSupportedException {

        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two complex numbers
        System.out.print("Enter the first complex number: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        Complex complexNumber1 = new Complex(a, b);
        System.out.print("Enter the second complex number: ");
        double c = input.nextDouble();
        double d = input.nextDouble();
        Complex complexNumber2 = new Complex(c, d);
        //Complex complexNumber2 = getComplex();

        // displays the result of their addition, subtraction,
        // multiplication, division, and absolute value
        System.out.print(complexNumber1 + " + " + complexNumber2 + " = ");
        print(complexNumber1.add(complexNumber2));

        System.out.print(complexNumber1 + " - " + complexNumber2 + " = ");
        print(complexNumber1.subtract(complexNumber2));

        System.out.print(complexNumber1 + " * " + complexNumber2 + " = ");
        print(complexNumber1.multiply(complexNumber2));

        System.out.print(complexNumber1 + " / " + complexNumber2 + " = ");
        print(complexNumber1.divide(complexNumber2));

        System.out.println("|" + complexNumber1 + "| = " +
                complexNumber1.abs());

        Complex complexNumber3 = (Complex)complexNumber1.clone();
        System.out.println(complexNumber1 == complexNumber3);
        System.out.println(complexNumber3.getRealPart());
        System.out.println(complexNumber3.getImaginaryPart());
        Complex complexNumber4 = new Complex(4, -0.5);
        Complex[] list = {complexNumber1, complexNumber2, complexNumber3, complexNumber4};
        java.util.Arrays.sort(list);
        System.out.println(java.util.Arrays.toString(list));

    }

    /** Display result */
    public static void print(Complex n) {
        if (n.getImaginaryPart() == 0)
            System.out.println(n.getRealPart());
        else
            System.out.println(n.getRealPart() + " + " +
                    n.getImaginaryPart() + "i");
    }

//    /** Return user input as a complex number */
//    public static Complex getComplex() {
//        // Create a Scanner object
////        Scanner input = new Scanner(System.in);
//        double[] c = new double[2];
//        for (int i = 0; i < c.length; i++) {
////            c[i] = input.nextDouble();
//
//        }return new Complex(c[0], c[1]);
//    }
}


class Complex implements Cloneable, Comparable{

    private double a;
    private double b;

   public Complex(){
        this(0, 0);
    }

   public Complex(double a){
        this(a, 0);
    }

   public Complex(double a , double b){
        this.a = a;
        this.b = b;

    }


    //now create the methods
    /** Return real part of complex number */
    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart(){
       return b;
    }

    //add
    public Complex add(Complex secondComplex){
       return new Complex(a + secondComplex.a, b + secondComplex.b);
    }

    //sub
    public Complex subtract(Complex secondComplex){
       return new Complex(a - secondComplex.a, b - secondComplex.b);
    }

    //product
    public Complex multiply(Complex secondComplex){
       return new Complex(a * secondComplex.a - b * secondComplex.b, b * secondComplex.a + a * secondComplex.b);
    }

    // Divide
    public Complex divide(Complex secondComplex) {
        return new Complex((a * secondComplex.a + b * secondComplex.b) /
                (Math.pow(secondComplex.a, 2) + Math.pow(secondComplex.b, 2)),
                (b * secondComplex.a - a * secondComplex.b) /
                        (Math.pow(secondComplex.a, 2) +  Math.pow(secondComplex.b, 2)));
    }

    //return abs value
    public double abs(){
       return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public Complex clone() throws CloneNotSupportedException{
       return (Complex)super.clone();
    }


    @Override
    public String toString() {
        return b == 0 ? a + "" : "(" + a + " + " + b + "i)";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}