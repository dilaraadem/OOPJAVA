package si.um.opj.Ademoglu.logic;
import java.time.LocalDate;

import si.um.opj.Ademoglu.logic.transport.Train;

/** @author Dilara
 * @version 2
*/

public class Route {

	private LocalDate startDate;
	private City startingCity;
	private City destinationCity;
	private Train train;
	private int routeDistance;
	
	public Route() {
		// TODO Auto-generated constructor stub
	}	
	/**
	 * constructs the route object
	 * 
	 * @param startingCity - starting city
	 * @param destinationCity - destination city
	 */
	public Route(City startingCity, City destinationCity) {

		this.startingCity = startingCity;
		this.destinationCity = destinationCity;
	}	
	/**
	 * calculates date of arrival
	 * 
	 * @return - returns the LocalDate type
	 */
	public LocalDate calculateDateOfTheArrival(){
		int time = getRouteDistance()/getTrain().getAverageSpeed()/24;
		LocalDate endDate = getStartDate().plusDays(time);
		return endDate;
	}

	@Override
	public String toString() {
		return "Route [startDate=" + startDate + ", startingCity=" + startingCity + ", destinationCity="
				+ destinationCity + ", train=" + train + ", routeDistance=" + routeDistance + "]";
	}
	public City getStartingCity() {
		return startingCity;
	}
	public void setStartingCity(City startingCity) {
		this.startingCity = startingCity;
	}
	public City getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(City destinationCity) {
		this.destinationCity = destinationCity;
	}
	public int getRouteDistance() {
		return routeDistance;
	}
	public void setRouteDistance(int routeDistance) throws IllegalArgumentException {
		if(routeDistance>=0)
			this.routeDistance = routeDistance;
		else
			throw new IllegalArgumentException("Oops cannot set route distance");
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	
}
