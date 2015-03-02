import java.util.ArrayList;
import java.util.List;

import models.Admin;

import models.GenericDAO;
import play.*;
import play.db.jpa.JPA;


public class Global extends GlobalSettings {

	private static GenericDAO dao = new GenericDAO();

	@Override
	public void onStart(Application app) {
		Logger.info("inicializada...");

		JPA.withTransaction(new play.libs.F.Callback0() {

			public void invoke() throws Throwable {

				List<Admin> admins = dao.findAllByClassName(Admin.class.getName());

				if(admins.size() == 0) {
                    Logger.info("Estamos sem ADMIN");

					List<Admin> usuarios = new ArrayList<>();
			            // nextLine[] is an array of values from the line
                    Admin a = new Admin("ADMINISTRADOR", "admin@admin.com", "a", "a", 0);
                    usuarios.add(a);
			        for (int i = 0; i < usuarios.size(); i++) {
                        Logger.info("add admin"+i+": "+usuarios.get(i).getNome());
						dao.persist(usuarios.get(i));
					}

				}

			}
		});
	}
	
	public void onStop(Application app) {
		Logger.info("desligada...");
	}

}
