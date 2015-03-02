package models;

public interface Usuario {
	
	public String getLogin();
	public String getSenha();
	public String getNome();
	public void setLogin(String s);
	public void setSenha(String s);
	public void setNome(String s);
	public int getTipoLogin();
	public void setTipoLogin(int tipo);
	public Long getID();

}
