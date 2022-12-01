package dataLayer;

import models.Client;
import models.Commande;
import models.Produit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataCommandeAchat {

    Connexion connexion=new Connexion();

    public ArrayList<Commande> getCommandesNonLivree() {
        ArrayList<Commande> listeCommandeNonLivre = new ArrayList<>();
        try{
            connexion.Connect();
            Statement st=connexion.getCnx().createStatement();
            ResultSet rs=st.executeQuery("SELECT*  FROM  commande  WHERE  livree = 0");
            connexion.Deconnexion();
            if(rs.next()) {
                Commande c = new Commande(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)));
                listeCommandeNonLivre.add(c);
            }
        } catch (SQLException e){e.printStackTrace();}
        return listeCommandeNonLivre;
    }

    public int AddCommande(Commande c, ArrayList<Produit> listeProduit) {
        int isAdded = 0;
        try{
            connexion.Connect();
            Statement st=connexion.getCnx().createStatement();
            String query = "INSERT INTO commande ";
            connexion.Deconnexion();
        } catch (SQLException e){e.printStackTrace();}
        return isAdded;
    }

}
