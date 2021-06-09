package org.logcodapps.pamceca.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

public class GuiPainelPresente {
    
	@FXML
	private View guiPainel;
	@FXML
	private Hyperlink hlJogos;
	@FXML
	private Hyperlink hlAtividades;
	@FXML
	private Hyperlink hlSimulados;
	@FXML
	private Hyperlink hlVideos;
	
	public void initialize() {
		guiPainel.setShowTransitionFactory(BounceInRightTransition::new);

		FloatingActionButton fab = new FloatingActionButton(MaterialDesignIcon.INFO.text,
				e -> System.out.println("Evento ocorrendo menu"));
		fab.showOn(guiPainel);

		guiPainel.showingProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue) {
				AppBar appBar = MobileApplication.getInstance().getAppBar();
				appBar.setNavIcon(
						MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().getDrawer().open()));
				appBar.setTitleText("PAINEL DE OPÇÕES");
				appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e -> System.out.println("Favorite")));
			}
		});

	}
    
}
