package businessLayer;

import models.Produit;

import java.util.ArrayList;

public interface interfaceProduit {
    Produit getProduitById(String id);

    ArrayList<Produit> getAllProduits();

    ArrayList<Produit> getProduitsByCat(String categorie);

    int insertProduit(Produit produit);

    int deleteProduit(String id);

    int updateProduit(Produit p, String oldId);
}
