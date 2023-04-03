/**
 * This class models a train which has a location and name
 */
class Train{
  private int location;
  private String name;

  public Train(String name) {
    this.name = name;
  }

  /**
   * @return the field name
   */
  public String getName() {
    return name;
  }

  public int getLocation(){
    return this.location;
  }

  public void setLocation(int location){
    this.location = location;
  }
}
