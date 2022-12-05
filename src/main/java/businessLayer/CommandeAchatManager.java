package businessLayer;

import dataLayer.DataCommandeAchat;
import models.Achat;
import models.Commande;

import java.util.ArrayList;

public class CommandeAchatManager implements interfaceCommandeAchat {

    private final DataCommandeAchat dca = new DataCommandeAchat();

    @Override
    public int AddCommande(Commande c, ArrayList<Achat> listeAchat) {
        return dca.AddCommande(c, listeAchat);
    }

    @Override
    public ArrayList<Commande> getCommandesNonLivree() {
        return dca.getCommandesNonLivree();
    }

    @Override
    public ArrayList<Achat> getAchats() {
        return dca.getAchats();
    }

    public int livrerCommande(int commandeId) {
        return dca.livrerCommande(commandeId);
    }
}
