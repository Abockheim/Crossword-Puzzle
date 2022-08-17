// programer: Alexander Bockheim
// Class: CS 145
// The main for the word search generator 
import java.util.*;
import java.io.*;

public class WordSearchMain{

   public static void main(String[] args) {
   
      boolean generated = false;
      
         Scanner console = new Scanner(System.in);
      
         String options;
      
         WordSearch search = new WordSearch();

      do{

         printIntro(); // options 
      
         options = console.next();
    
      if(options.equals("g")){
      
         System.out.println("Enter words line by line until you are finished at which point type a single \"q\"");
      
         String token = console.next();
      
         ArrayList<String> wordsArray = new ArrayList<String>();
    
      do{
      
         wordsArray.add(token);
      
         token = console.next();
      
   }  while(!token.equals("q"));
      
         String[] words = new String[wordsArray.size()];
      
         wordsArray.toArray(words);
      
         search.generate(words);
      
         generated = true;
      
   }  else if(options.equals("p")){
      
      if(generated){
      
         print(search);
  
      }
      
      }else if(options.equals("s")){
   
      if(generated){
      
         showSolution(search);
      }

   }

      }while(!options.equals("q"));

   }  

      public static void printIntro(){ // prints the intro
   
         System.out.println("Welcome to my word search generator!");
      
         System.out.println("This programs will allow you to generate your own word search puzzle");
      
         System.out.println("Please select and option:");
      
         System.out.println("Generate a new word search (g)");
      
         System.out.println("Print out your word search (p)");
      
         System.out.println("Show the solution to your word search(s)");
      
         System.out.println("Quit the prograrm (q)");
         
      }


      public static void print(WordSearch ws){ // Prints the word search 
      
         System.out.println(ws);
      }


      public static void showSolution(WordSearch ws){ // Prints the solution
      
         System.out.println(ws.toSolution());
      }
   }
