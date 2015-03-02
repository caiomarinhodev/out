package models;

import java.util.List;

/**
 * Created by Caio on 28/02/2015.
 */
public class Sistema{

    private List<Creator> creators;
    private List<Atleta> atletas;
    private List<Evento> eventos;

    public Sistema(List<Creator> creators, List<Atleta> atletas, List<Evento> eventos) {
        this.creators = creators;
        this.atletas = atletas;
        this.eventos = eventos;
    }

    public List<Creator> getCreators() {
        return creators;
    }

    public void setCreators(List<Creator> creators) {
        this.creators = creators;
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<Atleta> atletas) {
        this.atletas = atletas;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
