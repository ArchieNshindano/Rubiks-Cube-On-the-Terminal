package cube;


public class RubiksCubeTriggerFunctions {

 
 public byte [][][] faces;
 
/* 0 is the front, 1 right, 2 back,3 left, 4 up, 5 down */

 int size;
public  byte [][] temp0;
    public  byte [][]temp1;
    public  byte [][]temp2;
    public  byte [][]temp3;
    public  byte [][]temp4;
    public  byte [][]temp5;
    public  byte [][]temp6;
 int direction;
 public int midPart;
 RubiksCubeArrayFunctions cube;
 byte status[];
 byte stasuses[][];
    private byte[][] temp7;

    public RubiksCubeTriggerFunctions(int size){

   this.size = size;
   cube = new RubiksCubeArrayFunctions(size);
   
   this.faces = new byte[6][size][size];

    temp1 = new byte[4][size];
    status = new byte[size];
    stasuses = new byte[4][size];
    setColours();
}
    // setArrayValues takes an array and it's values and assigns them to the specified positions on the cube index+face, one array row at a time
    // getArrayValues gets the desired array row from a particular face with the desired index
    public void frontTrigger(int direction) {

         setTemps();

        this.faces[0] = cube.rotation(faces[0], direction); // Rotate the front face in the specified direction
        this.temp0 = cube.shift(temp0, direction); // Shift the values in the temporary array in the specified direction

        if (direction == 1) {
            // Reverse the order of elements in temp[2] and temp[0]
            this.temp0[0] = cube.reverse(temp0[0]);
            this.temp0[2] = cube.reverse(temp0[2]);
        }

        else {
            // Reverse the order of elements in temp[1] and temp[3]
            this.temp0[1] = cube.reverse(temp0[1]);
            this.temp0[3] = cube.reverse(temp0[3]);
        }

        this.faces[4][size - 1] = temp0[0]; // Assign the values from temp[0] to the topFace+lastIndex face
        setArrayValues(temp0[1], 1, 0); // Assign the values from temp[1] to the left face
        this.faces[5][0] = temp0[2]; // Assign the values from temp[2] to the top face
        setArrayValues(temp0[3], 3, size - 1); // Assign the values from temp[3] to the right face
    }

    public void rightTrigger(int direction) {

         setTemps();

        this.faces[1] = cube.rotation(faces[1], direction); // Rotate the right face in the specified direction
        this.temp1 = cube.shift(temp1, direction); // Shift the values in the temporary array in the specified direction

        if (direction == 1) {
            // Reverse the order of elements in temp1[2] and temp1[0]
            this.temp1[0] = cube.reverse(temp1[0]);
            this.temp1[2] = cube.reverse(temp1[2]);
        }

        else {
            // Reverse the order of elements temp1[1] and temp1[3]
            this.temp1[1] = cube.reverse(temp1[1]);
            this.temp1[3] = cube.reverse(temp1[3]);
        }

        setArrayValues(cube.reverse(temp1[0]), 4, size-1);
        setArrayValues(temp1[1], 2, 0);
        setArrayValues(temp1[2], 5, size-1);
        setArrayValues(temp1[3], 0, size-1);
 }

    public void backTrigger(int direction) {

        setTemps();

        this.faces[2] = cube.rotation(faces[2], direction);
        this.temp2 = cube.shift(temp2, direction);

        if (direction == 1) {
            // Reverse the order of elements in temp[2] and temp[0]
            this.temp2[0] = cube.reverse(temp2[0]);
            this.temp2[2] = cube.reverse(temp2[2]);
        }

        else {
            // Reverse the order of elements in temp[1] and temp[3]
            this.temp2[1] = cube.reverse(temp2[1]);
            this.temp2[3] = cube.reverse(temp2[3]);
        }

        this.faces[4][0] = cube.reverse(temp2[0]);
        setArrayValues(temp2[1], 3, 0);
        this.faces[5][size-1] = cube.reverse(temp2[2]);
        setArrayValues(temp2[3], 1, size - 1);
    }

    public void leftTrigger(int direction) {

        setTemps();

        this.faces[3] = cube.rotation(faces[3], direction);
        this.temp3 = cube.shift(temp3, direction);

        if (direction == 1) {

            this.temp3[0] = cube.reverse(temp3[0]);
            this.temp3[2] = cube.reverse(temp3[2]);
        }

        else {

            this.temp3[1] = cube.reverse(temp3[1]);
            this.temp3[3] = cube.reverse(temp3[3]);
        }

        setArrayValues(temp3[0], 4, 0);
        setArrayValues(temp3[1], 0, 0);
        setArrayValues(cube.reverse(temp3[2]), 5, 0);
        setArrayValues(temp3[3], 2, size-1);
    }

    public void topTrigger(int direction) {

        setTemps();

        int get = direction;

        if (direction == 1)
            get = 0;

        else
            get = 1;

        this.faces[4] = cube.rotation(faces[4], direction);
        this.temp4 = cube.shift(temp4,get );

        faces[0][0] = temp4[0];
        faces[1][0] = temp4[1];
        faces[2][0] = temp4[2];
        faces[3][0] = temp4[3];
    }

    public void bottomTrigger(int direction) {

         setTemps();

        this.faces[5] = cube.rotation(faces[5], direction);
        this.temp5 = cube.shift(temp5,direction );

        faces[0][size-1] = temp5[0];
        faces[1][size-1] = temp5[1];
        faces[2][size-1] = temp5[2];
        faces[3][size-1] = temp5[3];
    }

