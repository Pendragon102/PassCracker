import java.security.*;
import java.math.*;
import java.util.*;

public class Crack{
  public static void main(String args) throws Exception{
    Crack test = new Crack();
    Scanner in = new Scanner(System.in);   
    String passmd5;
    if(args != null){    
      passmd5 = test.MD5(s);
    }
    else{
      System.out.println("Please input a password: ");
      String pass = in.nextLine();
      passmd5 = test.MD5(pass);
    }
    String md5 = test.MD5("brokenwings");
    System.out.println("MD5 Hash: " + md5);
  }
  
  public static String MD5(String s) throws Exception{
    MessageDigest check = MessageDigest.getInstance("MD5");
    check.update(s.getBytes(),0,s.length());
    return new BigInteger(1, check.digest()).toString(16);
  }
}
