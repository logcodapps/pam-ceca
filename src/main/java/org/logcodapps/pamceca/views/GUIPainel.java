package org.logcodapps.pamceca.views;

import java.io.IOException;

import com.gluonhq.charm.glisten.mvc.View;

import javafx.fxml.FXMLLoader;

public class GUIPainel {
	
	public View getView() {
		try {
			View view = FXMLLoader.load(PrimaryView.class.getResource("Gui-Painel.fxml"));
			return view;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
			return new View();
		}
	}
}
