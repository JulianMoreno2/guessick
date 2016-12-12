package window;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import core.Core;
import view.FrameBackground;

import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

public class SelectSymptom {

	private JFrame frame;
	private Core core;

	public static void NewWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSymptom window = new SelectSymptom();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SelectSymptom() {
		core = new Core();
		initialize();
	}

	private void initialize() {
		frame = new FrameBackground("Select Symptom", "../Medicina.jpg");
		frame.setBounds(200, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DefaultListModel<String> modelListSymptoms = new DefaultListModel<>();
		DefaultListModel<String> modelListSymptomsSelected = new DefaultListModel<>();
		DefaultListModel<String> modelListDiseases = new DefaultListModel<>();
		Set<String> symptomsSelected = new HashSet<String>();		
		
		List<String> listAdded = this.addSymptoms(modelListSymptoms);//despues sacarlo
		
		JList<String> list_symptoms = addSymptomsJList(modelListSymptoms);
		addSymptomsLabel();
		
		//JList<?> list_diseases = new JList<Object>();
		JList<String> list_diseases = addDiseasesJList(modelListDiseases);				
		addDiseasesLabel();
		
		JList<String> list_symptoms_selected = addSymptomsSelectedJList(modelListSymptomsSelected);
		addSymptomsSelectedLabel();
				
		addJButtonAddSymptoms(modelListSymptoms, modelListSymptomsSelected, symptomsSelected, list_symptoms, listAdded);

		addJButtonChooseDisease(list_diseases);
		
		addJButtonSearchDiseases(modelListDiseases, symptomsSelected);
		
		addJButtonRefresh(symptomsSelected, modelListSymptomsSelected, list_symptoms, modelListSymptoms);
		
		addJTextPaneViewInstructions();
	}

	

	private void addJButtonSearchDiseases(DefaultListModel<String> modelListDiseases, Set<String> symptomsSelected) {
		JButton btnSearchDiseases = new JButton("->");
		btnSearchDiseases.setBounds(491, 138, 50, 23);
		frame.getContentPane().add(btnSearchDiseases);
		btnSearchDiseases.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				modelListDiseases.clear();//to not repeat the same diseases each time that this button is clicked
				core.getPossibleDiseases(symptomsSelected).forEach(disease -> modelListDiseases.addElement(disease));
			}
		});
	}

	private void addJButtonAddSymptoms(DefaultListModel<String> modelListSymptoms, DefaultListModel<String> modelListSymptomsSelected, Set<String> symptomsSelected, JList<String> list_symptoms, List<String> listAdded) {
		JButton btnAddSymptoms = new JButton("Add");
		btnAddSymptoms.setBounds(127, 268, 89, 23);
		frame.getContentPane().add(btnAddSymptoms);
		btnAddSymptoms.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String symptomToAdd = list_symptoms.getSelectedValue();
				symptomsSelected.add(symptomToAdd);	
				modelListSymptoms.removeAllElements();
				addNewSymptomSelected(listAdded, symptomsSelected, modelListSymptoms);
				modelListSymptomsSelected.clear();
				symptomsSelected.forEach(symptom -> modelListSymptomsSelected.addElement(symptom));
			}
		});
	}

	protected void addNewSymptomSelected(List<String> listAdded, Set<String> symptomsSelected, DefaultListModel<String> modelListSymptoms) {
		listAdded.stream().filter(symptom -> !symptomsSelected.contains(symptom)).forEach(symptom -> modelListSymptoms.addElement(symptom));
	}
	
	private List<String> addSymptoms(DefaultListModel<String> modelListSymptoms) {

		//Habilitar cuando esten cargados los sintomas en la base de datos
		List<String> symptoms = this.core.getAllSymptoms();
		symptoms.forEach(symptom -> modelListSymptoms.addElement(symptom));
		
		return symptoms;
	}

	private void addJButtonChooseDisease(JList<String> list_diseases) {
		JButton btnChooseDisease = new JButton("Choose");
		btnChooseDisease.setBounds(603, 269, 89, 23);
		frame.getContentPane().add(btnChooseDisease);
		btnChooseDisease.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String disease_selected = list_diseases.getSelectedValue();
				frame.setVisible(false);
				DiseaseDetails.NewWindow(disease_selected);
			}
		});
	}

	private void addJButtonRefresh(Set<String> symptomsSelected, DefaultListModel<String> modelListSymptomsSelected, JList<String> list_symptoms, DefaultListModel<String> modelListSymptoms) {
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(337, 267, 117, 25);
		frame.getContentPane().add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				symptomsSelected.clear();
				modelListSymptomsSelected.clear();
				modelListSymptoms.clear();
				addSymptoms(modelListSymptoms);
			}
		});
	}
	
	private void addJTextPaneViewInstructions() {
		JTextPane txtpnInstructions = new JTextPane();
		txtpnInstructions.setText("Instructions");
		txtpnInstructions.setBounds(10, 380, 564, 70);
		txtpnInstructions.setEnabled(false);
		frame.getContentPane().add(txtpnInstructions);
	}

	private void addDiseasesLabel() {
		JLabel lbl_diseases = new JLabel("Diseases");
		lbl_diseases.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_diseases.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_diseases.setBounds(601, 11, 91, 24);
		frame.getContentPane().add(lbl_diseases);
	}

	private JList<String> addDiseasesJList(DefaultListModel<String> modelListDiseases) {
		JList<String> list_diseases = new JList<>(modelListDiseases);
		list_diseases.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_diseases.setBounds(564, 46, 183, 211);
		frame.getContentPane().add(list_diseases);
		return list_diseases;
	}

	private void addSymptomsLabel() {
		JLabel lbl_symptoms = new JLabel("Symptoms");
		lbl_symptoms.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_symptoms.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_symptoms.setBounds(127, 11, 91, 24);
		frame.getContentPane().add(lbl_symptoms);
	}

	private JList<String> addSymptomsJList(DefaultListModel<String> modelListSymptoms) {
		JList<String> list_symptoms = new JList<>(modelListSymptoms);
		list_symptoms.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_symptoms.setBounds(80, 46, 183, 211);
		list_symptoms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_symptoms.setLayoutOrientation(JList.VERTICAL_WRAP);
		frame.getContentPane().add(list_symptoms);
		return list_symptoms;
	}
	
	private JList<String> addSymptomsSelectedJList(DefaultListModel<String> modelListSymptomsSelected) {
		JList<String> list_symptoms_selected = new JList<>(modelListSymptomsSelected);
		list_symptoms_selected.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_symptoms_selected.setBounds(296, 46, 183, 211);
		frame.getContentPane().add(list_symptoms_selected);
		
		return list_symptoms_selected;
	}
	
	private void addSymptomsSelectedLabel() {
		JLabel lblSymptomsSelected = new JLabel("Symptoms Selected");
		lblSymptomsSelected.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblSymptomsSelected.setBounds(318, 16, 161, 15);
		frame.getContentPane().add(lblSymptomsSelected);
	}
}
