package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.RegisterDAO;
import pojo.RegisterInfo;

public class RegisterAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userNameRegister;
	private String passwordRegister;

	// Métodos getters e setters corretamente nomeados
	public String getUserNameRegister() {
		return userNameRegister;
	}

	public void setUserNameRegister(String userNameRegister) {
		this.userNameRegister = userNameRegister;
	}

	public String getPasswordRegister() {
		return passwordRegister;
	}

	public void setPasswordRegister(String passwordRegister) {
		this.passwordRegister = passwordRegister;
	}

	public String execute() {
		String statusCode = "";
		RegisterInfo registerInfo = new RegisterInfo(userNameRegister, passwordRegister);

		if (RegisterDAO.registerUser(registerInfo)) {
			addFieldError("errorRegister", "Registro bem-sucedido! Você pode fazer login agora.");

			statusCode = "success";
		} else {
			addFieldError("errorRegister", "Senha ou Nome de Usuário incorretos");
			statusCode = "input";
		}
		return statusCode;
	}
}
