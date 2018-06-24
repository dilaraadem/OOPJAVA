package si.um.opj.Ademoglu;

import si.um.opj.Ademoglu.logic.City;
import si.um.opj.Ademoglu.logic.Route;
import si.um.opj.Ademoglu.logic.cargo.Animals;
import si.um.opj.Ademoglu.logic.cargo.Container;
import si.um.opj.Ademoglu.logic.cargo.Food;
import si.um.opj.Ademoglu.logic.transport.FreightTrain;
import si.um.opj.Ademoglu.logic.transport.FreightTrainFullException;
import si.um.opj.Ademoglu.logic.transport.MaximumWeightExceedException;
import si.um.opj.Ademoglu.logic.transport.PassengerTrain;
import si.um.opj.Ademoglu.logic.transport.PassengerTrainType;

/**
 * @author Dilara
 * @version 2
 */
public class Launcher {
	public static void main(String[] args) {

		City ist = new City("Istanbul","Turkey");
		City mb = new City("Maribor","Slovenia");
		Route r = new Route(ist, mb);
		r.setRouteDistance(100);
		// Scanner s = new Scanner(System.in);
		int mWeight = 100;
		int mCont = 2;
		int mSeat = 500;
		int numSeat = 357;
		int mHandHold = 200;
		int numhhold = 123;

		String tName = "blue";
		int speed = 100;
		PassengerTrain pt = new PassengerTrain(tName, speed, mSeat, mHandHold, numhhold, numSeat,
				PassengerTrainType.LOCAL); // create passenger train
		String trainname = "RED";
		int speedy = 150;
		FreightTrain ft = new FreightTrain(trainname, speedy, mWeight, mCont); // create freight train

		int label = 90;
		int maxNumItems = 5;
		int maxWeight = 1000;
		int label2 = 100;
		int maxWeig = 5000;
		int maxNumCont = 4;

		Container cont = new Container(label, maxWeight, maxNumItems); // create new containers
		Container xyz = new Container(label2, maxWeig, maxNumCont);

		// create items to load to containers
		Animals item = new Animals("chicken", 400);
		Animals item2 = new Animals("sheep", 300);
		Food item3 = new Food("apple", 100);
		Food item4 = new Food("banana", 239);
		Food item5 = new Food("carrot", 398);
		Animals item6 = new Animals("cow", 890);
		// load items to containers
		cont.addItem(item);
		cont.addItem(item2);
		cont.addItem(item6);
		xyz.addItem(item5);
		xyz.addItem(item4);
		xyz.addItem(item3);
		System.out.println(ft);
		try {
			ft.loadContainer(cont);
		} catch (FreightTrainFullException | MaximumWeightExceedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ft);
		ft.unloadContainer(cont);
		System.out.println(ft);
		try {
			ft.loadContainer(xyz);
		} catch (FreightTrainFullException | MaximumWeightExceedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ft);
		try {
			ft.loadContainer(cont);
		} catch (FreightTrainFullException | MaximumWeightExceedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(ft);
		System.out.println(pt);
		System.out.println("Occupancy of passenger train: " + pt.getOccupancy()); // get occupancy of passenger train
		System.out.println("Occupancy of freight train: " + ft.getOccupancy());
	}
}
