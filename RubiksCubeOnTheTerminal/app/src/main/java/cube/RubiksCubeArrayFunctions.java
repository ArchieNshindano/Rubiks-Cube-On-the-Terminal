package cube;


import java.util.Arrays;
import java.util.Random;

public class RubiksCubeArrayFunctions {
    // 2D arrays representing the different faces of the cube


 byte[][] rotated;
 byte[][] original;
 int direction;
 int size;
 int index;
 byte statuses[][];
 byte states[][];
 byte status[];
 byte state[];



 public RubiksCubeArrayFunctions(int size){
    this.size = size;
   this.rotated = new byte[size][size];
   this.original = new byte[size][size];

   this.states = new byte[size][size];
   this.status = new byte[size];
   this.state = new byte[size];
 }

    public byte[][] rotation(byte[][] original, int direction) {
        int size = original.length;
        byte[][] rotated = new byte[size][size];

        if (direction == 1) {
            // Rotate clockwise
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    // Assign values from original matrix to rotated matrix
                    // Swap row and column indices for clockwise rotation
                    rotated[j][size - 1 - i] = original[i][j];
                }
            }
        } else {
            // Rotate counterclockwise
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    // Assign values from original matrix to rotated matrix
                    // Swap row and column indices for counterclockwise rotation
                    rotated[size - 1 - j][i] = original[i][j];
                }
            }
        }

        return rotated;
    }


    public byte[] reverse(byte state[]){
     this.status = new byte[size];

     int k = 0;
   
   for(int i =state.length; i >= 1; i--){
     
      status[k] = state[i-1];
       k++;  }
   
   return status;
 }
 
 
 public byte[][] shift(byte states[][],int direction){
 //1 shifts to the right 0 left
  int k = 0; 
  this.statuses = new byte[states.length][states[0].length];
  
  if(direction == 0)
     for(int i = 0; i < states.length; i++){
       
        if(k+1 == states.length )
          k = -1;
          
         statuses[i] = states[k+1];
         
         if(k == -1)
           k = 0;
           
          k++;  }
     
     else  {
        
        k = 0;
        
         for(int i = 0; i < states.length; i++){
       
        if(k-1 == -1)
          k = states.length;
          
         statuses[i] = states[k-1];
         
         if(k == states.length)
           k = 0;
           
          k++; }
     }
     
     
     return statuses;
        
   
 }
 
  public byte []getArrayValues(byte [][]states,int index){

     this.state = new byte[size];

  for(int i = 0; i<states.length; i++)
    state[i] = states[i][index];

  return state;
  
      }

  }
               
