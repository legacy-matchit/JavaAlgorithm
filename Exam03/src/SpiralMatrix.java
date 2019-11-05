import java.util.Arrays;

public class SpiralMatrix {
    private int[][] mat;
    /** Skapar en spiralmatris av storlek size x size */
    public SpiralMatrix(int size) { //OBS: Ingick inte i uppgiften
        mat = new int[size][size];
        int sideLength = size;
        int startValue = 0;
        for (int startPosition = 0; startPosition < (size+1)/2; startPosition++) {
            fillBorder(startValue,sideLength,startPosition);
            startValue += (sideLength-1)*4;
            sideLength -= 2;
        }

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] + 1 + "   :   ");
            }
            System.out.println();
        }
    }
    /** Fyller yttervarvet i delspiralmatrisen av storlek sideLen x sideLen
     med startvärdet startValue i position [startPosition][startPosition] */
    private void fillBorder(int startValue, int sideLen, int startPosition) { //5p
        int value = startValue;
        for (int step = 0; step < sideLen; step++) {
            mat[startPosition][startPosition+step] = value;
            value++;
        }
        for (int step = 1; step < sideLen; step++) {
            mat[startPosition+step][startPosition+sideLen-1] = value;
            value++;
        }
        for (int step = 1; step < sideLen; step++) {
            mat[startPosition+sideLen-1][startPosition+sideLen-1-step] = value;
            value++;
        }
        for (int step = 1; step < sideLen-1; step++) {
            mat[startPosition+sideLen-1-step][startPosition] = value;
            value++;
        }
    }
}
