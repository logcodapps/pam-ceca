package org.logcodapps.pamceca.views;

import org.logcodapps.pamceca.PamCesa;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PrimaryPresenter {

    private static final String SECONDARY_VIEW=null;

	@FXML
    private View primary;

    @FXML
    private Label label;
    
    @FXML
    private ImageView fotoTexto;
    
    
  
    public void initialize() {
        primary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("TELA PRINCIPAL");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> 
                        System.out.println("Buscar info")));
            }
        });
      
    }
    
    @FXML
    void buttonClick() {
    	PamCesa.getInstance().switchView(PamCesa.SECONDARY_VIEW);
    }
    
}
