package rockets.views;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import rockets.domain.Rocket;

public class PantallaCoet extends JPanel implements Runnable{
	
	public PantallaCoet(Rocket coet) {
		this.coet=coet;
		setBounds(600, 0, 500, 500);
		
		potPropulsorLabels=new ArrayList();
		
		Font font_normal = new Font("Arial", Font.PLAIN, 15);
		Font font_titol=new Font("Arial", Font.BOLD, 20);
		setLayout(null);
		
		nomLabel = new JLabel( "ROCKET "+coet.getNom(), SwingConstants.CENTER);
		nomLabel.setFont(font_titol);
		nomLabel.setForeground(Color.BLACK);
		nomLabel.setBounds(0, 0, 600, 100);				
		this.add(nomLabel);
		
		JLabel titolVelocitatLabel;
		titolVelocitatLabel = new JLabel("Velocidad: ", SwingConstants.RIGHT);
		titolVelocitatLabel.setFont(font_titol);
		titolVelocitatLabel.setForeground(Color.BLACK);
		titolVelocitatLabel.setBounds(0, 100, 300, 50);			
		this.add(titolVelocitatLabel);
		
		velocitatLabel = new JLabel("0 Km/h", SwingConstants.LEFT);
		velocitatLabel.setFont(font_titol);
		velocitatLabel.setForeground(Color.BLACK);
		velocitatLabel.setBounds(300, 100, 350, 50);		
		this.add(velocitatLabel);
		
		JLabel titPropulsor= new JLabel("Propulsor " , SwingConstants.LEFT);
		titPropulsor.setFont(font_titol);
		titPropulsor.setForeground(Color.BLACK);
		titPropulsor.setBounds(60, 150 , 140, 50);
		this.add(titPropulsor);
		
		JLabel titPotencia= new JLabel("<html>Potencia<br> actual</html>" , SwingConstants.LEFT);
		titPotencia.setFont(font_titol);
		titPotencia.setForeground(Color.BLACK);
		titPotencia.setBounds(230, 150 , 150, 50);
		this.add(titPotencia);
		
		JLabel titMaxPotencia= new JLabel("<html>Potencia <br>maxima</html>" , SwingConstants.LEFT);
		titMaxPotencia.setFont(font_titol);
		titMaxPotencia.setForeground(Color.BLACK);
		titMaxPotencia.setBounds(380, 150 , 150, 50);
		this.add(titMaxPotencia);
		
		for (int iprop=0;iprop<coet.getNumPropulsors();iprop++) {
			JLabel  nroPropulsor= new JLabel((iprop+1) + " " , SwingConstants.CENTER);
			nroPropulsor.setFont(font_normal);
			nroPropulsor.setForeground(Color.BLACK);
			nroPropulsor.setBounds(30, 150 + (iprop+1)*50, 150, 50);				
			this.add( nroPropulsor);
			
			JLabel potPropulsor= new JLabel(coet.getPotenciaActual(iprop) + " " , SwingConstants.CENTER);
			potPropulsor.setFont(font_normal);
			potPropulsor.setForeground(Color.BLACK);
			potPropulsor.setBounds(210, 150 + (iprop+1)*50, 150, 50);				
			this.add( potPropulsor);
			potPropulsorLabels.add(potPropulsor);
			
			JLabel maxPotencia= new JLabel(coet.getPotenciaMaxima(iprop) + " " , SwingConstants.CENTER);
			maxPotencia.setFont(font_normal);
			maxPotencia.setForeground(Color.BLACK);
			maxPotencia.setBounds(360, 150 + (iprop+1)*50, 150, 50);				
			this.add( maxPotencia);
			
		}								
		
		setVisible(true);
	}
	
	public void run() {
		Actualitzar();
	}
	
	private void Actualitzar() {
		int  potTotal,  potTotal2;			

		try {
			coet.ActualitzaPotencia();
			while(true) {
				Thread.sleep(1000);
				velocitatLabel.setText((int)coet.getVelocitatActual()+" Km/h");
				for (int iprop=0; iprop<coet.getNumPropulsors(); iprop++) {
					potPropulsorLabels.get(iprop).setText(coet.getPotenciaActual(iprop)+" ");
				}
			}	
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println(" Fallo interrumpido la actualizacion");

		}
	}
	
	private Rocket coet;
	private JLabel nomLabel;
	private JLabel velocitatLabel;
	private ArrayList<JLabel> potPropulsorLabels;
}
