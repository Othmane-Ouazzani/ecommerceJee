package models;

public class Commande {

    int num;
    Client client;
    String date;

    public Commande(int num, Client client, String date) {
        this.num = num;
        this.client = client;
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
