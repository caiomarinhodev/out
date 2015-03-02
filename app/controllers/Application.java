package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.*;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	private static GenericDAO dao = new GenericDAO();
    private static Sistema sistema = null;

	@Transactional
    public static Result login(){

        return ok(login.render("Log in"));
    }

    @Transactional
    public static Result auth() {
        List<Admin> admins = dao.findAllByClassName(Admin.class.getName());
        List<Creator> creators = dao.findAllByClassName(Creator.class.getName());
        List<Atleta> atletas = dao.findAllByClassName(Atleta.class.getName());
        List<Evento> eventos = dao.findAllByClassName(Evento.class.getName());

        Admin ad=null;
        Creator cr=null;
        Atleta at=null;

        DynamicForm requestData = Form.form().bindFromRequest();
        String l = requestData.get("login");
        String s = requestData.get("senha");
        for(Creator c: creators){
            if(c.getLogin().equals(l) && c.getSenha().equals(s)){
                cr = c;
            }
        }
        for(Atleta a: atletas){
            if(a.getLogin().equals(l) && a.getSenha().equals(s)){
                at = a;
            }
        }
        for(Admin admin: admins){
            if(admin.getLogin().equals(l) && admin.getSenha().equals(s)){
                ad = admin;
            }
        }
        
        if(ad!=null){
        	sistema = new Sistema(creators,atletas,eventos);
            return ok(dash.render("Nosso Tatame", sistema, ad));
        }else if(cr!=null){
        	sistema = new Sistema(creators,atletas,eventos);
            return ok(dash.render("Nosso Tatame", sistema, cr));
        }else if(at!=null){
        	sistema = new Sistema(creators,atletas,eventos);
            return ok(dash.render("Nosso Tatame", sistema, at));
        }else{
            return ok(login.render("Login"));
        }
    }

    @Transactional
    public static Result register(){
        return ok(register.render("Register"));
    }

    @Transactional
    public static Result cadastraUsuario(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String nome, login, senha, email;
        int tipoLogin = getTipoLogin(requestData.get("tipologin"));
        nome = requestData.get("nome");
        login = requestData.get("login");
        senha = requestData.get("senha");
        email = requestData.get("email");
        createUsuario(tipoLogin,nome,login,senha,email);
        return ok(views.html.login.render("Log in"));
    }

    @Transactional
    private static void createUsuario(int t, String nome, String login,
                                     String senha, String email){
        if(t==1){
            Creator c = new Creator(nome,login,senha,null,null,null,null,null,t,email,null);
            dao.persist(c);
        }else{
            Atleta a = new Atleta(nome,email,null,null,0,0,0,0,0,login,senha,t,false);
            dao.persist(a);
        }
    }

    private static int getTipoLogin(String t){
        if(t.equals("Atleta")){
            return 2;
        }else{
            return 1;
        }
    }

    @Transactional
    public static Creator pesquisaUsuario(String l){
        List<Creator> atletas = dao.findAllByClassName(Creator.class.getName());

        if(!atletas.isEmpty()){
            for (Creator u: atletas){
                if(u.getLogin().equals(l)){
                    return u;
                }
            }
        }

        return null;
    }
}
