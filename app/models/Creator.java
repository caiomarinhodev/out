package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Creator")
public class Creator implements Usuario{
	
	private String nome, login, senha, contaCorrente, agencia, nomeBanco, razaoSocial,
					nomePresidente ,email, telefone;
	private int tipoLogin;
	
	@OneToMany(mappedBy = "creator")
	private List<Evento> eventosCriados;

	private double ganhos;
	
	@Id
    @GeneratedValue
	private Long idCreator;
	
	public Creator() {
		// TODO Auto-generated constructor stub
	}

	public Creator(String nome, String login, String senha,
			String contaCorrente, String agencia, String nomeBanco,
			String razaoSocial, String nomePresidente, int tipoLogin, String email, String telefone) {
		super();
        this.email = email;
        this.telefone = telefone;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.contaCorrente = contaCorrente;
		this.agencia = agencia;
		this.nomeBanco = nomeBanco;
		this.razaoSocial = razaoSocial;
		this.nomePresidente = nomePresidente;
		this.tipoLogin = tipoLogin;
		this.ganhos = 0.00;
		this.eventosCriados = new ArrayList<Evento>();
	}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getGanhos() {
		return ganhos;
	}

	public void setGanhos(double ganhos) {
		this.ganhos = ganhos;
	}

	public Long getId() {
		return idCreator;
	}

	public void setId(Long id) {
		this.idCreator = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String nomeFantasia) {
		this.razaoSocial = nomeFantasia;
	}

	public String getNomePresidente() {
		return nomePresidente;
	}

	public void setNomePresidente(String nomePresidente) {
		this.nomePresidente = nomePresidente;
	}

	public int getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(int tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	public List<Evento> getEventosCriados() {
		return eventosCriados;
	}

	public void setEventosCriados(List<Evento> eventosCriados) {
		this.eventosCriados = eventosCriados;
	}

	@Override
	public Long getID() {
		return this.idCreator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result
				+ ((contaCorrente == null) ? 0 : contaCorrente.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((nomeBanco == null) ? 0 : nomeBanco.hashCode());
		result = prime * result
				+ ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result
				+ ((nomePresidente == null) ? 0 : nomePresidente.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + tipoLogin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Creator other = (Creator) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (contaCorrente == null) {
			if (other.contaCorrente != null)
				return false;
		} else if (!contaCorrente.equals(other.contaCorrente))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeBanco == null) {
			if (other.nomeBanco != null)
				return false;
		} else if (!nomeBanco.equals(other.nomeBanco))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (nomePresidente == null) {
			if (other.nomePresidente != null)
				return false;
		} else if (!nomePresidente.equals(other.nomePresidente))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (tipoLogin != other.tipoLogin)
			return false;
		return true;
	}
	
	
	
	
	

}
