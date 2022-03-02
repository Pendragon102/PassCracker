import java.security.*;
import java.math.*;


public class Crack{
  public static void main(String[] args) throws Exception{
    Crack test = new Crack();
    Scanner in = new Scanner(System.in);
    System.out.println("Please input a password: ");
    String pass = in.nextLine();
    String passmd5 = test.MD5(pass);
    if(args.length > 0){
      for(String s: args){
        String clamd5 = test.MD5(s);
        
      }
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
