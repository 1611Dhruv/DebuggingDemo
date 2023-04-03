// Preface of the problem:
// We are given a file with data about trains and locations in the train yard
// Our task is to load those trains onto the train yard, and assign the connections matrix
// File is of the following format:

// (num Trains)
// loc1 | (con1) (con2) ... (Train name if present)

// Our job is to assign the connection matrix and fill the locations variable with train objects


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class models a TrainYard which may help increase understanding about the debugger
 */
public class TrainYard {

  private boolean[][] connectionMatrix;

  private Train[] locations;

  /**
   * @return the field connectionMatrix
   */
  public boolean[][] getConnectionMatrix() {
    return connectionMatrix;
  }

  /**
   * @return the field locations
   */
  public Train[] getLocations() {
    return locations;
  }

  public TrainYard(File connectionFile) {
    int numLocations = 0;
    try (Scanner sc = new Scanner(connectionFile)) {
      numLocations = sc.nextInt();
    } catch (FileNotFoundException e) {
      System.out.println("\u001B[1;31mCan't load the file, no connections made\u001B[0m");
    }
    locations = new Train[numLocations];
    connectionMatrix = new boolean[numLocations][numLocations];
    fillConnectionsAndLocations(connectionMatrix, connectionFile, locations);
    // fillAtRandom(locations);
  }

  private static void fillConnectionsAndLocations(boolean[][] connectionMatrix, File connection,
      Train[] locations) {
    try (Scanner sc = new Scanner(connection)) {
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        Scanner lineScanner = new Scanner(line);
        int row = lineScanner.nextInt();
        // ignore the |
        lineScanner.next();
        while (lineScanner.hasNextInt()) {
          connectionMatrix[row][lineScanner.nextInt()] = true;
        }
        if (lineScanner.hasNext()) {
          locations[row] = new Train(lineScanner.next());
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("\u001B[1;31mCan't load the file, no connections made\u001B[0m");
    }
  }

}


