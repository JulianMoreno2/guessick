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
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import core.Core;
import core.ResourceContainer;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;

public class DiseaseDetails {

	private JFrame frame;
	private Core core;
	private String diseaseSelected;
	public static void NewWindow(String diseaseSelected) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiseaseDetails window = new DiseaseDetails(diseaseSelected);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DiseaseDetails(String diseaseSelected) {
		this.diseaseSelected = diseaseSelected;
		core = new Core();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultListModel<String> modelListDetails = new DefaultListModel<>();

		Set<String> diseaseDetails = this.getDetails(diseaseSelected);
		this.addDetails(modelListDetails, diseaseDetails);
		frame.getContentPane().setLayout(null);
		
		JList<String> list_symptoms = new JList<>(modelListDetails);
		list_symptoms.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_symptoms.setBounds(26, 40, 378, 194);
		list_symptoms.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_symptoms.setLayoutOrientation(JList.VERTICAL_WRAP);
		frame.getContentPane().add(list_symptoms);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 238, 434, 23);
		frame.getContentPane().add(btnBack);
		
		addTextPaneTitleDisease(btnBack);
	}

	private void addTextPaneTitleDisease(JButton btnBack) {
		JTextPane textPaneDiseaseTitle = new JTextPane();
		textPaneDiseaseTitle.setMargin(new Insets(3, 10, 3, 3));
		textPaneDiseaseTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		StyledDocument doc = textPaneDiseaseTitle.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);	
		
		textPaneDiseaseTitle.setBounds(127, 11, 206, 23);
		textPaneDiseaseTitle.setText(diseaseSelected);
		textPaneDiseaseTitle.setEditable(false);
		frame.getContentPane().add(textPaneDiseaseTitle);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				SelectSymptom.NewWindow();
			}
		});
	}

	private Set<String> getDetails(String disease_selected) {		
		return core.getDiseaseDetails(disease_selected);
	}
	
	private void addDetails(DefaultListModel<String> modelListDetails, Set<String> details) {
		if(details != null){
			details.stream().forEach(symptom -> modelListDetails.addElement(symptom));			
		}
	}
}
