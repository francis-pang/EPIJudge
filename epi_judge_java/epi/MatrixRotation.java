package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class MatrixRotation {

  public static void rotateMatrix(List<List<Integer>> squareMatrix) {
    int midPoint = squareMatrix.size() / 2;
    for (int row = 0; row < midPoint; row++) {
      int boundaryRow = squareMatrix.size() - row - 1;
      int firstColumn = row;
      int lastColumn = boundaryRow;
      while (firstColumn < boundaryRow) {
        fourWaySwap(squareMatrix, row, firstColumn, boundaryRow, lastColumn);
        lastColumn--;
        firstColumn++;
      }
    }
    return;
  }

  private static void fourWaySwap(List<List<Integer>> squareMatrix, int coorindate1, int coorindate2, int coorindate3,
                                  int coorindate4) {
    int value1 = squareMatrix.get(coorindate1).get(coorindate2);
    int value2 = squareMatrix.get(coorindate2).get(coorindate3);
    int value3 = squareMatrix.get(coorindate3).get(coorindate4);
    int value4 = squareMatrix.get(coorindate4).get(coorindate1);

    squareMatrix.get(coorindate1).set(coorindate2, value4);
    squareMatrix.get(coorindate2).set(coorindate3, value1);
    squareMatrix.get(coorindate3).set(coorindate4, value2);
    squareMatrix.get(coorindate4).set(coorindate1, value3);
  }

  @EpiTest(testDataFile = "matrix_rotation.tsv")
  public static List<List<Integer>> rotateMatrixWrapper(List<List<Integer>> squareMatrix) {
    rotateMatrix(squareMatrix);
    return squareMatrix;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MatrixRotation.java",
                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
