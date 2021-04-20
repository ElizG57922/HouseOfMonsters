package hom;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Visuals extends JFrame{	
	private GraphicPanel gp;
	private int WIDTH = 1000;
	private int HEIGHT = 700;

	public Visuals (){
		setTitle("House Of Monsters");
		setSize(WIDTH, HEIGHT);

		// -- center the frame on the screen
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(5, 5));
		gp = new GraphicPanel();
		this.add(gp, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public GraphicPanel getGP() {
		return gp;
	}
	public class GraphicPanel extends JPanel {

		private JTextArea textfield;
		private JTextField choice;
		private JButton nextButton;
		public GraphicPanel (){
			super();
			setLayout(new BorderLayout());

			textfield = new JTextArea(5, 20);
			JScrollPane scrollPane = new JScrollPane(textfield); 
			textfield.setEditable(false);
			textfield.setLineWrap(true);
			textfield.setWrapStyleWord(true);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setPreferredSize(new Dimension(250, 250));



			choice = new JTextField("");
			add(choice);
			JButton nextButton = new JButton("Next");
			nextButton.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Text.stopWaiting();
						}
					}
					);
			JPanel interactions = new JPanel(new GridLayout(1, 1, 1, 1));

			interactions.add(new JLabel("Choice:"));
			interactions.add(choice);
			interactions.add(nextButton);

			add(scrollPane, BorderLayout.CENTER);
			add(interactions, BorderLayout.SOUTH);

		}
		public void addText(String newText){
			textfield.append(newText);;
		}
		public String getResponse() {
			return choice.getText();
		}
		public Dimension getPreferredSize() 
		{
			return new Dimension(50, 50);
		}


	}
}
