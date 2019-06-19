/**AP Coursework @author Cassie Spalding 2140148s March 2019
 * LineDesignRoute is the design of the railway route
 * Creates the railway line from different track objects as a linked list
 * Flexible for adding in/ removing track or station objects
 * Flexible for adding a return journey
 */

import java.util.List;
import java.util.LinkedList;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;

public class LineDesignRoute{
private boolean hasNextTrack;
private Track nextTrk;
//private Track prevTrk;//only required to build a return journey
private Track currTrk;
private TrackSegment t, t2, t3;
private Station s, s2, s3, s4;
private LinkedList<Track> railObjs;

public LineDesignRoute(){
  railObjs = createRailwayLine();
}

/**createRailwayLine
 * @return LinkedList<Track> of railObjs which is the railway line route
 * make up of a list of track objects
 */
 public LinkedList<Track> createRailwayLine(){
  LinkedList<Track> railObjs  = new LinkedList<Track>();
      this.t = new TrackSegment();
      this.t2 = new TrackSegment();
      this.t3 = new TrackSegment();
      this.s = new Station("Glasgow",3);
      this.s2 = new Station("Stirling",2);
      this.s3 = new Station("Perth",2);
      this.s4 = new Station("Inverness",2);
      railObjs.addFirst(s);
      railObjs.add(t);
      railObjs.add(s2);
      railObjs.add(t2);
      railObjs.add(s3);
      railObjs.add(t3);
      railObjs.add(s4);
        
      return railObjs;
 }

/**setNext is not called in this program but maybe useful in designing future routes
 * @para Track
 */
// public void setNext(Track trk)  { 
//   this.currTrk = trk;
//   int index = railObjs.indexOf(currTrk);
//   try {
//       if (railObjs.get(index+1) != null){
//       nextTrk = railObjs.get(index+1);
//       }
//     } catch (IndexOutOfBoundsException e) {
//       //do nothing  
//     }
// }

/**getNext
 * @para Track
 * @return Track
 */ 
  public Track getNext(Track currTrk){
      getRailObjs();
      this.currTrk = currTrk;
      int index = railObjs.indexOf(currTrk);
      try {
            if (railObjs.get(index+1) != null){
            nextTrk = railObjs.get(index+1);
            }
          } catch (IndexOutOfBoundsException e) {
             
          }
      return nextTrk;
 }

/**getFirst 
 * @return Track
 */
  public Track getFirst(){
      Track firstTrk = railObjs.getFirst();
      return firstTrk;
 }

/**getRailObjs
 * @return LinkedList<Track>
 */
  public LinkedList<Track> getRailObjs(){
       return railObjs;
 }

 /**hasNext
 * @return boolean if track linkedlist has next track
 * @para Track
 */   
public boolean hasNext(Track currTrk){
    getRailObjs();
    this.currTrk = currTrk;
    int size =  railObjs.size() -1;
    int index = this.railObjs.indexOf(this.currTrk);
    //we have a current track so the list is not empty
    
    if( index < size){
    return hasNextTrack = true;
     }
     return hasNextTrack = false;
 } 
    
}



