package si.um.opj.Ademoglu.logic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import si.um.opj.Ademoglu.logic.cargo.Portable;
import si.um.opj.Ademoglu.ButtonAct;
import si.um.opj.Ademoglu.logic.cargo.Container;
import si.um.opj.Ademoglu.logic.cargo.Food;
import si.um.opj.Ademoglu.logic.transport.FreightTrain;
import si.um.opj.Ademoglu.logic.transport.FreightTrainFullException;
import si.um.opj.Ademoglu.logic.transport.MaximumWeightExceedException;

import java.awt.event.HierarchyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.HierarchyEvent;

public class MainApp {

	private JFrame frmManager;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	JPanel CardLayPanel;
	JPanel FTMan;
	JPanel LoadMan;
	JPanel ContMan;
	FreightTrain ft;
	Container cont;
	ArrayList<FreightTrain> arr = new ArrayList<FreightTrain>();
	ArrayList<Container> contarr = new ArrayList<Container>();
	// ArrayList<Portable> portArr = new ArrayList<Portable>();
	Food f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frmManager.setVisible(true);
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}
	public void writeToFile() {
		 try {
		     File file = new File("C:\\newfile.txt"); //change the name
		     /*If file gets created then the createNewFile() 
		      * method would return true or if the file is 
		      * already present it would return false
		      */
	             boolean fvar = file.createNewFile();
		     if (fvar){
		          System.out.println("File has been created successfully");
		     }
		     else{
		          System.out.println("File already present at the specified location");
		     }
	    	} catch (IOException e) {
	    		System.out.println("Exception Occurred:");
		        e.printStackTrace();
		  }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManager = new JFrame();
		frmManager.setTitle("Manager!");
		frmManager.setResizable(false);
		frmManager.setBounds(100, 100, 531, 380);
		frmManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManager.getContentPane().setLayout(null);

		JComboBox comboBox = new JComboBox();

		String[] mainOpts = { "Freight Train Manager", "Container Manager", "Loading Manager" };

		comboBox.setModel(new DefaultComboBoxModel(mainOpts));
		comboBox.setBounds(240, 11, 195, 20);
		frmManager.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("Select the option:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 11, 204, 20);
		frmManager.getContentPane().add(lblNewLabel);

		CardLayPanel = new JPanel();
		CardLayPanel.setBounds(20, 42, 459, 248);
		frmManager.getContentPane().add(CardLayPanel);
		CardLayPanel.setLayout(new CardLayout(0, 0));

		FTMan = new JPanel();
		CardLayPanel.add(FTMan, "Freight Train Manager");
		FTMan.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblSelectTheOption = new JLabel("Select the option:");
		FTMan.add(lblSelectTheOption);

		JComboBox comboBox_1 = new JComboBox();
		FTMan.add(comboBox_1);
		String[] cde = { "Create", "Delete", "Edit" };
		comboBox_1.setModel(new DefaultComboBoxModel(cde));

		JLabel lblNameOfTrain = new JLabel("Name of train:");
		FTMan.add(lblNameOfTrain);

		textField = new JTextField();
		FTMan.add(textField);
		textField.setColumns(10);

		JLabel lblAverageSpeed = new JLabel("Average speed:");
		FTMan.add(lblAverageSpeed);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		FTMan.add(textField_1);

		JLabel lblMaxWeightOf = new JLabel("Max Weight of Cargo:");
		FTMan.add(lblMaxWeightOf);

		textField_2 = new JTextField();
		FTMan.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblMaxNumOf = new JLabel("Max Num of Containers:");
		FTMan.add(lblMaxNumOf);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		FTMan.add(textField_3);

		JButton button_2 = new JButton("Apply!"); // freight train manager
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String trainName = textField.getText();
				int avSpeed = Integer.parseInt(textField_1.getText());
				int maxweight = Integer.parseInt(textField_2.getText());
				int maxConts = Integer.parseInt(textField_3.getText());
				if (comboBox_1.getSelectedItem() == "Create") { // add item
					ft = new FreightTrain(trainName, avSpeed, maxweight, maxConts);
					arr.add(ft);
				} else if (comboBox_1.getSelectedItem() == "Delete") { // edit item
					for (int i = 0; i < arr.size(); i++) {
						if ((arr.get(i).getName()).equals(trainName)) {
							arr.remove(i);
						}
					}
				} else if (comboBox_1.getSelectedItem() == "Edit") { // delete item
					for (int i = 0; i < arr.size(); i++) {
						if (arr.get(i).getName().equals(trainName)) {
							ft.setAverageSpeed(avSpeed);
							ft.setMaxWeightOfCargo(maxweight);
							ft.setMaxNumOfContainers(maxConts);
							arr.set(i, ft);
						}
					}
				}
				System.out.println(arr);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		FTMan.add(button_2);

		JLabel label_8 = new JLabel("");
		FTMan.add(label_8);

		ContMan = new JPanel();
		CardLayPanel.add(ContMan, "Container Manager");
		ContMan.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblSelectTheOption_1 = new JLabel("Select the option:");
		lblSelectTheOption_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ContMan.add(lblSelectTheOption_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Add", "Edit", "Delete" }));
		ContMan.add(comboBox_2);

		JLabel lblParameter = new JLabel("Name of the container:");
		lblParameter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ContMan.add(lblParameter);

		textField_5 = new JTextField();
		ContMan.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Name of the Item:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ContMan.add(lblNewLabel_2);

		textField_9 = new JTextField();
		ContMan.add(textField_9);
		textField_9.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Weight of the Item:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ContMan.add(lblNewLabel_3);

		textField_10 = new JTextField();
		textField_10.setText("");
		ContMan.add(textField_10);
		textField_10.setColumns(10);

		JLabel lblContainerMustExist = new JLabel("Container must exist to proceed!");
		ContMan.add(lblContainerMustExist);

		JButton button_3 = new JButton("Apply!");
		button_3.addActionListener(new ActionListener() { // Container manager, add items
			public void actionPerformed(ActionEvent e) {
				int contName = Integer.parseInt(textField_5.getText());
				String itemName = textField_9.getText();
				double weightItem = Integer.parseInt(textField_10.getText());
				f = new Food(itemName, weightItem);
				// portArr.add(f);

				if (comboBox_2.getSelectedItem() == "Add") { // add item
					// f = new Food(itemName, weightItem);
					if (contarr != null) {
						for (int i = 0; i < contarr.size(); i++) {
							if (contarr.get(i).getLabel() == contName) {
								contarr.get(i).addItem(f);
								// portArr.add(f);
								break;
							}
						}
					} else {
						System.out.println("You cannot add item, since you dont have any container!");
					}

					System.out.println(arr);
				} else if (comboBox_2.getSelectedItem() == "Edit") { // edit item
					if (contarr != null) {
						for (int i = 0; i < contarr.size(); i++) {
							if (contarr.get(i).getLabel() == contName) {
								Portable[] r = contarr.get(i).getArrayOfItems();
								for (int k = 0; k < r.length; k++) {
									f = new Food(itemName, weightItem);
									contarr.get(i).editItem(f);
								}
							}
						}
					}
				} else if (comboBox_2.getSelectedItem() == "Delete") { // delete item

					if (contarr != null) {
						for (int i = 0; i < contarr.size(); i++) {
							if (contarr.get(i).getLabel() == contName) {
								Portable[] r = contarr.get(i).getArrayOfItems();
								for (int k = 0; k < r.length; k++) {
									if (r[k] != null) {
										if (itemName.equals(r[k].returnNameOfTheItem())
												&& r[k].returnWeightOfTheItem() == weightItem) {
											Portable p = r[k];
											contarr.get(i).removeItem(p);
										}
									}
								}
							}
						}
					}
				}
				System.out.println(arr);
				System.out.println(contarr);
				// System.out.println(portArr);
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		ContMan.add(button_3);

		LoadMan = new JPanel();
		CardLayPanel.add(LoadMan, "Loading Manager");
		LoadMan.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Select the option:");
		lblNewLabel_1.setBounds(23, 11, 96, 27);
		LoadMan.add(lblNewLabel_1);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "Create", "Add", "Remove" }));
		comboBox_3.setBounds(139, 14, 109, 20);
		LoadMan.add(comboBox_3);

		JLabel lblLabelOfContainer = new JLabel("Label of container:");
		lblLabelOfContainer.setBounds(23, 82, 119, 24);
		LoadMan.add(lblLabelOfContainer);

		JLabel lblMaximumWeightOf = new JLabel("Maximum Weight of Container:");
		lblMaximumWeightOf.setBounds(23, 117, 148, 20);
		LoadMan.add(lblMaximumWeightOf);

		JLabel lblMaximumNumberOf = new JLabel("Maximum number of Items:");
		lblMaximumNumberOf.setBounds(23, 148, 148, 20);
		LoadMan.add(lblMaximumNumberOf);

		textField_6 = new JTextField();
		textField_6.setBounds(200, 84, 86, 20);
		LoadMan.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(200, 117, 86, 20);
		LoadMan.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(200, 148, 86, 20);
		LoadMan.add(textField_8);
		textField_8.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(200, 53, 86, 20);
		LoadMan.add(textField_4);
		textField_4.setColumns(10);

		JButton button_1 = new JButton("Apply!");
		button_1.addActionListener(
				new ButtonAct(textField_4, textField_6, textField_7, textField_8, arr, comboBox_3, contarr));

		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(139, 208, 159, 29);
		LoadMan.add(button_1);

		JLabel lblNameOfThe = new JLabel("Name of the train:");
		lblNameOfThe.setBounds(23, 51, 109, 24);
		LoadMan.add(lblNameOfThe);

		JButton btnNewButton = new JButton("Deserialize");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() { // button for file
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem() == mainOpts[0]) {
					FreightTrain o = null;
					try {
						FileInputStream fis = new FileInputStream("FTrain.ser");
						ObjectInputStream ois = new ObjectInputStream(fis);
						o = (FreightTrain) ois.readObject();
						ois.close();
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException cnfe) {
						cnfe.printStackTrace();
						return;
					}
					textField.setText(o.getName());
					Integer avSpeed = o.getAverageSpeed();
					String text = avSpeed.toString();
					textField_1.setText(text);
					Integer maxweight = o.getMaxWeightOfCargo();
					text = maxweight.toString();
					textField_2.setText(text);
					Integer maxConts = o.getMaxNumOfContainers();
					text = maxConts.toString();
					textField_3.setText(text);
				}
				// here comes file input stream
				else if (comboBox.getSelectedItem() == mainOpts[2]) {
					ArrayList<Container> oc = null;
					try {
						FileInputStream fis = new FileInputStream("Container.ser");
						ObjectInputStream ois = new ObjectInputStream(fis);
						oc = (ArrayList<Container>) ois.readObject();
						Integer label = oc.get(0).getLabel();
						String textc = label.toString();
						textField_6.setText(textc);
						Integer contweight = oc.get(0).getMaxWeight();
						textc = contweight.toString();
						textField_7.setText(textc);
						Integer maxnumitems = oc.get(0).getMaxNumberOfItems();
						textc = maxnumitems.toString();
						textField_8.setText(textc);
						ois.close();
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException cnfe) {
						cnfe.printStackTrace();
						return;
					}

				}
			}
		});
		btnNewButton.setBounds(283, 301, 152, 39);
		frmManager.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Serialize");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem() == mainOpts[0]) {
					try {
						FileOutputStream fos = new FileOutputStream("FTrain.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(ft);
						oos.close();
						fos.close();
						System.out.println("Serialzation Done!!");
					} catch (IOException ioe) {
						System.out.println(ioe);
					}
				} else if (comboBox.getSelectedItem() == mainOpts[2]) {
					try {
						FileOutputStream fos = new FileOutputStream("Container.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(contarr);
						oos.close();
						fos.close();
						System.out.println("Serialzation Done!!");
					} catch (IOException ioe) {
						System.out.println(ioe);
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(57, 301, 133, 39);
		frmManager.getContentPane().add(btnNewButton_1);

		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem() == mainOpts[0]) {
					FTMan.setVisible(true);
					LoadMan.setVisible(false);
					ContMan.setVisible(false);
				} else if (comboBox.getSelectedItem() == mainOpts[1]) {
					FTMan.setVisible(false);
					LoadMan.setVisible(false);
					ContMan.setVisible(true);
				} else if (comboBox.getSelectedItem() == mainOpts[2]) {
					FTMan.setVisible(false);
					LoadMan.setVisible(true);
					ContMan.setVisible(false);
				}
			}
		});
		
	}
}
