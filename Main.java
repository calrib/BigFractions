import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
  @Test
  public void numeratorTest(){
    Fraction f = new Fraction(BigInteger.ONE);
    assertEquals(BigInteger.ONE, f.getNumerator());
  }
  
  @Test 
  public void denominatorTest(){
    Fraction f = new Fraction(BigInteger.ONE);
    assertEquals(BigInteger.ONE, f.getDenominator());
  }

  @Test
  public void multiplyTest() {
    Fraction f = new Fraction(2);
    Fraction g = new Fraction(1, 2);
    assertEquals(1, f.multiply(g).intValue());
  }

  @Test
  public void toStringTest() {
    Fraction f = new Fraction(1);
    assertEquals("1/1", f.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void divideByZeroTest() {
    Fraction f = new Fraction(1, 0);
  }

  @Test
  public void doubleValueTest() {
    Fraction f = new Fraction(2, 3);
    assertEquals(2.0/3.0, f.doubleValue(), 0.0);
  }

  public void additionTest() {
    Fraction f = new Fraction(1);
    Fraction g = new Fraction(1);
    assertEquals(2, f.add(g).intValue());

  }
  @Test
  public void divisionTest() {
    Fraction f = new Fraction(4,5);
    Fraction g = new Fraction(1,5);
    assertEquals(4, f.divide(g).intValue());
  }
  
  @Test
  public void sortTest() {
    Fraction[] arr = {
      new Fraction(1, 2),
      new Fraction(1, 16),
      new Fraction(1, 8),
      new Fraction(1, 4)
    };
    Arrays.sort(arr);
    assertEquals("1/16", arr[0].toString());
  }

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("Main");
  }

}