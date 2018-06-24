package si.um.opj.Ademoglu.logic.transport;

public class PassengerTrain extends Train{
	
	private int maxNumberOfSeats;
	private int maxNumberOfHandholds;
	private int numberOfSoldHandholds;
	private int numberOfSoldSeats;
	private PassengerTrainType passenger;
	
	public PassengerTrain() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public PassengerTrain(String name, int speed, int maxSeat, int maxHand, int numHand, int numSold, PassengerTrainType pass) {
		super(name, speed);
		this.maxNumberOfHandholds = maxHand;
		this.maxNumberOfSeats = maxSeat;
		this.numberOfSoldHandholds = numHand;
		this.numberOfSoldSeats = numSold;
		this.passenger = pass;
	}

	public int getMaxNumberOfSeats() {
		return maxNumberOfSeats;
	}

	public void setMaxNumberOfSeats(int maxNumberOfSeats) {
		this.maxNumberOfSeats = maxNumberOfSeats;
	}

	public int getMaxNumberOfHandholds() {
		return maxNumberOfHandholds;
	}

	public void setMaxNumberOfHandholds(int maxNumberOfHandholds) {
		this.maxNumberOfHandholds = maxNumberOfHandholds;
	}

	public int getNumberOfSoldHandholds() {
		return numberOfSoldHandholds;
	}

	public void setNumberOfSoldHandholds(int numberOfSoldHandholds) {
		this.numberOfSoldHandholds = numberOfSoldHandholds;
	}

	public int getNumberOfSoldSeats() {
		return numberOfSoldSeats;
	}

	public void setNumberOfSoldSeats(int numberOfSoldSeats) {
		this.numberOfSoldSeats = numberOfSoldSeats;
	}

	@Override
	public String toString() {
			return super.toString() + "PassengerTrain [maxNumberOfSeats=" + maxNumberOfSeats + ", maxNumberOfHandholds=" + maxNumberOfHandholds
					+ ", numberOfSoldHandholds=" + numberOfSoldHandholds + ", numberOfSoldSeats=" + numberOfSoldSeats + "]";
	}

	@Override
	public double getOccupancy() {
		// TODO Auto-generated method stub
		// returns the percentage of sold handholds and seats
		int sold = this.numberOfSoldHandholds + this.numberOfSoldSeats;
		int max = this.maxNumberOfHandholds + this.maxNumberOfSeats;
		double value = 100*(double)(sold)/(double)(max);
		return value;
	}
	
}