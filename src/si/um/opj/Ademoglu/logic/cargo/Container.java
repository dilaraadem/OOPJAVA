package si.um.opj.Ademoglu.logic.cargo;
import java.io.Serializable;
import java.util.Arrays;
/** @author Dilara
 * @version 2
*/
public class Container implements Serializable{
	private int label;
	private int maxWeight;
	private int maxNumberOfItems;
	private Portable[] arrayOfItems;
	public Container(){
	}
	/**
	 * constructs the container with the parameters
	 * 
	 * @param label - label of the container
	 * @param maxNumberOfItems - maximum number of items it can carry
	 */
	public Container(int label, int maxNumberOfItems){
		this.label=label;
		this.maxNumberOfItems=maxNumberOfItems;
		this.arrayOfItems = new Portable[maxNumberOfItems];
	}
	/**
	 * constructs the container with the parameters
	 * 
	 * @param label - label of the container
	 * @param maxWeight - maximum weight it can carry
	 * @param maxNumberOfItems - maximum number of items it can carry
	 */
	public Container(int label, int maxWeight, int maxNumberOfItems){
		this(label, maxNumberOfItems);
		this.maxWeight=maxWeight;
	}
	/**
	 * adds item to the array
	 *
	 * @param item - take the item to be added as parameter
	 */
	public void addItem(Portable item){
		for(int i=0;i<maxNumberOfItems;i++)
		{
			if(this.arrayOfItems[i]==null)
			{
				this.arrayOfItems[i]=item;
				break;
			}
		}
	}
	
	public void editItem(Portable item) {
		for(int i=0;i<maxNumberOfItems;i++) {
			if(this.arrayOfItems[i]!=null && this.arrayOfItems[i].returnNameOfTheItem().equals(item.returnNameOfTheItem())) {
				this.arrayOfItems[i]=null;
				this.arrayOfItems[i]=item;
				break;
			}
		}
	}
	
	public Portable[] getArrayOfItems() {
		return arrayOfItems;
	}
	public void setArrayOfItems(Portable[] arrayOfItems) {
		this.arrayOfItems = arrayOfItems;
	}
	/**
	 * removes item from the array
	 *
	 * @param item - take the item to be removed as parameter
	 */
	public void removeItem(Portable item){
		for(int i=0;i<maxNumberOfItems;i++)
		{
			if(this.arrayOfItems[i]!=null && this.arrayOfItems[i]==item)
			{
				this.arrayOfItems[i]=null;
				break;
			}
		}
	} 
	/**
	 * returns the number of items
	 * 
	 * @return - returns integer
	 */
	public int returnTheNumberOfItems(){
		int count=0;
		for(int i=0;i<maxNumberOfItems;i++)
		{
			if(this.arrayOfItems[i]!=null)
			{
				count++;
			}
		}
		return count;
	}
	/**
	 * checks if the item exists in the array
	 *
	 * @param item - take the item to be checked as parameter
	 * @return - returns boolean
	 */
	public boolean itemExists(Portable item){
		for(int i=0;i<maxNumberOfItems;i++)
		{
			if(arrayOfItems[i]==item)
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Container [label=" + label + ", maxWeight=" + maxWeight + ", maxNumberOfItems=" + maxNumberOfItems
				+ ", arrayOfItems=" + Arrays.toString(arrayOfItems) + "]";
	}
	public int getLabel() {
		return label;
	}
	public void setLabel(int label) {
		this.label = label;
	}
	public int getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public int getMaxNumberOfItems() {
		return maxNumberOfItems;
	}
	public void setMaxNumberOfItems(int maxNumberOfItems) {
		this.maxNumberOfItems = maxNumberOfItems;
	}
}
