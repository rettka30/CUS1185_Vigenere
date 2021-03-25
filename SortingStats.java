import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class SortingStats implements Comparator<Stat> {
   
   public int compare(Stat a, Stat b) {
      if (a.stat < b.stat) {
         return -1;
      }
      if (b.stat > a.stat) {
         return 1;
      }
      return 0;   
   }
     
} 