package rockets.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import rockets.domain.Operacio.TipusOperacio;
import rockets.domain.Rocket;

public class PanelControl extends JPanel {
	
	public PanelControl(Rocket coet) {
		this.coet=coet;
		marcha=1;
		
		accelerar = new JButton("ACCELERAR");
		frenar = new JButton("FRENAR");
		mantenir = new JButton("MANTENIR");
		
		Font font_normal = new Font("Arial", Font.PLAIN, 15);
		Font font_titol=new Font("Arial", Font.BOLD, 20);
		
		setLayout(null);
		frenar.setEnabled(false);
		mantenir.setEnabled(false);
		setBackground(Color.LIGHT_GRAY);
		
		accelerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accelerar.setEnabled(false);
				mantenir.setEnabled(true);
				frenar.setEnabled(true);
				accionBotones(e);
			}
		});
		accelerar.setBounds(100, 40, 150, 40);
		
		frenar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frenar.setEnabled(false);
				mantenir.setEnabled(true);
				accelerar.setEnabled(true);
				accionBotones(e);
			}
		});
		frenar.setBounds(270, 40, 100, 40);
		
		mantenir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mantenir.setEnabled(false);
				frenar.setEnabled(true);
				accelerar.setEnabled(true);
				accionBotones(e);
			}
		});
		mantenir.setBounds(390, 40, 150, 40);
		
		JLabel marchas = new JLabel("Marxes ", SwingConstants.CENTER);
		marchas.setFont(font_normal);
		marchas.setForeground(Color.BLACK);
		marchas.setBounds(20, 10, 70, 20);
		this.add(marchas);
        
		/* box de eleccion de marcha ******************************/
		String[] mach = { "X 1", "X 2", "X 3", "X 4", "X 5" };

		JList<String> listMarchas = new JList<>(mach);
		listMarchas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMarchas.setSelectedIndex(0);
		listMarchas.setFixedCellHeight(15);
		listMarchas.setFixedCellWidth(50);
		listMarchas.setVisibleRowCount(5);
		listMarchas.setBounds(30, 30, 50, 80);
		
		listMarchas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				JList list = (JList) e.getSource();
				marcha = list.getSelectedIndex() + 1;  // sumo 1 porque el array comienza con 0
	
				try {
					coet.setIncrementPotencia(marcha);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		add(accelerar);
		add(mantenir);
		add(frenar);
		add(listMarchas);

		setVisible(true);
		
	}
	
protected void accionBotones(ActionEvent e) {
		
		
		if (e.getSource() == accelerar) {
			this.coet.setOperacio(TipusOperacio.ACCELERAR);
		}
		else if (e.getSource() == frenar) {
			this.coet.setOperacio(TipusOperacio.FRENAR);
		} else {
			this.coet.setOperacio(TipusOperacio.MANTENIR);
		}
	}
	
	private JButton accelerar = new JButton("ACCELERAR");
	private JButton frenar = new JButton("FRENAR");
	private JButton mantenir = new JButton("MANTENIR");
	private Rocket coet;
	private int marcha;
}
