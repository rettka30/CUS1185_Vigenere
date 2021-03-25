import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Sender{

   private String message;
   private Key key;
   
   public Sender(Key k) {
      message = "";
      key = k;
   }
   
   public String setMessage(String msg) {
      try {
         File myObj = new File(msg);
         Scanner myReader = new Scanner(myObj);  
         while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String mod = data.replaceAll("[^a-zA-Z]+","");
            message += mod;
         }
         myReader.close();
      } catch (FileNotFoundException e) {
         message = msg;
      }
      String m = message.replaceAll("[^a-zA-Z]+","");
      message = m;
      message = message.toLowerCase();
      encrypt();
      return message;
   }
   
   public void encrypt() {
      int j = 0;
      for(int i = 0; i < message.length(); i++) {
         String a = String.valueOf(message.charAt(i));
         String k = key.getKey();
         String index = String.valueOf(k.charAt(j));
         String temp = key.modCharEn(a,index);
         char d = temp.charAt(0);
         StringBuilder msg = new StringBuilder(message);
         msg.setCharAt(i, d);
         message = msg.toString();
         j++;
         if(j >= k.length()) {
            j = 0;
         }
      }
   }
   
   public String showKey() {
      return key.getKey();
   }
   
   public String limit() {
      String temp = "";
      int count = 0;
      for(int i = 0; i < message.length(); i++) {
         if(count == 125) {
            count = 0;
            char c= message.charAt(i);  
            temp += "\n" + String.valueOf(c);
         } else {
            char c= message.charAt(i);  
            temp += String.valueOf(c);
         }
         count++;
      }
      return temp;
   }
   
   public String showMsg() {
      return limit();
   }
   
}
