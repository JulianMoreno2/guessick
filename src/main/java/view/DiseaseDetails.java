package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import core.ClaseSinNombre;
import core.Initializer;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class DiseaseDetails {

	private JFrame frame;
	private static String disease;
	private Initializer initializer;

	public static void NewWindow(Initializer initializer, String disease_selected) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiseaseDetails window = new DiseaseDetails(initializer);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		disease = disease_selected;
	}
	
	public DiseaseDetails(Initializer initializer) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// no se si es la mejor manera, pero se podria listar en distintos es string los distintos consejos o cosas
		// que haya para esa enfermedad
		DefaultListModel<String> modelListDetails = new DefaultListModel<>();
		//
		List<String> diseaseDetails = this.getDetails(disease);
		this.addDetails(modelListDetails, diseaseDetails);
		
		JList<String> list_disease_detail = new JList<>(modelListDetails);
		list_disease_detail.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_disease_detail.setBounds(80, 76, 383, 241);
		list_disease_detail.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_disease_detail.setLayoutOrientation(JList.VERTICAL_WRAP);
		frame.getContentPane().add(list_disease_detail);
		
		JButton btnBack = new JButton("Back");
		frame.getContentPane().add(btnBack, BorderLayout.SOUTH);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				SelectSymptom.NewWindow(initializer);
			}
		});
	}

	private List<String> getDetails(String disease_selected) {
		ClaseSinNombre claseSinNombre = new ClaseSinNombre();
		return claseSinNombre.getDiseaseDetails(disease_selected);
	}
	
	private void addDetails(DefaultListModel<String> modelListDetails, List<String> details) {
		for ( int i = 0; i < details.size(); i++ ){
			  modelListDetails.addElement( details.get(i));
		}
	}

}
