/*
    Programming for Computer Scientists (CS118) - Lab 3
    Conditionals and arrays
*/

// This class contains method stubs for the exercises in Lab 3
public class Lab3 {

    // this method should return the smaller of the two integers
    public int min(int x, int y) {
      if (x <= y){
        return x;
      } else {
        return y;
      }
    }

    // this method should return the larger of the two integers
    public int max(int x, int y) {
        if (x >= y){
          return x;
        } else {
          return y;
        }
    }

    // this method should return the median of the three integers
    public int median(int a, int b, int c) {
      return max(max(min(a,b),min(a,c)),max(min(a,c),min(c,b)));
    }

    // this method should calculate how much tax someone with the
    // specified income should pay according to the tax rules
    // given in the lab sheet
    public double taxToPay(int income) {
      float tax;
      if (income < 11850){
        tax = 0f;
      } else if (income < 46350) {
        tax += 0.2f(income-11850);
      } else if (income < 150000) {
        tax = 6900+0.4f(income-46350);
      } else if (income > 150000) {
        tax = 41460+0.45f(income-150000);
      }
        return tax; // this is everyone's dream
    }
    /*    public double taxToPay(int income) {
      float tax = 0f;
      if (income > 11850){
        tax += 0.2f*(46350-income-11850);
      } else if (income > 46350) {
        tax += 0.4f(150000-income-46350)f;
      } else if (income > 150000) {
        tax += 0.45f(income-150000)f;
      }
        return tax; // this is everyone's dream
    }*/

    // given a digit (0-9), this method should return an array of bits
    // (represented as booleans) which indicate which
    public boolean[] segments(byte digit) {
        // initialise an array of 7 booleans,
        // all of which are initailised to false
        boolean[] result = new boolean[]
            { false, false, false, false, false, false, false };

        return result;
    }

    // given an array of digits (0-9), this method should return a byte for
    // each digit where the resulting byte indicates which segments should be
    // switched on such that the least significant bit corresponds to the 1st
    // segment and all but the most significant bit are used
    public byte[] segmentsBytes(byte[] digits) {
        byte[] results = new byte[digits.length];

        return results;
    }
}
