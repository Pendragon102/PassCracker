import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

class Crack<BCrypt> {
    private static String cyString = "";
    private static String pass = "";
    private static String mode = "";
    private static File top10k = new File("top10k.txt");
    private static Scanner passList;
    //private static BCrypt bcrypt = new BCrypt();

    static {
        try {
            passList = new Scanner(top10k);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);

        System.out.println("What kind of password are we working with? plain/md5/sha256/bcrypt (plaintext will use brute force and the rest will use dictionary)");
        mode = in.next();

        System.out.println("Please input a password (if plaintext, max length 8 characters):\n");
        pass = in.next();
        System.out.println("Alrighty, workin' on it!");
        if(mode.equals("plain")){
            cyString = bruteforce(pass);
        }
        else{
            if(mode.equals("md5")){
                while(passList.hasNextLine()){
                    String data = passList.nextLine();
                    if(MD5(data).equals(pass)){
                        cyString = data;
                    }
                }
            }
            else if(mode.equals("sha256")){
                while(passList.hasNextLine()){
                    String data = passList.nextLine();
                    if(SHA256(data).equals(pass)){
                        cyString = data;
                    }
                }
            }
            //else if(mode.equals("bcrypt")){
                //pass = bcrypt.hashpw(pass, bcrypt.gensalt());
            //}
            while(passList.hasNextLine()){
                String data = passList.nextLine();
                if(data.equals(pass)){
                    cyString = data;
                }
            }
        }
        System.out.println("Your password is: " + cyString);
    }

    public static String bruteforce(String check) throws Exception{
        char[] ch = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        String currentString = "";
        for (int i = 0; i < ch.length; i++) {
            char c1 = ch[i];
            currentString = "" + c1;
            if(currentString.equals(check)){
                return currentString;
            }
            for (int j = 0; j < ch.length; j++) {
                char c2 = ch[j];
                currentString = "" + c1 + c2;
                if(currentString.equals(check)){
                    return currentString;
                }
                for (int k = 0; k < ch.length; k++) {
                    char c3 = ch[k];
                    currentString = "" + c1 + c2 + c3;
                    if(currentString.equals(check)){
                        return currentString;
                    }
                    for (int l = 0; l < ch.length; l++) {
                        char c4 = ch[l];
                        currentString = "" + c1 + c2 + c3 + c4;
                        if(currentString.equals(check)){
                            return currentString;
                        }
                        for (int m = 0; m < ch.length; m++) {
                            char c5 = ch[m];
                            currentString = "" + c1 + c2 + c3 + c4 + c5;
                            if(currentString.equals(check)){
                                return currentString;
                            }
                            for (int n = 0; n < ch.length; n++) {
                                char c6 = ch[n];
                                currentString = "" + c1 + c2 + c3 + c4 + c5 + c6;
                                if(currentString.equals(check)){
                                    return currentString;
                                }
                                for (int o = 0; o < ch.length; o++) {
                                    char c7 = ch[o];
                                    currentString = "" + c1 + c2 + c3 + c4 + c5 + c6 + c7;
                                    if(currentString.equals(check)){
                                        return currentString;
                                    }
                                    for (int p = 0; p < ch.length; p++) {
                                        char c8 = ch[p];
                                        currentString = "" + c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8;
                                        if(currentString.equals(check)){
                                            return currentString;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return new String("Not found or longer than 8 characters sowwy");
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
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
    }
}
