package fr.dawan.app;

import java.util.List;

import fr.dawan.dao.ProduitDao;
import fr.dawan.model.Produit;
import fr.dawan.utils.ConnexionBDD;

public class App {

	public static void main(String[] args) {
		Produit u = new Produit();
		
    	u.setDescription("monDescription");
    	u.setPrix(100);

    	
    	ConnexionBDD cnx = new ConnexionBDD();

    	try {
    		// Insertion
			ProduitDao.inserer(u, cnx.getConnection(), true);
			// Lecture
			List<Produit> resultUsers = ProduitDao.lireTouteLaTableProduit(cnx.getConnection(), true);
			// Modification
			Produit userAModifer = new Produit();
			userAModifer.setId(1);
			userAModifer.setDescription("descriptionmodifiée");
			userAModifer.setPrix(200);

			
	    	ProduitDao.modifier(userAModifer, cnx.getConnection(), true);
			System.out.println(ProduitDao.lireParIdentifiant(7, cnx.getConnection(), true));
			for(Produit user : resultUsers) {
				System.out.println(user.toString());
			}
		
			//Suppression
			ProduitDao.supprimer(1, cnx.getConnection(), true);
    	
    	} catch (Exception e) {
			System.out.println(e.getMessage());
		} // TODO Auto-generated method stub

	}

}
