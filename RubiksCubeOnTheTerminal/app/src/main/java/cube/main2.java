package cube;
import java.util.Arrays;

public class main2 {

  public static void main(String[] args) {

      // ATTEMPT TO AUTOMATICALLY SET UP THE COLORS OF THE CUBE , FAILED
float sum = 0;
 float red=0;     float blue=0;
 float green=0;   float white=0;
 float yellow=0;  float orange=0;
float count= 0;
double change = 16;

  
    byte [][] UR = new byte[4][3];  
 byte [][]DR = new byte[4][3];  
 byte [][] RC = new byte[4][3];  
byte [][] LC = new byte[4][3];  
 byte [][] UP = new byte[4][3];  
 byte [][] DP = new byte[4][3];  
byte state[] = new byte[3];

byte count1 = 0;
    byte count2 = 0;
    byte count3 = 0;
    byte count4 = 0; 
    byte count5 = 0;
    byte count6 = 0;
    byte count7 = 0;
    byte count8 = 0;
    byte count9 = 0;
    byte count10 = 0;
    byte count11 = 0;
    byte count12 = 0;
    
float []range=new float[12];

   byte k = 0;
   double rand = 0; 
   
  //n is the number of slots 
   float n = 72;
   
   // r determines the increment for red,green e.t.c
   float r =(n/6)/Math.round(n/6);  
  
 
   
    for(int i = 0; i < n; i++){
      
      rand = Math.random() * 100;
      sum = 0;
      count= 0;
      
      if(red == n/6){
         range[0] = -1; range[1] = -1;  }
        
       
       if(green == n/6){
         range[2] = -1; range[3] = -1;  }
        

       if(yellow == n/6){
         range[4] = -1; range[5] = -1; }
       
        if(blue == n/6){
         range[6] = -1; range[7] = -1; }
         
       if(white == n/6){
         range[8] = -1; range[9] = -1; }
       
       if(orange == n/6){
         range[10] = -1; range[11] = -1;}
  
      

       
      for(int f = 0; f < range.length; f++ ){
           
            if(range[f] >= 0)
              count++;
              
         }
          
          count /= 2;
          change = 100/count;
          
           for(int j = 0; j < range.length; j++ ){
          
             if(range[j] < 0)
                continue; 
              
              else
                range[j]=sum;
                
              if(j%2==0)
              sum +=change;
           
              
         }
        
        
         
        
         
      
if((rand >= range[0] && rand <= range[1]) && red < n/6){
    k = 4;  red += r;}
    
     
if((rand > range[2] && rand <= range[3]) && green < n/6){
         k = 6;  green += r; }
   
         
   if((rand > range[4] && rand <= range[5]) && yellow < n/6){
         k = 2; yellow += r;
       }
       
    if((rand > range[6] && rand <= range[7]) && blue < n/6){
         k = 5; blue += r;
       }
       
  if((rand > range[8] && rand <= range[9]) && white < n/6){
         k = 1; white += r;
       }
      
     
       
  if((rand > range[10] && rand <= range[11]) && orange < n/6){
         k = 3; orange += r;
       }   
         
       
        
        
       if(i <= 11){
     
        
         UR[count1][count2] = k;
         
          
           if((i+1)%3 == 0)  
            count1++; 
          
          if(count2 == 2)
           count2 = 0;
           
          else
          count2++;  }
       
       
       
       
       
       
       
       
       
      if(i > 11 && i <= 23){
      
       
         DR[count3][count4] = k;
   
              
          if((i+1)%3 == 0)  
            count3++; 
          
          if(count4 == 2)
           count4 = 0;
           
          else
          count4++;
       }
       
       
       
       
       
       
       if(i > 23 && i <= 35){
        
       
          LC[count5][count6] = k;
         
       
               
            if((i+1)%3 == 0)  
            count5++; 
          
          if(count6 == 2)
           count6 = 0;
           
          else
          count6++;  }
          
          
          
          
       
       if(i > 35 && i <= 47){
       
       
          RC[count7][count8] = k;
         
             
       
            if((i+1)%3 == 0)  
            count7++; 
          
          if(count8 == 2)
           count8 = 0;
           
          else
          count8++; }
          
          
          
       
       if(i > 47 && i <= 59){
       
    UP[count9][count10] = k;
          
          if((i+1)%3 == 0)  
            count9++; 
          
          if(count10 == 2)
           count10 = 0;
           
          else
          count10++; }
          
          
          
          
       
      if(i > 59 && i <= 71){
      
       DP[count11][count12] = k;
      
          if((i+1)%3 == 0)  
            count11++; 
          
          if(count12 == 2) 
           count12 = 0;
           
          else
          count12++;  }
       
    
    
}
 System.out.println("UR="+Arrays.deepToString(UR) + " RED="+red);
   System.out.println("DR="+Arrays.deepToString(DR)+ " BLUE="+blue);
   System.out.println("RC="+Arrays.deepToString(RC)+ " White="+white);
   
   System.out.println("LC="+Arrays.deepToString(LC)+ " Green="+green );
   
 System.out.println("UP="+Arrays.deepToString(UP)+ " Orange="+orange);
 
   System.out.println("DP="+Arrays.deepToString(DP)+ " yellow="+yellow);  
   
 for(int j = 0; j < range.length; j++ ){
          
        
        
         System.out.println(range[j]);
             



}
}
}