/**
 * AP Coursework
 * @author Cassie Spalding 2140148s March 2019
 * Fast Train class extends Train is runnable
 */
import java.util.*;

public class FastTrain  extends Train{
  
  private final int FAST_SPEED = 500;
  private final String TRAIN_NAME= "Fast Train";

  public FastTrain(){
    super();
    this.setSpeed(FAST_SPEED);
    this.setTrainName(TRAIN_NAME);
  }
 

}
 