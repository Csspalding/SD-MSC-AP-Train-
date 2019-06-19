/**AP Courswork @author Cassie Spalding 2140148s March 2019
 * Slow Train class extends Train is runnable
 */
import java.util.*;

public class SlowTrain  extends Train{
 private final int SLOW_SPEED = 10;
 private final String TRAIN_NAME = "Slow train";

 public SlowTrain(){
   super();
   this.setSpeed(SLOW_SPEED);
   this.setTrainName(TRAIN_NAME);
   
 }

}