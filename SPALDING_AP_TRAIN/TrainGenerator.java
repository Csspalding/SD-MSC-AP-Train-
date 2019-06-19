/**@author 2140148s Cassie Spalding AP Coursework March 2019
 * TrainGenerator infinitely creates new train thread objects 
 * MAX_TRAIN_THREADS is set as the maximum number which can be toggled line 27 with while(true) to 
 * generate infinite trains.
 */
import java.util.*;
import java.lang.*;

public class TrainGenerator implements Runnable { 
private Track ttt;
private Train chch;
private final LineDesignRoute line;
private final int MAX_TRAIN_THREADS = 50;
private Handler h;//handles each track's list of trains
public TrainGenerator(LineDesignRoute line){  
  this.line = line;
} 
/**
 * @Override
 */
public void run(){
  //random delay up to 2 seconds between making each new train
  Random r = new Random();
  int createRandomTime = r.nextInt(2000);
  int count = 0;
  //create new trains indefinitely, currently set to a MAX_TRAIN_THREADS number
  while(count < MAX_TRAIN_THREADS){//toggle while(true)
    try {
      //random time delay between each new train being made
      Thread.sleep(createRandomTime); 
    }catch(InterruptedException  e){
      //do nothing
    }
      //keep count of how many trains are made
      count++;
      //Flag to randomly switch between creating Slow type and Fast type trains
      Random zeroOrOne = new Random();
      int randomTrain = zeroOrOne.nextInt(2);
      if (randomTrain == 0) {
        chch = new SlowTrain();
      }else{
        chch = new FastTrain();
      }
      //set each new train a count 
      chch.setTrainNum(count);
      //set each train thread the count as a name
      Thread t = new Thread(chch, ""+count);
      t.start(); 
    }
  } 

/**
 * getTrain
 *@return Train
 */
  public Train getTrain(){
    return chch;
  }
}
  
 