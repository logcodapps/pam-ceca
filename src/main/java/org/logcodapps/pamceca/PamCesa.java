package org.logcodapps.pamceca;

import org.logcodapps.pamceca.views.GUIPainel;
import org.logcodapps.pamceca.views.PrimaryView;
import org.logcodapps.pamceca.views.RegistreView;
import org.logcodapps.pamceca.views.SecondaryView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.license.License;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
@License(key="ce140ee3-627f-4b95-ab04-78df0a8f1e3f")
public class PamCesa extends MobileApplication {

    public static final String PRIMARY_VIEW = HOME_VIEW;
    public static final String SECONDARY_VIEW = "Secondary View";
    public static final String REGISTRE_SE = "Registre se";
    public static final String GUI_PAINEL = "GUI PAINEL";
    
    @Override
    public void init() {
        addViewFactory(PRIMARY_VIEW, () -> new PrimaryView().getView());
        addViewFactory(SECONDARY_VIEW, () -> new SecondaryView().getView());
        addViewFactory(GUI_PAINEL, () -> new GUIPainel().getView());
        addViewFactory(REGISTRE_SE, () -> new RegistreView().getView());
        DrawerManager.buildDrawer(this);
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);         
        scene.getStylesheets().add(PamCesa.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(PamCesa.class.getResourceAsStream("/icon.png")));
        setTitle("PAM-CECA");
    }

    public static void main(String args[]) {
        launch(args);
    }
}
