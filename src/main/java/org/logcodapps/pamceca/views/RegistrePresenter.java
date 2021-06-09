package org.logcodapps.pamceca.views;

import java.io.IOException;

import org.logcodapps.pamceca.PamCesa;
import org.logcodapps.pamceca.model.Usuario;
import org.logcodapps.pamceca.retrofit.ConfigRetrofit;
import org.logcodapps.pamceca.util.Utilits;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.control.TextField;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import retrofit2.Call;
import retrofit2.Response;

public class RegistrePresenter {

	@FXML
	private View registre;
	@FXML
	private TextField tfNome;
	@FXML
	private TextField tfContato;
	@FXML
	private TextField tfLogin;
	@FXML
	private TextField tfSenha;
	@FXML
	private Hyperlink hlLogin;
	@FXML
	private Label lbMsg;

	public void initialize() {
		registre.setShowTransitionFactory(BounceInRightTransition::new);

		FloatingActionButton fab = new FloatingActionButton(MaterialDesignIcon.INFO.text,
				e -> System.out.println("Evento aqui"));
		fab.showOn(registre);

		registre.showingProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue) {
				AppBar appBar = MobileApplication.getInstance().getAppBar();
				appBar.setNavIcon(
						MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().getDrawer().open()));
				appBar.setTitleText("Registre-se");
				appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e -> System.out.println("Favorite")));
			}
		});
		// eventoHyperLink();

	}

	protected String msg = "Usuario já foi cadastrado.";
	protected String color = "red";

	@FXML
	public void valueAction(ActionEvent evt) throws IOException {

		String nome = tfNome.getText();
		String contato = tfContato.getText();
		String login = tfLogin.getText();
		String senha = tfSenha.getText();
		Usuario usuario = new Usuario(0, nome, contato, login, senha, false);
		Call<Usuario> call = new ConfigRetrofit()
				.usuarioService()
				.enviarUsuario(usuario);

		Response<Usuario> response = call.execute();
		if (response.isSuccessful()) {
			usuario = response.body();
			color = "green";
			msg = "Enviado com sucesso " + usuario.getNome();
		}

		lbMsg.setText(msg);
		lbMsg.setTextFill(Paint.valueOf(color));
		Utilits.animateMessage(lbMsg);
	}

	@FXML
	public void eventoHyperLink(ActionEvent evt) {
		PamCesa.getInstance().switchView(PamCesa.SECONDARY_VIEW);

	}
}
