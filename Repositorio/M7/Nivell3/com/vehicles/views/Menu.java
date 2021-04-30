package com.vehicles.views;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Menu {
	private String message;
	private int default_number;
	private ArrayList<String> list_options;
	
	public Menu(String message, int default_number) {
		this.message=message;
		this.default_number=default_number-1;
		this.list_options=new ArrayList<String>();
	}
	
	public void addOptionMenu(String message) {
		this.list_options.add(message);
	}
	
	public int showMenu() throws Exception {
		String full_message=this.message+"\n";
		int answer=default_number;
		String answer_str;
		boolean answer_ok=false;
		
		for (int i=0; i<this.list_options.size(); i++) {
			full_message+= (i+1) + ": " + this.list_options.get(i) + "\n";
		}
		
		while (!answer_ok) {
			answer_str=JOptionPane.showInputDialog(full_message);
			if (answer_str==null) return default_number;
			try {
				answer=Integer.parseInt(answer_str);
				answer--;
				if (answer < 0 || answer >= this.list_options.size()) {
					String error_message = "El valor introduït es erroni.\n"
					+ "Cal introduir un número entre 1 y " + this.list_options.size() + "\n";
					System.out.println(error_message);
				} else answer_ok=true;
			} catch (Exception e) {
				String error_message = "El valor introduït es erroni.\n"
						+ "Cal introduir un número entre 1 y " + this.list_options.size() + "\n";
						System.out.println(error_message);
			}
		}
		
		return answer;
	}
	
}
