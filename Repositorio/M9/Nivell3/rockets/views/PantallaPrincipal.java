package rockets.views;

import java.awt.Color;

import javax.swing.JFrame;

import rockets.domain.Rocket;

public class PantallaPrincipal extends JFrame{
	
	public PantallaPrincipal(Rocket coet1, Rocket coet2) {
		this.coet1=coet1;
		this.coet2=coet2;
		
		this.setBounds(100, 100, 1270, 660);
		setTitle("Plataforma de llançament");
		
		pantalla_coet1 = new PantallaCoet(coet1);
		pantalla_coet1.setBounds(0, 0, 600, 500);
		pantalla_coet1.setBackground(Color.LIGHT_GRAY);
		add(pantalla_coet1);
		
		pantalla_coet2 = new PantallaCoet(coet2);
		pantalla_coet2.setBounds(655, 0, 600, 500);
		pantalla_coet2.setBackground(Color.LIGHT_GRAY);
		add(pantalla_coet2);
		
		Thread t1=new Thread(pantalla_coet1);
		Thread t2=new Thread(pantalla_coet2);
		t1.start();
		t2.start();
		
		panelControl1 = new PanelControl(coet1);
		panelControl1.setBounds(0,500, 600, 120);
		this.add(panelControl1);
		
		panelControl2 = new PanelControl(coet2);
		panelControl2.setBounds(655,500, 600, 120);
		this.add(panelControl2);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
	}
	
	private Rocket coet1;
	private Rocket coet2;
	private PantallaCoet pantalla_coet1;
	private PantallaCoet pantalla_coet2;
	private PanelControl panelControl1;
	private PanelControl panelControl2;
}
