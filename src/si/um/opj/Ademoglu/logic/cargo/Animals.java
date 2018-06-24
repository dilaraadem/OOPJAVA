package si.um.opj.Ademoglu.logic.cargo;

public class Animals implements Portable{
	
	String name;
	double weight;
	public Animals() {
		// TODO Auto-generated constructor stub
	}
	public Animals(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String returnNameOfTheItem() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public double returnWeightOfTheItem() {
		// TODO Auto-generated method stub
		return this.weight;
	}

}
