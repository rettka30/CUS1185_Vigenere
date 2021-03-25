import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Attacker {

   private String message;
   private Key key;
   
   public Attacker(String board, Key k) {
      message = board;
      key = k;
   }
   
   public void setLetter(String k, String a) {
      int i = key.setLetter(a, k);
      update(i);
   }
   
   public void update(int i) {
      String ke = key.reEn(i);
      for(int o = 0; o < message.length(); o++) {
         String k = String.valueOf(message.charAt(o));
         if(k.equals(ke)) {
            String a = key.findAlphaValue(k);
            char d = a.charAt(0);
            StringBuilder msg = new StringBuilder(message);
            msg.setCharAt(o, d);
            message = msg.toString();
         }
      }
   }
   
   public void createStats() {
      for(int n = 0; n < 26; n++) {
         statforletter(key.reAlpha(n).toUpperCase());
      }
   }
   
   public void statforletter(String l) {
      double num = 0;
      for(int h = 0; h < message.length(); h++) {
         if(String.valueOf(message.charAt(h)).equals(l)) {
            num++;
         }
      }
      double stat = num/message.length();
      BigDecimal bd = new BigDecimal(stat).setScale(5, RoundingMode.HALF_UP);
      double newStat = bd.doubleValue();
      key.addStats(l, newStat);
   }
   
   public String getStats() {
      String d = "";
      for(int f = 0; f < key.statSize(); f++) {
         if(f == 0) {
            d += key.getStatVal(f);
         } else {
            d += "\n" + key.getStatVal(f);
         }
      }
      return d;
   }
   
   public String showStats() {
      return getStats();
   }
   
   public String showKey() {
      return key.toString();
   }
   
   public String limit() {
      String temp = "";
      int count = 0;
      for(int i = 0; i < message.length(); i++) {
         if(count == 150) {
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
   
   public void moveToTxt() {
      try {  
         //FileWriter myWriter = new FileWriter("AttackerFullView.txt");
         FileWriter myWriter = new FileWriter("AttackerView.txt");
         myWriter.write(showKey());
         myWriter.write("\n" + getStats());
         myWriter.write("\n" + limit());
         myWriter.close();
      } catch (IOException e) {
         e.printStackTrace();
      } 
   }
   
}
