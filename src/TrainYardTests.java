import java.io.File;
import java.util.Arrays;

public class TrainYardTests {
  public static boolean test() {
    try {

      File test = new File("demoConnections.txt");
      TrainYard yard = new TrainYard(test);
      boolean[][] expectedConnections = new boolean[11][11];
      // Assigns connections to expectedConnections
      {
        expectedConnections[0][2] = true;

        expectedConnections[1][2] = true;

        expectedConnections[2][0] = true;
        expectedConnections[2][1] = true;
        expectedConnections[2][3] = true;
        expectedConnections[2][5] = true;

        expectedConnections[3][2] = true;

        expectedConnections[4][5] = true;

        expectedConnections[5][2] = true;
        expectedConnections[5][4] = true;
        expectedConnections[5][6] = true;
        expectedConnections[5][8] = true;

        expectedConnections[6][5] = true;

        expectedConnections[7][8] = true;

        expectedConnections[8][5] = true;
        expectedConnections[8][7] = true;
        expectedConnections[8][9] = true;
        expectedConnections[8][10] = true;

        expectedConnections[9][8] = true;
        expectedConnections[10][8] = true;
      }
      if (!Arrays.deepEquals(expectedConnections, yard.getConnectionMatrix())) {
        return false;
      }

      // Checking trains:

      Train[] expectedTrains = new Train[11];
      // Assigns expected trains
      {
        expectedTrains[1] = new Train("Green Apple");
        expectedTrains[1].setLocation(1);

        expectedTrains[2] = new Train("Train Blue");
        expectedTrains[2].setLocation(2);

        expectedTrains[3] = new Train("Red Train");
        expectedTrains[3].setLocation(3);

        expectedTrains[5] = new Train("Yellow Dude");
        expectedTrains[5].setLocation(5);

        expectedTrains[9] = new Train("banana");
        expectedTrains[9].setLocation(9);
      }

      Train[] actualTrains = yard.getLocations();
      if (actualTrains.length != 11) {
        return false;
      }
      // For loop to check for trains
      for (int k = 0; k < expectedTrains.length; k++) {

        Train expectedTrain = expectedTrains[k];
        Train actualTrain = actualTrains[k];

        // If the expected train is null and actual train is not, return false
        if (expectedTrain == null && actualTrain != null) {
          return false;
        }
        // continue if the expectedTrain is null
        if (expectedTrain == null) {
          continue;
        }
        // Check if the actual trains location and expected trains location are the same
        if (actualTrain.getLocation() != expectedTrain.getLocation()) {
          return false;
        }
        // Check if the actual train's name and expected trains name are not the same
        if (!actualTrain.getName().equals(expectedTrain.getName())) {
          return false;
        }
      }
    } catch (Exception e) {
      // Some unexpected exception
      e.printStackTrace();
      System.err.println(
          "Some Unexpected Exception was thrown: \n" + e.getClass().getSimpleName() + ": " +
              e.getMessage());
      return false;
    }
    // All test cases passed
    return true;
  }

  /**
   * The main method
   *
   * @param args Unused Parameters
   */
  public static void main(String[] args) {
    System.out.println("Testing train....");
    System.out.println((test()) ? "\u001B[1;32mAll tests passed!\u001B[0m" :
        "\u001B[1;31mSomething went wrong :(\u001B[0m");
  }
}
