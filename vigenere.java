import java.util.Scanner;

public class vigenere {

   public static void main(String[] args) {
      String encrypted = "";
      Key acetum = new Key();
      Sender alice = new Sender(acetum);
      Scanner myObj = new Scanner(System.in);
      System.out.println("Starting as Alice...");
      System.out.println("Enter Key word: ");
      String k = myObj.nextLine();
      acetum.setKey(k);
      System.out.println(acetum.getKey());
      boolean en = true;
      while(en == true) {
         System.out.println("Enter a String or Text File to Encrypt (-1 to quit): ");
         String input = myObj.nextLine();
         if(input.equals("-1")) {
            en = false;
         } else {
            encrypted = alice.setMessage(input);
            System.out.println(alice.showMsg());
         }
      }
      // Receiver bob = new Receiver(encrypted, acetum);
//       System.out.println("Switching to Bob...");
//       System.out.println("Found Message to Read...");
//       System.out.println("Decrypting Message...");
//       System.out.println(bob.showMsg());
//       Attacker eve = new Attacker(encrypted);
//       System.out.println("Switching to Eve...");
//       eve.createStats();
//       System.out.println(eve.showStats());
//       boolean change = true;
//       while(change == true) {
//          System.out.println("Would you like to set a letter? (y = yes and n = no)");
//          String rep = myObj.nextLine();
//          if(rep.equals("n")) {
//             change = false;
//          } else {
//             System.out.println("Which letter do you want to change?");
//             String letter = myObj.nextLine();
//             System.out.println("To what letter?");
//             String ke = myObj.nextLine();
//             eve.setLetter(letter.toUpperCase(), ke);
//          }
//       }
//       boolean answer = true;
//       while(answer == true) {
//          System.out.println("What would you like to do now?");
//          System.out.println("1 = send info to text file | 2 = display message (updated) | 3 = change another letter | 4 = see key | 5 = show stats | 0 = quit");
//          String an = myObj.nextLine();
//          if(an.equals("0")) {
//             answer = false;
//          } else if(an.equals("1")) {
//             eve.moveToTxt();
//          } else if(an.equals("2")) {
//             System.out.println(eve.showMsg());
//          } else if(an.equals("3")) {
//             System.out.println("Which letter do you want to change?");
//             String letter = myObj.nextLine();
//             System.out.println("To what letter?");
//             String ke = myObj.nextLine();
//             eve.setLetter(letter.toUpperCase(), ke);
//          } else if(an.equals("4")) {
//             System.out.println(eve.showKey());
//          } else if(an.equals("5")) {
//             System.out.println(eve.showStats());
//          } else {
//             answer = false;
//          }
//       }
   }
}