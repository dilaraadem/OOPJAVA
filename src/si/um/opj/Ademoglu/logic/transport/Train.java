package si.um.opj.Ademoglu.logic.transport;
import java.io.Serializable;
import java.util.Arrays;

/**@author Dilara
 * @version 2
*/

public abstract class Train implements Serializable{

	private String name;
	private int averageSpeed;
	
	public Train() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * constructs the train object
	 *
	 * @param name - get the name
	 */
	public Train(String name) {
		this.name = name;
	}
	/**
	 * constructs the train object with parameters
	 * 
	 * @param name - get the name
	 * @param averageSpeed - get the average speed
	 */
	public Train(String name, int averageSpeed) {
		this(name);
		this.averageSpeed=averageSpeed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAverageSpeed() {
		return averageSpeed;
	}
	public void setAverageSpeed(int averageSpeed) {
		this.averageSpeed = averageSpeed;
	}
	@Override
	public String toString() {
		return "Train [name=" + name + ", averageSpeed=" + averageSpeed + "]";
	}
	public abstract double getOccupancy(); //add abstract method, implement it in subclasses
}
