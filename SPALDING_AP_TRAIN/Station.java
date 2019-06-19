/** @author Cassie Spalding 2140148s  AP Coursework March 2019
 *  Station class extends Track is Runnable
*/
public class Station extends Track{
  private final int THOUSAND = 1000; //meters
  private  int capasity; 
  private String name;
  
public Station(String n, int c){
  super();
  super.getLength();
  this.setName(n);
  this.setCapasity(c);
}
/**
 * @Override
 * @para String name
 */
public void setName (String n){
 this.name = n; 
}

/**@Override
 * @return name
 */
public String getName(){
  return this.name;
 }
}
