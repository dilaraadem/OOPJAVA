package si.um.opj.Ademoglu.logic;

import si.um.opj.Ademoglu.logic.cargo.Container;
import si.um.opj.Ademoglu.logic.transport.FreightTrainFullException;
import si.um.opj.Ademoglu.logic.transport.MaximumWeightExceedException;

public interface ILogistics {
	void loadContainer(Container container) throws FreightTrainFullException, MaximumWeightExceedException ;
	void unloadContainer(Container container);
}
