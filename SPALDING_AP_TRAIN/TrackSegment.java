/**
 * AP Coursework @author Cassie Spalding 2140148s
 * Track Segment extends Track 
 */
 public class TrackSegment extends Track{
  private final int THOUSAND = 1000; //meters
  private final int length = THOUSAND;
  private String nm;
 
public TrackSegment(){
  this.setName();
  this.setLength(THOUSAND);
  super.getCapasity();
}
/**
 * @Override
 * set the name to "track"
 */
public void setName(){
  this.nm = "track";
}
/**@Override
 * @return String name
 */
public String getName(){
    return this.nm = nm;
}

}