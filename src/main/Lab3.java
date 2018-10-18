/*
    Programming for Computer Scientists (CS118) - Lab 3
    Conditionals and arrays
*/

// This class contains method stubs for the exercises in Lab 3
public class Lab3
{

    // this method should return the smaller of the two integers
    public int min(int x, int y)
    {
      if (x <= y)
      {
        return x;
      } else
      {
        return y;
      }
    }

    // this method should return the larger of the two integers
    public int max(int x, int y)
    {
        if (x >= y)
        {
          return x;
        } else {
          return y;
        }
    }

    // this method should return the median of the three integers
    public int median(int a, int b, int c)
    {
      return max(max(min(a,b),min(a,c)),max(min(a,c),min(c,b)));
    }

    // this method should calculate how much tax someone with the
    // specified income should pay according to the tax rules
    // given in the lab sheet
    public double taxToPay(int income)
    {
      float tax = 0f;
      if (income <= 11850)
      {
        tax = 0f;
      } else if (income <= 46350)
      {
        tax = 0.2f * (income - 11850);
      } else if (income <= 150000)
      {
        tax = 6900 + 0.4f * (income - 46350);
      } else if (income > 150000)
      {
        tax = 6900 + 41460 + 0.45f * (income - 150000);
      }
        return tax; // this is everyone's dream
    }

    // given a digit (0-9), this method should return an array of bits
    // (represented as booleans) which indicate which
    public boolean[] segments(byte digit)
    {
        // initialise an array of 7 booleans,
        // all of which are initailised to false

        switch (digit)
        {
          case 0:
            boolean[] result0 = { true, true, true, true, true, true, false};
            return result0;

          case 1:
            boolean[] result1 = { false, true, true, false, false, false, false};
            return result1;
          case 2:
            boolean[] result2 = { true, true, false, true, true, false, true};
            return result2;

          case 3:
            boolean[] result3 = { true, true, true, true, false, false, true};
            return result3;

          case 4:
            boolean[] result4 = { false, true, true, false, false, true, true};
            return result4;

          case 5:
            boolean[] result5 = { true, false, true, true, false, true, true};
            return result5;

          case 6:
            boolean[] result6 = { true, false, true, true, true, true, true};
            return result6;

          case 7:
            boolean[] result7 = { true, true, true, false, false, false, false};
            return result7;

          case 8:
            boolean[] result8 = { true, true, true, true, true, true, true};
            return result8;

          case 9:
            boolean[] result9 = {true,true,true,true,false,true,true};
            return result9;

          default:
            boolean[] result = { false, false, false, false, false, false, false };
            return result;
        }
    }

    // given an array of digits (0-9), this method should return a byte for
    // each digit where the resulting byte indicates which segments should be
    // switched on such that the least significant bit corresponds to the 1st
    // segment and all but the most significant bit are used
    public byte[] segmentsBytes(byte[] digits)
    {
        byte[] results = new byte[digits.length];
        for (int i = 0; i <= digits.length; i++)
        {
          boolean[] x = segments(digits[i]);
          int bool = 0;
          for (i2 = 0, i2 < 7, i2++)
          {
            bool
          }
        }
        return results;
    }
}
