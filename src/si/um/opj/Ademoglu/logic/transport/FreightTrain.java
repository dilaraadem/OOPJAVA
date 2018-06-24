package si.um.opj.Ademoglu.logic.transport;

import java.io.Serializable;
import java.util.Arrays;

import si.um.opj.Ademoglu.logic.ILogistics;
import si.um.opj.Ademoglu.logic.cargo.Container;

public class FreightTrain extends Train implements ILogistics, Serializable {
	private int maxWeightOfCargo;
	private int maxNumOfContainers;
	private Container[] arrayOfContainers; // limited by max num of conts

	public FreightTrain() {
		super();
	}

	public FreightTrain(String name, int aveSpeed, int maxWeight, int maxCont) {
		super(name, aveSpeed);
		this.maxWeightOfCargo = maxWeight;
		this.maxNumOfContainers = maxCont;
		this.arrayOfContainers = new Container[maxNumOfContainers];
	}

	@Override
	public String toString() {
		return super.toString() + "FreightTrain [maxWeightOfCargo=" + maxWeightOfCargo + ", maxNumOfContainers="
				+ maxNumOfContainers + ", arrayOfContainers=" + Arrays.toString(arrayOfContainers) + "]";
	}

	public int getMaxWeightOfCargo() {
		return maxWeightOfCargo;
	}

	public void setMaxWeightOfCargo(int maxWeightOfCargo) {
		this.maxWeightOfCargo = maxWeightOfCargo;
	}

	public int getMaxNumOfContainers() {
		return maxNumOfContainers;
	}

	public void setMaxNumOfContainers(int maxNumOfContainers) {
		this.maxNumOfContainers = maxNumOfContainers;
	}

	public Container[] getArrayOfContainers() {
		return arrayOfContainers;
	}

	public void setArrayOfContainers(Container[] arrayOfContainers) {
		this.arrayOfContainers = arrayOfContainers;
	}

	@Override
	public double getOccupancy() {
		// TODO Auto-generated method stub
		// returns percentage of space occupied by loaded containers
		int numItems = 0;
		int max = 0;
		for (int i = 0; i < this.arrayOfContainers.length; i++) {
			numItems = numItems + arrayOfContainers[i].returnTheNumberOfItems();
			max = max + arrayOfContainers[i].getMaxNumberOfItems();
		}

		double space = 100 * (double) (numItems) / (double) (max);
		return space;
	}

	@Override
	public void loadContainer(Container container) throws FreightTrainFullException, MaximumWeightExceedException {
		// TODO Auto-generated method stub
		System.out.println("Loading container...");
		int weight = 0;
		int numOfEmpty = 0;
		for (int i = 0; i < maxNumOfContainers; i++) {
			if (this.arrayOfContainers[i] != null) {
				weight = weight + arrayOfContainers[i].getMaxWeight();
			} else
				numOfEmpty++;
		} // calculate the total weight it has

		if ((weight+container.getMaxWeight()) < maxWeightOfCargo) { // if weight is not exceeded
			if (numOfEmpty != 0) {
				for (int i = 0; i < maxNumOfContainers; i++) {
					if (this.arrayOfContainers[i] == null) {
						this.arrayOfContainers[i] = container;
						break;
					}
				}
			} else
				throw new FreightTrainFullException();
		} else
			throw new MaximumWeightExceedException();
	}

	@Override
	public void unloadContainer(Container container) {
		// TODO Auto-generated method stub
		System.out.println("Unloading container...");
		for (int i = 0; i < maxNumOfContainers; i++) {
			if (this.arrayOfContainers[i] != null && this.arrayOfContainers[i] == container) {
				this.arrayOfContainers[i] = null;
				break;
			}
		}
	}
}