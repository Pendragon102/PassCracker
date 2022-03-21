import java.util.*;
import java.security.*;
import java.math.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

class Crack {
  private static String cyString = "";
  private static String pass = "";
  private static String mode = "";
  private static File top10k = new File("top10k.txt");
  private static Scanner passList = new Scanner(top10k);
  
  public static void main(String[] args) throws Exception{
    Scanner in = new Scanner(System.in);
    
    System.out.println("What kind of password are we working with? plain/md5/sha256/bcrypt (plaintext will use brute force and the rest will use dictionary)");
    mode = in.next();
    
    System.out.println("Please input a password (if plaintext, max length 8 characters):\n");
    pass = in.next();
    System.out.println("Alrighty, workin' on it!");
    if(mode.equals("md5")){
      pass = MD5(pass.toLowerCase());
      cyString = (pass);
    }
    System.out.println("Your password is: " + cyString);
    }
    
  public static String bruteforce(String check) throws Exception{
    char[] ch = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    for (int i = 0; i < ch.length; i++) {
      char c1 = ch[i];
      for (int j = 0; j < ch.length; j++) {
        char c2 = ch[j];
        for (int k = 0; k < ch.length; k++) {
          char c3 = ch[k];
          for (int l = 0; l < ch.length; l++) {
            char c4 = ch[l];
            for (int m = 0; m < ch.length; m++) {
              char c5 = ch[m];
              for (int n = 0; n < ch.length; n++) {
                char c6 = ch[n];
                for (int o = 0; o < ch.length; o++) {
                  char c7 = ch[o];
                  for (int p = 0; p < ch.length; p++) {
                    char c8 = ch[p];
                    currentString = "" + c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8;
                    if(currentString.equals(check));
                  }
                }
              }
            }
          }
        }
      }
    }
    return new String("yes");
  }
    
  public static String MD5(String s) throws Exception{
    MessageDigest check = MessageDigest.getInstance("MD5");
    check.update(s.getBytes(),0,s.length());
    return new BigInteger(1, check.digest()).toString(16);
  }

   public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte h : hash) {
            String hex = Integer.toHexString(0xff & h);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
  
  public static String SHA256(final String originalString) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA_256");
        final byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
    }
}
