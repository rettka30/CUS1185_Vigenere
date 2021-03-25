public class Stat {

   public String letter;
   public double stat;
   
   public Stat(String l, double s) {
      letter = l;
      stat = s;
   }
   
   public String toString() {
      letter.toUpperCase();
      return letter + ": " + stat;
   }
} 