    public void middleTriggerVertical(int direction,int midPart) {

        setMid(midPart);


        this.temp6 = cube.shift(temp6, direction); // Shift the values in the temporary array in the specified direction

        if (direction == 1) {
            // Reverse the order of elements in temp1[2] and temp1[0]
            this.temp6[0] = cube.reverse(temp6[0]);
            this.temp6[2] = cube.reverse(temp6[2]);
        }

        else {
            // Reverse the order of elements temp1[1] and temp1[3]
            this.temp6[1] = cube.reverse(temp6[1]);
            this.temp6[3] = cube.reverse(temp6[3]);
        }

        setArrayValues(cube.reverse(temp6[0]), 4, midPart);
        setArrayValues(temp6[1], 2, midPart);
        setArrayValues(temp6[2], 5, midPart);
        setArrayValues(temp6[3], 0, midPart);
    }

    public void middleTriggerHorizontal(int direction,int midPart) {

        setMid(midPart);


        this.temp6 = cube.shift(temp6, direction); // Shift the values in the temporary array in the specified direction

        if (direction == 1) {
            // Reverse the order of elements in temp1[2] and temp1[0]
            this.temp6[0] = cube.reverse(temp6[0]);
            this.temp6[2] = cube.reverse(temp6[2]);
        }

        else {
            // Reverse the order of elements temp1[1] and temp1[3]
            this.temp6[1] = cube.reverse(temp6[1]);
            this.temp6[3] = cube.reverse(temp6[3]);
        }

        setArrayValues(cube.reverse(temp6[0]), 4, midPart);
        setArrayValues(temp6[1], 2, midPart);
        setArrayValues(temp6[2], 5, midPart);
        setArrayValues(temp6[3], 0, midPart);
    }

    public void setColours() {

     /*
      face0 = front face center 2
      face1 = right face center 6
      face2 = back face center 1
      face3 = left face center 5
      face4 = top face center 3
      face5 = bottom face center 4

      1  = white
      2 = yellow
      3 = Orange
      4 = Red
      5 = Blue
      6 = Green
      */
        byte[][][] facez = {
                {{4, 1, 6}, {6, 2, 5}, {3, 4, 6}},
                {{2, 2, 5}, {3, 6, 6}, {1, 5, 3}},
                {{2, 6, 6}, {2, 1, 2}, {5, 2, 2}},
                {{1, 1, 1}, {3, 5, 3}, {4, 1, 2}},
                {{3, 4, 3}, {4, 3, 4}, {5, 6, 4}},
                {{6, 5, 4}, {3, 4, 1}, {5, 5, 1}}
        };

        this.faces = facez; // Assign the predefined colors to the faces array

    }

    public void setMid(int midPart){

     if (size == 3)
         midPart = 1;

        this.temp6 = new byte[size][size];
        this.temp7 = new byte[size][size];

    byte[][] tempz6 = {

            cube.reverse(cube.getArrayValues(faces[4],midPart)),
            cube.getArrayValues(faces[2],midPart),
            cube.getArrayValues(faces[5],midPart),
            cube.getArrayValues(faces[0],midPart)
    };


        byte[][] tempz7 = {

                cube.getArrayValues(faces[0],midPart),
                cube.getArrayValues(faces[1],midPart),
                cube.getArrayValues(faces[2],midPart),
                cube.getArrayValues(faces[3],midPart)
        };

     this.temp6 = tempz6;
    }
    public void setTemps(){


     //asigns values to the temp arrays
        // Each temp n is for face n
        // temps store the colours on the four corners of a face starting from the top clockwise

           this.temp0 = new byte[size][size];
           this.temp1 = new byte[size][size];
           this.temp2 = new byte[size][size];
           this.temp3 = new byte[size][size];
           this.temp4 = new byte[size][size];
           this.temp5 = new byte[size][size];


        //tempz stores the arrays on the corners of each face
        byte[][] tempz0 = {

                faces[4][size - 1],
                cube.getArrayValues(faces[1], 0),
                faces[5][0],
                cube.getArrayValues(faces[3], size - 1)
        };

        byte[][] tempz1 = {

                cube.reverse(cube.getArrayValues(faces[4], size - 1)),
                cube.getArrayValues(faces[2], 0),
                cube.getArrayValues(faces[5], size - 1),
                cube.getArrayValues(faces[0], size - 1)
        };

        byte[][] tempz2 = {

                cube.reverse(faces[4][0]),
                cube.getArrayValues(faces[3], 0),
                cube.reverse(faces[5][size - 1]),
                cube.getArrayValues(faces[1], size - 1)
        };

        byte[][] tempz3 = {

                cube.getArrayValues(faces[4], 0),
                cube.getArrayValues(faces[0], 0),
                cube.reverse(cube.getArrayValues(faces[5], 0)),
                cube.getArrayValues(faces[2], size - 1)
        };

        byte[][] tempz4 = {

                faces[0][0],
                faces[1][0],
                faces[2][0],
                faces[3][0]
        };

        byte[][] tempz5 = {

                faces[0][size-1],
                faces[1][size-1],
                faces[2][size-1],
                faces[3][size-1]
        };



        this.temp0 = tempz0;
        this.temp1 = tempz1;
        this.temp2 = tempz2;
        this.temp3 = tempz3;
        this.temp4 = tempz4;
        this.temp5 = tempz5;

    }


    public void setArrayValues(byte[] status, int face, int index) {
        for (int i = 0; i < size; i++) {
            faces[face][i][index] = status[i]; // Assign the values from the status array to the specified face and index
        }
    }

}