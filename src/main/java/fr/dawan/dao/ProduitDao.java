package fr.dawan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.dawan.model.Produit;
import fr.dawan.model.Produit;



public class ProduitDao {
	
	
	public static int inserer(Produit p, Connection cnx, boolean fermerCnx) throws SQLException {
		// Création de la requête
		String sqlInsertion = "INSERT INTO produit (id, description, prix) VALUES (?,?,?)";

		PreparedStatement ps = cnx.prepareStatement(sqlInsertion);
		ps.setLong(1, p.getId());
		ps.setString(2, p.getDescription());
		ps.setDouble(3, p.getPrix());
		
		int result = ps.executeUpdate();
		
		if(fermerCnx) {
			cnx.close();
		}

		return result;
		
	}
	
	public static List<Produit> lireTouteLaTableProduit(Connection cnx, boolean fermerConnexion) throws SQLException {
		String sql = "SELECT * FROM produit";
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Produit> products = new ArrayList<Produit>();
		
		while(rs.next()) {
			
			Produit product = new Produit();
			product.setDescription(rs.getString("Description"));
			product.setId(rs.getLong("Id"));
			product.setPrix(rs.getDouble("Prix"));
			
			products.add(product);
		}
		
		return products;
		
	}
	
	public static Produit lireParIdentifiant(int id, Connection cnx,boolean fermerConnexion) throws SQLException{
	 String sql= "SELECT * FROM produit WHERE id=?";
	 PreparedStatement ps= cnx.prepareStatement(sql);
	 ps.setLong(1, id);
	 ResultSet rs =ps.executeQuery();
	 rs.next();
	 Produit product = new Produit();
		product.setDescription(rs.getString("Description"));
		product.setId(rs.getLong("Id"));
		product.setPrix(rs.getDouble("Prix"));
		return product;
	 
	 
	}
	
	// Une méthode pour mettre à jour les données
	public static int modifier(Produit product, Connection cnx, boolean fermerConnection) throws SQLException {
		
		String sql = "UPDATE Produit SET Description=?, Prix=? WHERE Id=?";
		
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		ps.setString(1, product.getDescription());
		ps.setDouble(2, product.getPrix());
		ps.setLong(3, product.getId());
		
		int result = ps.executeUpdate();
		
		if(fermerConnection) {
			cnx.close();
		}
		
		return result;
		
	}
	
	// Une méthode pour supprimer les données
	public static int supprimer(int id, Connection cnx, boolean fermerConnection) throws SQLException {
		
		String sql = "DELETE FROM Produit WHERE Id=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		ps.setLong(1, id);
		
		int rs = ps.executeUpdate();
		
		if(fermerConnection) {
			cnx.close();
		}
		
		return rs;
	}
}

