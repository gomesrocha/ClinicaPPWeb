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
    private String login, senha, nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String salvar(){
        return "dashboard";
    }
    
    
}
