/**AP Coursework March 2019 @author Cassie Spalding 2140148s
 * Track super class  - both Station and Track Segment extend this class
 * This class can be built into a railway route, it is concrete MinTrack segment: 100 meters in length, capasity 1 train
 */
import java.util.List;
import java.util.LinkedList;

public class Track{
   
private final int HUNDRED = 100; 
private final int ONE = 1; 
private String name;
private int length;
private int cap;
private Train train;
private LinkedList<Train> listOfTrains=new LinkedList<Train>();
private boolean isRoom; 
 
public Track(){
  this.setName();
  this.setLength(HUNDRED);
  this.setCapasity(ONE);
}

/**getIsRoom
 * @return the isRoom
 */
public boolean getIsRoom() {
	return isRoom;
}

/**isRoom
 * @param isRoom the isRoom to set
 */
public void setIsRoom(boolean isRoom) {
	this.isRoom = isRoom;
}

/**getLength
 * @return int length
 */
public int getLength(){
    return length;
}

/**setLength
 * @para l is the length to set
 */
public void setLength(int l){
    this.length = l; //100 meters
}

/**getName
 * @return name
 */
public String getName(){
  return name;
}

/**setName
 * void setName
 */
public void setName(){
  this.name = "MinTrack"; 
}

/**getCapasity
 * @return final ONE 
 */
public int getCapasity(){
    return cap;
}

/**setCapasity
 * @para c is the cap to set
 */
public void setCapasity(int c){
   this.cap = c; 
 }
  
/**getListOfTrains
 * @return LinkedList <Train> listOfTrains
 */
public LinkedList<Train> getListOfTrains(){
return listOfTrains;
}

/**toString
 * @Override 
 * @return displayName
 */
public String toString() {
  name = "--"+getName()+"--";
  return name;  
 }

}
