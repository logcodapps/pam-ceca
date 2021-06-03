package org.logcodapps.pamceca.views;

import org.logcodapps.pamceca.config.DataSourceConfigFactory;
import org.logcodapps.pamceca.config.UsuarioSistema;
import org.logcodapps.pamceca.model.Usuario;
import org.logcodapps.pamceca.repository.UsuarioRepository;
import org.logcodapps.pamceca.service.UsuarioService;

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
				e -> System.out.println("Evento ocorrendo menu"));
		fab.showOn(secondary);

		secondary.showingProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue) {
				AppBar appBar = MobileApplication.getInstance().getAppBar();
				appBar.setNavIcon(
						MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().getDrawer().open()));
				appBar.setTitleText("Autenticação do Usuaŕio");
				appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e -> System.out.println("Favorite")));
			}
		});

	}

	UsuarioService service = new UsuarioService(
			new UsuarioRepository(
					new DataSourceConfigFactory(
							new UsuarioSistema())));

	@FXML
	public void valueAction(ActionEvent event) {
		String login = fieldUser.getText();
		String senha = fieldPasswd.getText();
		try {
			Usuario usuario = new Usuario();
			usuario.setLogado(service.virificacaoUsuario(login, senha));
			if (usuario.isLogado()) {
				usuario.setLogin(login);
			  
				System.out.println("Usuário: " + login + " Senha: " + senha);
			}else {
				lbMsg.setText("Login ou senha invalidos.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
