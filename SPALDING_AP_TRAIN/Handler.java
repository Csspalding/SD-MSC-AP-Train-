/**AP Coursework @author Cassie Spalding 2140148s March 2019
 * Handler implements Capasity checkCapasity method has addTrain and removeTrain methods 
 * handles tracks and trains
 * ReentrantLock lockTrack 
 * Condition trackHasRmCondition 
 */

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.List;
import java.util.LinkedList;
import java.lang.NullPointerException;
import java.lang.InterruptedException;

public class Handler implements Capasity {
  private Track track;
  private final Train train;
  private ReentrantLock lockTrack = new ReentrantLock(); 
  private Condition trackHasRmCondition = lockTrack.newCondition(); 
  private LinkedList<Train> trainList=new LinkedList<Train>();
  private boolean isRoom;
 
public Handler(Track track,Train train){
  this.train = train;
  this.track = track;
}
/**
 * Override
 * @para Track, Train 
 * @return boolean isRoom
 */
  public boolean checkCapasity(Track track, Train train){
    this.track = track;
    int cap = this.track.getCapasity();
    //get the list of trains for this track
    trainList = this.track.getListOfTrains();
    int size = trainList.size();
    if (size == cap){
      isRoom = false; 
      //otherwise add this train to the list
    }else{ 
      this.isRoom = true;
    }
      return isRoom;
  }
/**addTrain method
 * called by RailwayLine to add trains to each track's ListOfTrains 
 * @para Train
 */
  public void addTrain(Train train){
  lockTrack.lock();
  isRoom = checkCapasity(track, train);//returns TRUE if there isRoom
  try{
    while (!isRoom){
      try {
          trackHasRmCondition.await();
      }catch(InterruptedException e){
      //do nothing
      }
    }
    trainList = track.getListOfTrains();
    trainList.add(train);
    trackHasRmCondition.signalAll(); 
    lockTrack.unlock();            
    }catch (NullPointerException n) {
    //do nothing
    } 
  }
  /**removeTrain method
 * called by RailwayLine, removes trains from track's ListOfTrains
 * @para Train 
 */
public void removeTrain(Train train){ 
  lockTrack.lock();
   if (!trainList.isEmpty()){ 
  //remove the train from the list
  track = this.train.getCurrTrack();
  int index = this.trainList.indexOf(this.train);
  this.trainList.remove(index); }
  lockTrack.unlock();
	} 
}
