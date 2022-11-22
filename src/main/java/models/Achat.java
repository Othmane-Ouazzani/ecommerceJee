package models;

public class Achat {

    Produit produit;
    Commande commande;
    int qte;

    public Achat(Produit produit, Commande commande, int qte) {
        this.produit = produit;
        this.commande = commande;
        this.qte = qte;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
