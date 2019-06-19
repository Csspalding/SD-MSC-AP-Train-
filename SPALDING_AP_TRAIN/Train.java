/**AP Coursework @author Cassie Spalding 2140148s
 * Train class is abstract, implements Runnnable, DurationSettor
 * concrete classes that extend track run along the railway route: list of tracks
 * on each track the train calculates duration to sleep on each track 
 *
 */
import java.util.List;
import java.util.Random;
import java.util.Iterator;//dont need this
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.lang.*;

public abstract class Train implements Runnable, DurationSettor{
  private int tNum;
  private int speed;
  private int duration;//the duration a train with a certain speed travels a particular track length
  private String trainName;//used for testing may be useful in future (e.g. Express/ Maintainance/ Freight trains)
  private LineDesignRoute line = new LineDesignRoute();
  private Track currTrack = new Track();
  private String message;//for testing trainNum and trackName toString
  private boolean hasTrack = false;
   
  public Train(){
    this.tNum = getTrainNum();
    this.speed = getSpeed();
    this.trainName = getTrainName();
  }

  /**Trains travel tracks on the railway line's route
   * @Override
   */
  public void run(){
    LinkedList<Track> railList= new LinkedList<>();
    railList = line.getRailObjs();
    setCurrTrack(railList.getFirst());
    currTrack = getCurrTrack();
    hasTrack = true;//?
    //calculate duration with this train and firstTrack
    while (hasTrack){
    //train has a track so calculate the duration
      setDuration(currTrack);
      duration = getDuration();
//currently this message display shows trains are loading onto tracks
      this.message = "--" + currTrack.getName() +"--"+ this.getTrainNum() + "--||";
      //this.message = "--"+ this.getTrainNum() + "--"; //when updateDisplay works use this message in this.toString()
      System.out.print(message);//toggle with RunMe rlway.updateDisplay()
      try{ 
        Thread.sleep(duration);
        hasTrack = false; 
         if(line.hasNext(currTrack)){
         try{ 
           this.currTrack = line.getNext(currTrack);
           hasTrack = true;
           }catch (IndexOutOfBoundsException ofb) {
            hasTrack = false;
           }
          }
      }catch (InterruptedException e) {
       //do nothing
      }
     
    }
} 

/**setDuration
 * @Override
 * @para Track
 * calculate and set duration each train is on each track
 */
  public void setDuration(Track aTrack){
    this.currTrack = aTrack;
    int speed = this.getSpeed();
    int length = this.currTrack.getLength();
    //calculate duration and convert to milliseconds * 1000
    double result = (length / speed ) * 100; //to speed up program * 100
    duration = (int) Math.round(result);
  }

/**getDuration for the time this train is on this track
 * @Override
 * @return int
 */
  public int getDuration(){
     return  duration;
  }

 /**setCurrTrack  sets the track passed as the current track
  * @para Track
  */
  public void setCurrTrack(Track currTrack){
  this.currTrack = currTrack;
  }

  /**getCurrTrack
   * @return Track
   */
  public Track getCurrTrack(){
  return currTrack;
  }

   /**getTrainNum
   * @return int tNum the train number
   */
  public int getTrainNum(){
    return tNum;
  } 

  /**setTrainNum
   * @para int tNum the train number set
   */
  public void setTrainNum(int tNum){
    this.tNum =tNum;
  }
 
  /**getSpeed
   * @return int speed
   */
  public int getSpeed(){
    return speed;
  }

  /**setSpeed
   * @para int speed the speed to set 
   */
  public void setSpeed(int speed){
    this.speed =speed; 
  }

   /**getTrainName
   * @return String the train name
   * used to test what train type is travelling e.g Fast or Slow
   */
  public String getTrainName(){
  return this.trainName;
  }

  /**setTrainName
   * @para String name the name to set
   */
  public void setTrainName(String n){
  this.trainName =n;
  }

  /**ToString 
   * @return String to be printed for train in updateDisplay method
   */
   //When updateDisplay() is working uncomment message
  public String trainToString( ){ 
    // this.message = "--"+getTrainNum()+"--";
    return this.message;
  }

  /**setHasTrack
    * @para boolean hasTrack to be set for train
    */
  public void setHasTrack(boolean hasTrack){
    this.hasTrack = hasTrack;
  }

  /**getHasTrack 
   * @returns boolean hasTrack for train
   */
  public boolean getHasTrack(){// is this needed?
    return hasTrack;
  }

}