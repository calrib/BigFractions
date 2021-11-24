import java.math.BigInteger;

public class Fraction
  implements Comparable<Fraction> {

  BigInteger numerator;
  BigInteger denominator;

  public Fraction(BigInteger n, BigInteger d) {
    if (d == BigInteger.ZERO) {
      throw new IllegalArgumentException(d.toString());
    }
    numerator = n;
    denominator = d;
  }

  public Fraction(int n, int d){
    if (d == 0){
      throw new IllegalArgumentException();
    }
    numerator = BigInteger.valueOf(n);
    denominator = BigInteger.valueOf(d);
  }

  public Fraction(int n){
    numerator = BigInteger.valueOf(n);
    denominator = BigInteger.ONE;
  }

  public Fraction(BigInteger n) {
    numerator = n;
    denominator = BigInteger.ONE;
  }

  public BigInteger getNumerator(){
    return numerator;
  }

  public BigInteger getDenominator(){
    return denominator;
  }
  
  public Fraction add(Fraction f){
    BigInteger nSum =
      numerator.multiply(f.getDenominator()).add(denominator.multiply(f.getNumerator()));
   
    BigInteger dSum = denominator.multiply(f.getDenominator());

    Fraction sum = new Fraction (nSum, dSum);
    sum.reduce();

    return sum;
  }

  public Fraction subtract(Fraction f){
    BigInteger nSum =  numerator.multiply(f.getDenominator()).subtract(f.getNumerator().multiply(denominator));

    BigInteger dSum = denominator.multiply(f.getDenominator());
    
    Fraction result = new Fraction (nSum, dSum);
    result.reduce();

    return result; 
  }
  
  public Fraction multiply(Fraction f){
    BigInteger nProd = numerator.multiply(f.getNumerator());
    BigInteger dProd = denominator.multiply(f.getDenominator()) ;
    
    Fraction prod = new Fraction(nProd, dProd);
    prod.reduce();
    return prod;
  }

  public Fraction divide(Fraction f){
    BigInteger nProd = numerator.multiply(f.getDenominator()); 
    BigInteger dProd = denominator.multiply(f.getNumerator());
    
    Fraction result = new Fraction(nProd, dProd);
    
    result.reduce();
    return result;
  }

  public String toString(){
    return numerator.toString() + "/" + denominator.toString();
  }

  public static Fraction valueOf(int n, int d){
    Fraction f = new Fraction (n, d);
    return f;
  }


  public double doubleValue(){
    
    return numerator.doubleValue()/(denominator.doubleValue());
  }

  public float floatValue(){
    return numerator.floatValue()/denominator.floatValue();
  }

  public long longValue(){
    return numerator.longValue()/denominator.longValue();
  }

  public int intValue(){
    return numerator.intValue()/denominator.intValue();
  }

  public int compareTo(Fraction f) {
    BigInteger n = f.getDenominator().multiply(numerator);
    BigInteger m = f.getNumerator().multiply(denominator);
    return n.compareTo(m);
  }



  private void reduce() {
    BigInteger gcd = numerator.gcd(denominator);
    numerator = numerator.divide(gcd);
    denominator = denominator.divide(gcd);
  }
}