/** @author Cassie Spalding 2140148s  AP Coursework March 2019
 * RailwayLine is the train World
 * Gets trains from TrainGenerator
 * add /remove trains from track lists
 * when trains are removed they are directed to the next track
 * Implements Runnable and Display
 */
import java.util.List;
import java.util.Random;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.lang.*;




public class RailwayLine implements Runnable, Display{
  private Track track;
  private Train train;
  private final LineDesignRoute line;
  private TrainGenerator generator;
  private Handler add;
  private final int ZERO = 0; 
  public RailwayLine(LineDesignRoute line, TrainGenerator generator, Handler add){
    this.line = line;
    this.generator = generator;
    this.add = add;
  } 
  /** 
  *@Override
  *This method creates a train generator, and a railway line route 
  *adds and removes trains on track lists, calls updateDisplay method
  */
  public void run(){ 
    LinkedList<Track> railList= new LinkedList<>();
    List<Train> trainList= new LinkedList<>();
    generator = new TrainGenerator(line);
    railList = line.getRailObjs();
    track= line.getFirst();
    while(true){
//not currently getting the train threads to link in here!
      try{
        this.train = generator.getTrain();
        //This next line may be the problem with the updateDisplay method not printing
        add = new Handler(this.track, this.train);
          while(this.track.getIsRoom()){
          //for each track add train to run for it's duration, then remove it
          ListIterator trackIterator = railList.listIterator();
          while(trackIterator.hasNext()){ 
            add.addTrain(this.train);
            updateDisplay();
            try{
              Thread.sleep (100);
            }catch(InterruptedException e){}
            //remove train 
            trainList = this.track.getListOfTrains(); 
            while(trainList.size() < 0){
              add.removeTrain(this.train);//removes train from list
            }
          }
        }
      }catch(NullPointerException npe){
        //do nothing
      }
  }
      
}   
  /** 
  *@Override
  * updateDisplay
  */
   public void updateDisplay(){
    LinkedList<Train> tList= new LinkedList<>();
    LinkedList<Track> railL= new LinkedList<>();
    //get the railway route
    railL = line.getRailObjs();
    
    //print display with clear format
    String open = "[";
    String close= "]\n";
    System.out.println("");
    System.out.print(open);
    //print each track in display
    ListIterator trackIterator = railL.listIterator();
    while(trackIterator.hasNext()){ 
      System.out.print(trackIterator.next().toString()); 
      //for each track, print list of trains on each track
      if((!tList.isEmpty()) && tList.size() > ZERO){
      tList = track.getListOfTrains();
      ListIterator trainIterator = tList.listIterator();
      while(trainIterator.hasNext()){ 
        System.out.print(trainIterator.next().toString()); 
     }
    }
      System.out.print ("||");//for each track print || at the end
    }
   System.out.print(close);
  }
 
  
} 