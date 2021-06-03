package org.logcodapps.pamceca;

import com.gluonhq.attach.lifecycle.LifecycleService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.attach.util.Services;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.application.ViewStackPolicy;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.control.NavigationDrawer.ViewItem;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.image.Image;

import static org.logcodapps.pamceca.PamCesa.PRIMARY_VIEW;
import static org.logcodapps.pamceca.PamCesa.SECONDARY_VIEW;

public class DrawerManager {

    public static void buildDrawer(MobileApplication app) {
        NavigationDrawer drawer = app.getDrawer();
       
        NavigationDrawer.Header header = new NavigationDrawer.Header("PLATAFORMA PAM-CECA",
                "COLEGIO ESTADUAL CASTRO ALVES DE ACUPE",
                new Avatar(21, new Image(DrawerManager.class.getResourceAsStream("/icon.png"))));
        drawer.setHeader(header);
        
        final Item primaryItem = new ViewItem("Tela Inicial", MaterialDesignIcon.HOME.graphic(), PRIMARY_VIEW, ViewStackPolicy.SKIP);
        final Item secondaryItem = new ViewItem("Login do Usuário", MaterialDesignIcon.PEOPLE.graphic(), SECONDARY_VIEW);
        drawer.getItems().addAll(primaryItem, secondaryItem);
        
        if (Platform.isDesktop()) {
            final Item quitItem = new Item("Quit", MaterialDesignIcon.EXIT_TO_APP.graphic());
            quitItem.selectedProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                }
            });
            drawer.getItems().add(quitItem);
        }
    }
}