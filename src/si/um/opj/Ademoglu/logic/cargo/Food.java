package si.um.opj.Ademoglu.logic.cargo;

public class Food implements Portable{

	String name;
	double weight;
	@Override
	public String toString() {
		return "Food [name=" + name + ", weight=" + weight + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Food() {
		// TODO Auto-generated constructor stub
	}
	public Food(String name, double weight) {
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
