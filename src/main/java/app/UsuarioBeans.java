package app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
        String pagina = "";
        if(login.equals("admin") & senha.equals("admin")){
            pagina="dashboard";
        } else {
            pagina="loginMsg";
        }
        return pagina; // Retornar o nome da página que será aberta
    }
    
}
