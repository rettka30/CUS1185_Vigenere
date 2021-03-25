import java.util.*;
import java.lang.*;
import java.io.*;

public class Key {

   private ArrayList<String> alphabet;
   private String key;
   private ArrayList<String> cryptex;
   private ArrayList<Stat> stats;

   public Key() {
      alphabet = new ArrayList<String>();
      alphabet.add("a");
      alphabet.add("b");
      alphabet.add("c");
      alphabet.add("d");
      alphabet.add("e");
      alphabet.add("f");
      alphabet.add("g");
      alphabet.add("h");
      alphabet.add("i");
      alphabet.add("j");
      alphabet.add("k");
      alphabet.add("l");
      alphabet.add("m");
      alphabet.add("n");
      alphabet.add("o");
      alphabet.add("p");
      alphabet.add("q");
      alphabet.add("r");
      alphabet.add("s");
      alphabet.add("t");
      alphabet.add("u");
      alphabet.add("v");
      alphabet.add("w");
      alphabet.add("x");
      alphabet.add("y");
      alphabet.add("z");
      key = "";
      cryptex = new ArrayList<String>();
      stats = new ArrayList<Stat>();
   }
   
   public void addStats(String letter, double occ) {
      stats.add(new Stat(letter, occ));
      Collections.sort(stats, new SortingStats()); 
   }
   
   public String getStatVal(int index) {
      return stats.get(index).toString();
   }
   
   public int statSize() {
      return stats.size();
   }
   
   public void setKey(String k) {
      String temp = k.replaceAll("[^a-zA-Z]+","");
      key = k.toLowerCase();
   }
   
   public String getKey() {
      return key;
   }
   
   public String modCharEn(String cor, String index) {
      int c = alphabet.indexOf(cor);
      int i = alphabet.indexOf(index);
      int x = (c+i) % 26;
      return alphabet.get(x).toUpperCase();
   }
   
   public String modCharDe(String cor, String index) {
      int c = alphabet.indexOf(cor.toLowerCase());
      int i = alphabet.indexOf(index.toLowerCase());
      int x = (c-i) % 26;
      return alphabet.get(x);
   }
   
   public String reEn(int s) {
      return cryptex.get(s);
   }
   
   public String reAlpha(int s) {
      return alphabet.get(s);
   }
   
   public String findKeyValue(String a) {
      int g = alphabet.indexOf(a);
      return cryptex.get(g);
   }
   
   public String findAlphaValue(String e) {
      int q = cryptex.indexOf(e);
      return alphabet.get(q);
   }
   
   public int setLetter(String a, String e) {
      int index = alphabet.indexOf(a);
      cryptex.set(index, e);
      return index;
   }
   
   public String alphabetPri() {
      String upper = "";
      for (int j = 0; j < alphabet.size(); j++) {
         if(j == alphabet.size() - 1) {
            upper += alphabet.get(j);
         } else {
            upper += alphabet.get(j) + "|";
         }
      }
      return upper;
   }
   
   public String keyPri() {
      String lower = "";
      for (int z = 0; z < cryptex.size(); z++) {
         if(z == cryptex.size() - 1) {
            lower += cryptex.get(z);
         } else {
            lower += cryptex.get(z) + "|";
         }
      }
      return lower;
   }
   
   public String toString() {
      return alphabetPri() + "\n----------------------------------------------------------------------" + "\n" + keyPri();
   }
   
}