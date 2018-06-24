package si.um.opj.Ademoglu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import si.um.opj.Ademoglu.logic.transport.FreightTrainFullException;
import si.um.opj.Ademoglu.logic.transport.MaximumWeightExceedException;
import si.um.opj.Ademoglu.logic.cargo.Container;
import si.um.opj.Ademoglu.logic.transport.FreightTrain;

public class ButtonAct implements ActionListener {

	private ArrayList<FreightTrain> arr;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JComboBox comboBox_3;
	private Container cont;
	private FreightTrain ft;
	private Container c;
	String fname = "";
	ArrayList<Container> contarr = new ArrayList<Container>();

	public ButtonAct(JTextField textField_4, JTextField textField_6, JTextField textField_7, JTextField textField_8,
			ArrayList<FreightTrain> arr, JComboBox comboBox_3, ArrayList<Container> contarr) {
		this.textField_4 = textField_4;
		this.textField_6 = textField_6;
		this.textField_7 = textField_7;
		this.textField_8 = textField_8;
		this.arr = arr;
		this.comboBox_3 = comboBox_3;
		this.contarr = contarr;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) { // loading manager

		int label = Integer.parseInt(textField_6.getText());
		int contweight = Integer.parseInt(textField_7.getText());
		int maxnumitems = Integer.parseInt(textField_8.getText());
		fname = textField_4.getText();

		if (comboBox_3.getSelectedItem() == "Add") { // edit item
			for (int j = 0; j < arr.size(); j++) {
				ft = arr.get(j);
				if (ft.getName().equals(fname)) {
					for (int k = 0; k < contarr.size(); k++) {
						c = contarr.get(k);
						if (label == c.getLabel()) {
							try {
								ft.loadContainer(c);
								break;
							} catch (FreightTrainFullException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (MaximumWeightExceedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
			System.out.println(arr);
		} else if (comboBox_3.getSelectedItem() == "Remove") { // delete item
			for (int j = 0; j < arr.size(); j++) {
				ft = arr.get(j);
				if (ft.getName().equals(fname)) {
					for (int i = 0; i < ft.getArrayOfContainers().length; i++) {
						cont = arr.get(j).getArrayOfContainers()[i];
						if (cont != null) {
							for (int k = 0; k < contarr.size(); k++) {
								c = contarr.get(k);
								if (c.getLabel() == label) {
									ft.unloadContainer(c);
									break;
								}
							}
						}

					}
				}
			}
		} else if (comboBox_3.getSelectedItem() == "Create") {
			Container x = new Container(label, contweight, maxnumitems);
			contarr.add(x);
		}
		System.out.println(contarr);
		System.out.println(arr);
	}
}
