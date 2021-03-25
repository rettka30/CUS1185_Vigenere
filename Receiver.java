import java.util.ArrayList;

public class Receiver {

   private Key key;
   private String msg;

   public Receiver(String board, Key k) {
      msg = board;
      key = k;
   }
   
   public String showKey() {
      return key.toString();
   }
   
   public String limit() {
      String temp = "";
      int count = 0;
      for(int i = 0; i < msg.length(); i++) {
         if(count == 125) {
            count = 0;
            char c= msg.charAt(i);  
            temp += "\n" + String.valueOf(c);
         } else {
            char c= msg.charAt(i);  
            temp += String.valueOf(c);
         }
         count++;
      }
      return temp;
   }
   
   public String showMsg() {
      decrypt();
      return limit();
   }
   
   public void decrypt() {
      for(int i = 0; i < msg.length(); i++) {
         String k = String.valueOf(msg.charAt(i));
         String a = key.findAlphaValue(k);
         char d = a.charAt(0);
         StringBuilder message = new StringBuilder(msg);
         message.setCharAt(i, d);
         msg = message.toString();
      }
   }
   
}