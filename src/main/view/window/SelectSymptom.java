package window;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import core.ClaseSinNombre;
import core.Initializer;

import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

public class SelectSymptom {

	private JFrame frame;
	private Initializer initializer;

	public static void NewWindow(Initializer initializer) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSymptom window = new SelectSymptom(initializer);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SelectSymptom(Initializer initializer) {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DefaultListModel<String> modelListSymptoms = new DefaultListModel<>();
		DefaultListModel<String> modelListDiseases = new DefaultListModel<>();
		List<String> symptomsSelected = new LinkedList<String>();
		ClaseSinNombre claseSinNombre = new ClaseSinNombre();
		this.addSymptoms(modelListSymptoms);//despues sacarlo
		
		JList<String> list_symptoms = new JList<>(modelListSymptoms);
		list_symptoms.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_symptoms.setBounds(80, 46, 183, 211);
		list_symptoms.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_symptoms.setLayoutOrientation(JList.VERTICAL_WRAP);
		frame.getContentPane().add(list_symptoms);
		
		//JList<?> list_diseases = new JList<Object>();
		JList<String> list_diseases = new JList<>(modelListDiseases);
		list_diseases.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_diseases.setBounds(336, 46, 183, 211);
		frame.getContentPane().add(list_diseases);
		
		JLabel lbl_symptoms = new JLabel("Symptoms");
		lbl_symptoms.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_symptoms.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_symptoms.setBounds(127, 11, 91, 24);
		frame.getContentPane().add(lbl_symptoms);
		
		JLabel lbl_diseases = new JLabel("Diseases");
		lbl_diseases.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_diseases.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_diseases.setBounds(379, 11, 91, 24);
		frame.getContentPane().add(lbl_diseases);
		
		JTextPane txtpnInstructions = new JTextPane();
		txtpnInstructions.setText("Instructions");
		txtpnInstructions.setBounds(10, 380, 564, 70);
		frame.getContentPane().add(txtpnInstructions);
		
		JButton btnChooseDisease = new JButton("Choose");
		btnChooseDisease.setBounds(379, 268, 89, 23);
		frame.getContentPane().add(btnChooseDisease);
		btnChooseDisease.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String disease_selected = list_diseases.getSelectedValue();
				frame.setVisible(false);
				DiseaseDetails.NewWindow(initializer, disease_selected);
			}
		});
		
		JButton btnAddSymptoms = new JButton("Add");
		btnAddSymptoms.setBounds(127, 268, 89, 23);
		frame.getContentPane().add(btnAddSymptoms);
		btnAddSymptoms.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String symptomToAdd = list_symptoms.getSelectedValue();
				if(!symptomsSelected.contains(symptomToAdd)){
					symptomsSelected.add(symptomToAdd);
					//btnAddSymptoms.setText(symptomToAdd);//Sacarlo. Es solo para probar de que agrega las cosas
				}
			}
		});
		
		JButton btnSearchDiseases = new JButton("->");
		btnSearchDiseases.setBounds(273, 141, 50, 23);
		frame.getContentPane().add(btnSearchDiseases);
		btnSearchDiseases.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				modelListDiseases.clear();//to not repeat the same diseases each time that this button is clicked
				List<String> possibleDiseases = claseSinNombre.getPossibleDiseases(symptomsSelected);
				for ( int i = 0; i < possibleDiseases.size(); i++ ){
					  modelListDiseases.addElement( possibleDiseases.get(i));
				}
			}
		});
	}

	//(para juli)esta es una de las cosas que te dije en el audio. ¿Se hardcodea con los sintomas o se busca en la base de datos?
	//lo mas prolijo seria lo segundo
	private void addSymptoms(DefaultListModel<String> modelListSymptoms) {
		List<String> list = new LinkedList<>();
		list.add("Elemento 1");
		list.add("Elemento 2");
		list.add("Elemento 3");
		list.add("E4");
				
		for ( int i = 0; i < list.size(); i++ ){
			  modelListSymptoms.addElement( list.get(i));
		}
	}
}
