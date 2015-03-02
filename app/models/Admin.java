package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Admin")
public class Admin implements Usuario{

	@Id
    @GeneratedValue
	private Long idAdmin;

	private String nome,email,login, senha;
	private int tipoLogin;

	public Admin(){
		// TODO Auto-generated constructor stub
	}

    public Admin(String nome, String email,String log, String sen,
                 int tipoLog){
        this.nome = nome;
        this.email = email;
        this.login = log;
        this.senha = sen;
        this.tipoLogin = tipoLog;
    }




	public Long getId() {
		return idAdmin;
	}

	public void setId(Long id) {
		this.idAdmin = id;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String getLogin() {
		return this.login;
	}

	@Override
	public String getSenha() {
		return this.senha;
	}

	@Override
	public void setLogin(String s) {
		this.login = s;
	}

	@Override
	public void setSenha(String s) {
		this.senha = s;
	}

	@Override
	public int getTipoLogin() {
		return this.tipoLogin;
	}

	@Override
	public void setTipoLogin(int tipo) {
		this.tipoLogin = tipo;
	}

	@Override
	public Long getID() {
		return this.idAdmin;
	}
	
	

}
