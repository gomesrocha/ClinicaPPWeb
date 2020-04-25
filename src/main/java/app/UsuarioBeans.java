package app;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fabio Gomes Rocha
 */
@ManagedBean
@SessionScoped
public class UsuarioBeans {

    private String login, senha;
    public UsuarioBeans() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String logarSistema(){
        FacesContext context = FacesContext.getCurrentInstance();
        String pagina = "";
        if(login.equals("admin") & senha.equals("admin")){
            pagina="dashboard";
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Usuário ou senha incorreto!", ""));
            //pagina="loginMsg";
        }
        return pagina; // Retornar o nome da página que será aberta
    }
    
}
