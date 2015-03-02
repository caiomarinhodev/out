package models;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

@Entity(name = "Evento")
public class Evento {

    @ManyToOne
    @JoinColumn(name="idCreator")
	private Creator creator;

    @ManyToMany(cascade = CascadeType.ALL)
	private List<Atleta> participantes;

	private int hasAbsoluto;
	
	@Id
    @GeneratedValue
	private Long idEvento;
	
	private String nomeEvento, urlImage;
	
	public Evento() {
		// TODO Auto-generated constructor stub
	}

	public Evento(Creator creator, int hasAbsoluto, String nomeEvento,
			String urlImage) {
		super();
		this.creator = creator;
		this.hasAbsoluto = hasAbsoluto;
		this.nomeEvento = nomeEvento;
		this.urlImage = urlImage;
		this.participantes = new ArrayList<Atleta>();
		
	}
	
	public boolean isParticipante(Usuario u){
		for (Usuario a : participantes) {
			if(a.getID()==u.getID()){
				return true;
			}
		}return false;
	}
	
	public boolean isParticipante(Atleta a){
		for (Atleta atleta : participantes) {
			if(atleta.getID()==a.getID()){
				return true;
			}
		}
		return false;
	}
	
	public Atleta pesquisaAtleta(Atleta a){
		for (Atleta atleta : participantes) {
			if(atleta.getID()==a.getID()){
				return atleta;
			}
		}return null;
	}
	
	public Usuario pesquisaUsuario(Usuario u){
		for (Usuario a : participantes) {
			if(a.getID() == u.getID()){
				return a;
			}
		}
		return null;
	}
	
	public void addAtleta(Atleta a){
		this.participantes.add(a);
	}
	
	public void addAtleta(String nome, String email, String telefone, String academia,
			int faixa, int peso, int idad, int categoria, int sexo, String log, String sen,
			int tipoLog, boolean isabs){
		Atleta a = new Atleta(nome, email, telefone, academia, faixa, peso, idad,
				categoria, sexo, log, sen, tipoLog, isabs);
		this.participantes.add(a);
	}
	
	public void removeAtleta(Atleta a){
		this.participantes.remove(a);
	}

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public List<Atleta> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Atleta> participantes) {
		this.participantes = participantes;
	}

	public int getHasAbsoluto() {
		return hasAbsoluto;
	}

	public void setHasAbsoluto(int hasAbsoluto) {
		this.hasAbsoluto = hasAbsoluto;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result
				+ ((nomeEvento == null) ? 0 : nomeEvento.hashCode());
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
		Evento other = (Evento) obj;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (nomeEvento == null) {
			if (other.nomeEvento != null)
				return false;
		} else if (!nomeEvento.equals(other.nomeEvento))
			return false;
		return true;
	}
	
	
	
	
	
	

}
