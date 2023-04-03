// Preface of the problem:
// We are given a file with information about a train yard. It has numbered stations, how those
// stations are connected, and where the trains are at a given moment
// Our job is to load that information into the TrainYard class's connectionMatrix and locations
// attributes
// File is of the following format:

// (num Trains)
// loc1 | (con1) (con2) ... (Train name if present)
// loc2 | (con1) (con2) ... (Train name if present)
// loc3 | (con1) (con2) ... (Train name if present)
// ...

// Our job is to assign the connection matrix and fill the locations variable with train objects


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class models a TrainYard which may help increase understanding about the debugger
 */
public class TrainYard {

  private boolean[][] connectionMatrix;
  // connections[1][2] = true implies that station 1 is connected to station 2
  private Train[] locations;

  /**
   * The constructor which takes a file object storing the information as a parameter
   * @param connectionFile the file
   */
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
  }

  /**
   * A helper method which will help fill the connectionMatrix, and the locations based on a
   * given file.
   * @param connectionMatrix the connection matrix
   * @param connection the file storing information about the connections
   * @param locations the locations
   */
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


}


