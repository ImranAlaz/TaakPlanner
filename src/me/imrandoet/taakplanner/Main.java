package me.imrandoet.taakplanner;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private Thread tr;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					window.frame.setTitle("Taakplanner");
					window.frame.setResizable(true);
					
					//create file
					if (!new File(System.getProperty("user.dir", "tasks.txt")).exists()) {
						new File(System.getProperty("user.dir"), "tasks.txt").mkdir();
					}
					
					System.out.println(System.getProperty("user.dir"));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		tr = new Thread(new Runnable() {

			@Override
			public void run() {
				if (!frame.isEnabled()) {
					tr.destroy();
				}
			}
		});
		tr.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 571, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProject = new JLabel("Project");
		lblProject.setBounds(11, 5, 46, 14);
		frame.getContentPane().add(lblProject);
		
		textField = new JTextField();
		textField.setBounds(6, 21, 129, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(138, 21, 49, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(201, 21, 89, 23);
		btnNewButton.setEnabled(!(textField.getText().isEmpty()));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBounds(299, 21, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JCheckBox chckbxJazeker = new JCheckBox("Jazeker");
		chckbxJazeker.setBounds(395, 20, 97, 23);
		frame.getContentPane().add(chckbxJazeker);
	}
}
