package models;

public class Commande {

    int num;
    String client;
    String date;
    int livree;

    public Commande(int num, String client, String date, int livree) {
        this.num = num;
        this.client = client;
        this.date = date;
        this.livree = livree;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLivree() { return livree; }

    public void setLivree(int livree) { this.livree = livree; }
}
