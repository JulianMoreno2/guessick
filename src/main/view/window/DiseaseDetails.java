package window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import core.Core;
import core.ResourceContainer;

import javax.swing.JButton;
import java.awt.BorderLayout;

public class DiseaseDetails {

	private JFrame frame;
	private static String disease;
	public static void NewWindow(ResourceContainer initializer, String disease_selected) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiseaseDetails window = new DiseaseDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		disease = disease_selected;
	}
	
	public DiseaseDetails() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// no se si es la mejor manera, pero se podria listar en distintos es string los distintos consejos o cosas
		// que haya para esa enfermedad
		DefaultListModel<String> modelListDetails = new DefaultListModel<>();
		//
		Set<String> diseaseDetails = this.getDetails(disease);
		this.addDetails(modelListDetails, diseaseDetails);
		
		JList<String> list_symptoms = new JList<>(modelListDetails);
		list_symptoms.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_symptoms.setBounds(80, 76, 383, 241);
		list_symptoms.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_symptoms.setLayoutOrientation(JList.VERTICAL_WRAP);
		frame.getContentPane().add(list_symptoms);
		
		JButton btnBack = new JButton("Back");
		frame.getContentPane().add(btnBack, BorderLayout.SOUTH);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				SelectSymptom.NewWindow();
			}
		});
	}

	private Set<String> getDetails(String disease_selected) {
		Core claseSinNombre = new Core();
		return claseSinNombre.getDiseaseDetails(disease_selected);
	}
	
	private void addDetails(DefaultListModel<String> modelListDetails, Set<String> details) {
		details.stream().forEach(symptom -> modelListDetails.addElement(symptom));
	}

}
