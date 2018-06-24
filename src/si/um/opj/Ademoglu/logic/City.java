package si.um.opj.Ademoglu.logic;
/**
 * 
 * @author Dilara
 * @version 2
 */
public class City {

	private String city;
	private String country;
	
	public City() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * constructs the city
	 * 
	 * @param city - get the city
	 * @param country - get the country
	 */
	public City(String city, String country) {
		this.city = city;
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "City [city=" + city + ", country=" + country + "]";
	}
	
}
