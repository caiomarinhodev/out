package models;

import java.util.List;
import javax.persistence.*;
import java.util.ArrayList;

@Entity(name="Atleta")
public class Atleta implements Usuario{
	
	@Id
    @GeneratedValue
	private Long idAtleta;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Evento> eventos;
	
	private String nome,email,telefone,academia, login, senha;
	private int faixa, peso, idade, categoria, sexo, tipoLogin;
	private boolean isAbsoluto;
	
	public Atleta(){
		// TODO Auto-generated constructor stub
	}

    public Atleta(String nome, String email, String telefone, String academia,
                  int faixa, int peso, int idad, int categoria, int sexo, String log, String sen,
                  int tipoLog, boolean isabs){
        this.nome = nome;
        this.eventos = new ArrayList<Evento>();
        this.idade = idad;
        this.isAbsoluto = isabs;
        this.email = email;
        this.telefone = telefone;
        this.academia = academia;
        this.faixa = faixa;
        this.peso = peso;
        this.categoria = categoria;
        this.sexo = sexo;
        this.login = log;
        this.senha = sen;
        this.tipoLogin = tipoLog;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public void addEvento(Evento e){
        this.eventos.add(e);
    }

    public Evento pesquisaEvento(String n){
        for(Evento e: eventos){
            if(e.getNomeEvento().equals(n)){
                return e;
            }
        }
        return null;
    }

    public void removeEvento(Evento e){
        this.eventos.remove(e);
    }

    public Long getId() {
		return idAtleta;
	}

	public void setId(Long id) {
		this.idAtleta = id;
	}
	
	

	public boolean isAbsoluto() {
		return isAbsoluto;
	}

	public void setAbsoluto(boolean isAbsoluto) {
		this.isAbsoluto = isAbsoluto;
	}
	
	

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getAcademia() {
		return academia;
	}

	public void setAcademia(String academia) {
		this.academia = academia;
	}

	public int getFaixa() {
		return faixa;
	}

	public void setFaixa(int faixa) {
		this.faixa = faixa;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((academia == null) ? 0 : academia.hashCode());
		result = prime * result + categoria;
		result = prime * result + faixa;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + peso;
		result = prime * result + sexo;
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
		Atleta other = (Atleta) obj;
		if (academia == null) {
			if (other.academia != null)
				return false;
		} else if (!academia.equals(other.academia))
			return false;
		if (categoria != other.categoria)
			return false;
		if (faixa != other.faixa)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (peso != other.peso)
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
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
		return this.idAtleta;
	}
	
	

}
