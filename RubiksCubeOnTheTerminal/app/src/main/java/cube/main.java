package cube;

import java.util.Arrays;


public class main {

  public static void main(String[] args) {

    RubiksCubeTriggerFunctions triggerFunctions = new RubiksCubeTriggerFunctions(3);
    RubiksCubeArrayFunctions arrayFunctions = new RubiksCubeArrayFunctions(3);

    triggerFunctions.setColours();

      triggerFunctions.frontTrigger(1);
      triggerFunctions.rightTrigger(1);
      triggerFunctions.backTrigger(1);
      triggerFunctions.leftTrigger(1);
      triggerFunctions.topTrigger(1);
      triggerFunctions.bottomTrigger(1);




    System.out.println("temp0: " + Arrays.deepToString(triggerFunctions.temp0));
      System.out.println("temp1: " + Arrays.deepToString(triggerFunctions.temp1));
      System.out.println("temp2: " + Arrays.deepToString(triggerFunctions.temp2));
      System.out.println("temp3: " + Arrays.deepToString(triggerFunctions.temp3));
      System.out.println("temp4: " + Arrays.deepToString(triggerFunctions.temp4));
      System.out.println("temp5: " + Arrays.deepToString(triggerFunctions.temp5));
    for(int i= 0; i < 6; i++) {

      System.out.println("Face "+i+":"+ Arrays.deepToString(triggerFunctions.faces[i]));

    }


  }
}