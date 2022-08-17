// programer: Alexander Bockheim
// Class: CS 145
// word search generator code 

import java.util.*;
import java.io.*;


public class WordSearch{
private char[][] grid;
private boolean[][] solution;
private String[] words;


      public void generate(String[] w){ 
      
      for(int i = 0 ; i < w.length ; i++){
         
         w[i] = w[i].toLowerCase();
  
   }
      
      this.words = w;
      
      char[][] wordChars = gridSetup();
      
      for(int i = 0 ; i < wordChars.length ; i++){
         
         placeWord(wordChars, i);
   
   }

         fillGrid();

}

      public String toString(){
      
         String result = "";
      
      for(int i = 0 ; i < grid.length ; i++){
      
      for(int x = 0 ; x < grid[i].length ; x++){
      
         result += " " + grid[i][x] + " ";
   
   }
      
         result += "\r\n";
   
   }
   
      return result;
   
   }

      public String toSolution(){ // code for showing the solution 
         
         String result = "";
      
      for(int i = 0 ; i < grid.length ; i++){
      
      for(int x = 0 ; x < grid[i].length ; x++){
      
      if(solution[i][x]){
         
         result += " " + grid[i][x] + " ";
      
      }else{
         
         result += " X ";
      
      }
   
   }
         
         result += "\r\n";
      }
         
       return result;
   }
   
       private void placeWord(char[][] wordChars, int iter){ // determines where to place the words on the grid 

          Random rand = new Random();
       
       int direction = rand.nextInt(3);
      
       int[] pos = {0,0};
       
       if(direction == 0){ // horizontal placement of words 
      
       boolean placed = false;
       
       int words = 0;
       
       while(!placed && words < 100){
            
          pos[0] = rand.nextInt((grid.length-1) - wordChars[iter].length);
          
          pos[1] = rand.nextInt((grid.length-1) - wordChars[iter].length);
          
          placed = true;
       
       for(int u = 0 ; u < wordChars[iter].length ; u++){
       
       if(grid[pos[0] + u][pos[1]] != '\u0000' && grid[pos[0] + u][pos[1]] != wordChars[iter][u]){

         placed = false;
       
       break;
      }
   }
         words++;
}
      if(placed){
      
      for(int x = 0 ; x < wordChars[iter].length ; x++){
         
         grid[pos[0]][pos[1]] = wordChars[iter][x];
         
         solution[pos[0]][pos[1]] = true;
         
      
         pos[0]++;
      
      }
   
   }
      
      }
      else if(direction == 2){ // diagonal placement of words 
      
      boolean placed = false;
      
      int words = 0;
      
      while(!placed && words < 100){
      
         pos[0] = rand.nextInt((grid.length-1) - wordChars[iter].length);
         
         pos[1] = rand.nextInt((grid.length-1) - wordChars[iter].length);
         
         placed = true;
      
      for(int u = 0 ; u < wordChars[iter].length ; u++){
      
      if(grid[pos[0] + u][pos[1] + u] != '\u0000' && grid[pos[0] + u][pos[1] + u] != wordChars[iter][u]){
         
         placed = false;
      
      break;
     
     }
   
   }
         words++;

}
      if(placed){
      
      for(int x = 0 ; x < wordChars[iter].length ; x++){
         
         grid[pos[0]][pos[1]] = wordChars[iter][x];
         
         solution[pos[0]][pos[1]] = true;
         
         pos[1]++;
         
         pos[0]++;
      
      }
   
   }

}
      
       else if(direction == 1){ // vertical placement of words
       
       boolean placed = false;
       
       int words = 0;
       
       while(!placed && words < 100){
          
          pos[0] = rand.nextInt((grid.length-1) - wordChars[iter].length);
          
          pos[1] = rand.nextInt((grid.length-1) - wordChars[iter].length);
          
          placed = true;
       
       for(int u = 0 ; u < wordChars[iter].length ; u++){
       
       if(grid[pos[0]][pos[1] + u] != '\u0000' && grid[pos[0]][pos[1] + u] != wordChars[iter][u]){
       
         placed = false;
       
       break;
      
      }
   
   }
        
         words++;
      
      }
      
       if(placed){
      
       for(int x = 0 ; x < wordChars[iter].length ; x++){
         
         grid[pos[0]][pos[1]] = wordChars[iter][x];
         
         solution[pos[0]][pos[1]] = true;
         
         pos[1]++;
      
      }
    
    }
  
  }

}

       private char[][] gridSetup(){ // determins the grid size

       char[][] wordChars = new char[words.length][];
      
       int longest = 8;
       
       for(int i = 0 ; i < words.length ; i++){
         
         wordChars[i] = words[i].toCharArray();
       
       if(wordChars[i].length > longest){
          
          longest = wordChars[i].length;
      
      }  
   
   }
    
       if(words.length > longest){
          
          longest = words.length;
      }

        this.grid = new char[longest + 5][longest + 5];

        this.solution = new boolean[longest + 5][longest + 5];
        
        return wordChars;
     
      }     

       private void fillGrid(){ // fills in the rest of the empty places so the solution isnt openly shown
       
       for(int i = 0 ; i < grid.length ; i++){

       for(int x = 0 ; x < grid[i].length ; x++){
          
          Random rand = new Random();

       if(grid[i][x] == '\u0000'){
          
          grid[i][x] = (char)(rand.nextInt(26)+97);
        
        }
     
      }
    
    }
  
  }

}