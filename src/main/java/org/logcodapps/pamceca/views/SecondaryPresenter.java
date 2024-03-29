package org.logcodapps.pamceca.views;

import java.io.IOException;

import org.logcodapps.pamceca.PamCesa;
import org.logcodapps.pamceca.model.Usuario;
import org.logcodapps.pamceca.retrofit.ConfigRetrofit;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.control.TextField;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import lombok.Data;
import retrofit2.Call;
import retrofit2.Response;

@Data
public class SecondaryPresenter {

	@FXML
	private View secondary;
	@FXML
	private TextField fieldUser;
	@FXML
	private PasswordField fieldPasswd;
	@FXML
	private Label lbMsg;

	public void initialize() {
		secondary.setShowTransitionFactory(BounceInRightTransition::new);

		FloatingActionButton fab = new FloatingActionButton(MaterialDesignIcon.INFO.text,
				e -> System.out.println("Evento aqui"));
		fab.showOn(secondary);

		secondary.showingProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue) {
				AppBar appBar = MobileApplication.getInstance().getAppBar();
				appBar.setNavIcon(
						MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().getDrawer().open()));
				appBar.setTitleText("Autenticação do Usuário");
				appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e -> System.out.println("Favorite")));
			}
		});

	}

	
	@FXML
	public void valueAction(ActionEvent event) throws IOException {
		String login = fieldUser.getText();
		String senha = fieldPasswd.getText();
		Call<Usuario> logado = new ConfigRetrofit().usuarioService().usuarioLogado(login);
		Usuario usuario = new Usuario();
		Response<Usuario> response = logado.execute();
		if (response.isSuccessful()) {
			usuario = response.body();
			PamCesa.getInstance().switchView(PamCesa.GUI_PAINEL);
		}
		System.out.println(usuario);

	}

	@FXML
	public void eventHyperLink(ActionEvent evt) {
		PamCesa.getInstance().switchView(PamCesa.REGISTRE_SE);
	}

}
