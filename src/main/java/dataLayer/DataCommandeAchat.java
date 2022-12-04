package dataLayer;

import models.Achat;
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

    public int AddCommande(Commande c, ArrayList<Achat> listeAchat) {
        int isAdded = 0;
        try{
            connexion.Connect();
            Statement st=connexion.getCnx().createStatement();
            String query = "INSERT INTO commande(client, date) VALUES("+c.getClient()+", "+c.getDate()+")";
            isAdded = st.executeUpdate(query);
            ResultSet lastInsertedId = st.executeQuery("SELECT LAST_INSERT_ID()");
            lastInsertedId.next();
            for (int i = 0; i<listeAchat.size(); i++) {
                String queryAchat = "INSERT INTO achat VALUES ('"+listeAchat.get(i).getProduit()+"', "+lastInsertedId.getString(1)+", "+listeAchat.get(i).getQte()+")";
                st.executeUpdate(queryAchat);
            }
            connexion.Deconnexion();
        } catch (SQLException e){e.printStackTrace();}
        return isAdded;
    }

    public ArrayList<Achat> getAchats() {
        ArrayList<Achat> listeAchat=new ArrayList<Achat>();
        try{
            connexion.Connect();
            Statement st=connexion.getCnx().createStatement();
            ResultSet rs=st.executeQuery("SELECT *  FROM  achat ;");
            connexion.Deconnexion();
            while(rs.next()){
                listeAchat.add(new Achat(rs.getString(1), Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(3))));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listeAchat;
    }

}
