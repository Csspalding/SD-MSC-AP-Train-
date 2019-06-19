/**
 * @author Cassie Spalding 2140148s  AP Coursework March 2019
 * RunMe is the Main class that runs the Train Simulator Railway program
 * 
 */

import java.util.*;

public class RunMe{

  public static void main(String[] args) {
   Train train= new SlowTrain();
   Track track= new Track();
   LineDesignRoute route= new LineDesignRoute();
   TrainGenerator generator = new TrainGenerator(route);
   Handler add = new Handler(track, train);
   RailwayLine rWay = new RailwayLine(route, generator, add);
   
   Thread t = new Thread (generator);
   t.start();
   Thread r = new Thread(rWay);
   r.start();
   
   //start the display
     while (true) {
   //This updateDisplay method isn't currently locating trains in track trainLists (ran out of time to sort this!)  
   //instead when you RunMe the Train class prints out track's name and train's number
   //The program does demonstrate trains passing each other on tracks.

      rWay.updateDisplay();//toggle with System.out.print (message) in Train class
        try {
          Thread.sleep(500);
       } catch (InterruptedException e) {
     
       }
     }
  }

   
}