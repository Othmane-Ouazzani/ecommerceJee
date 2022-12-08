package Servlets;

import businessLayer.ClientManager;
import businessLayer.CommandeAchatManager;
import businessLayer.ProduitManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Achat;
import models.Client;
import models.Commande;
import models.Produit;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseUnsignedInt;

@WebServlet(name = "Servlet", value = {"/index"})
public class MainServlet extends HttpServlet {
    ClientManager cm=new ClientManager();
    ProduitManager pm=new ProduitManager();
    CommandeAchatManager cam=new CommandeAchatManager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Produit> listeProduit = pm.getAllProduits();
        ArrayList<Client> listeClient = cm.getAllClients();
        ArrayList<Commande> listeCommande = cam.getCommandesNonLivree();
        ArrayList<Achat> listeAchat = cam.getAchats();

        request.setAttribute("listeProduit",listeProduit);
        request.setAttribute("listeClient",listeClient);
        request.setAttribute("listeCommande",listeCommande);
        request.setAttribute("listeAchat",listeAchat);

            String whichPage = "";

            try {
                whichPage = request.getParameter("page");
            } catch (Exception e) {

                whichPage = "";
            }
            if (whichPage != null)
                switch (whichPage) {
                    case "logout":{
                        request.getSession().invalidate();
                        request.getRequestDispatcher("login.jsp").forward(request,response);
                        break;
                    }
                    case "dashboard":{
                        request.getRequestDispatcher("dashboard.jsp").forward(request,response);
                        break;
                    }
                    case "register": {
                        request.getRequestDispatcher("register.jsp").forward(request, response);
                        break;
                    }case "home": {
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                        break;
                    }
                    case "gestClient":{
                        request.getRequestDispatcher("gestionUser.jsp").forward(request, response);
                        break;
                    }
                    case "gestProduit":{
                        request.getRequestDispatcher("gestionProduit.jsp").forward(request, response);
                        break;
                    }
                    case "gestAchat":{
                        request.getRequestDispatcher("gestionAchat.jsp").forward(request, response);
                        break;
                    }
                    case "": {
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        break;
                    }
                    case "panier": {
                        request.getRequestDispatcher("panier.jsp").forward(request,response);
                        break;
                    }
                    case "shop": {
                        goToShopByCat(request, response);
                        break;
                    }
                    case "detail": {
                        getDetailProduct(request, response);
                        break;
                    }
                }
            else {
                String cCategory = "";
                String cProduit="";
                try {
                    cCategory = request.getParameter("cCategory");
                    cProduit=request.getParameter("cProduit");
                } catch (Exception e) {
                    cCategory = "";
                    cProduit="";
                }
                if (cCategory != null && cProduit != null) {

                    addToCart(request,response);

                    if (cCategory.equals("ordPort")) response.sendRedirect(request.getContextPath() + "/index?page=shop&category=ordPort");
                    if (cCategory.equals("ordBureau")) response.sendRedirect(request.getContextPath() + "/index?page=shop&category=ordBureau");
                    if (cCategory.equals("audioSon")) response.sendRedirect(request.getContextPath() + "/index?page=shop&category=audioSon");
                    if (cCategory.equals("consoles")) response.sendRedirect(request.getContextPath() + "/index?page=shop&category=consoles");
                    if (cCategory.equals("tele")) response.sendRedirect(request.getContextPath() + "/index?page=shop&category=tele");
                    if (cCategory.equals("accInfo")) response.sendRedirect(request.getContextPath() + "/index?page=shop&category=accInfo");

                } else {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }

    }

    private void getDetailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        String prodId = request.getParameter("prod");
        Client client = (Client) request.getSession().getAttribute("client");
        String clientId = client.getLogin();
        int isExistRecentCookie = 0;
        for (Cookie c: cookies) {
            if(c.getName().equals("recent")) {
                isExistRecentCookie = 1;
                String valueCookie = c.getValue();
                int isValueExists = 0;
                String[] cookiesValue = c.getValue().split("-");
                for (String s: cookiesValue) {
                    if(s.equals(prodId+"/"+clientId)) {
                        isValueExists = 1;
                    }
                }
                if(isValueExists == 0) {
                    valueCookie = valueCookie + "-"+prodId+"/"+clientId;
                    Cookie cookie = new Cookie("recent", valueCookie);
                    cookie.setMaxAge(604800);
                    response.addCookie(cookie);
                }
            }
        }
        if(isExistRecentCookie == 0) {
            Cookie cookie = new Cookie("recent", prodId+"/"+clientId);
            response.addCookie(cookie);
        }

        Produit produit = pm.getProduitById(prodId);
        ArrayList<Produit> listeProduit = pm.getAllProduits();
        request.setAttribute("produit", produit);
        request.setAttribute("listeProduit", listeProduit);
        request.getRequestDispatcher("detailProduct.jsp").forward(request, response);
    }

    private void goToShopByCat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categorie = request.getParameter("category");
        ArrayList<Produit> produitByCat =  pm.getProduitsByCat(categorie);
        request.setAttribute("produitByCat", produitByCat);
//        ArrayList<Produit> listeProduit = pm.getAllProduits();
//        request.setAttribute("listeProduit", listeProduit);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        System.out.println(type);

        switch (type){
            case "register":register(request,response);break;
            case "login":login(request,response);break;
            case "addUser":addUser(request, response);break;
            case "deleteClient":deleteClient(request,response);break;
            case "editClient":editClient(request, response);break;
            case "deleteProduit":deleteProduit(request,response);break;
            case "addProduit":addProduit(request, response);break;
            case "editProduit":editProduit(request, response);break;
            case "livrerCommande":livrerCommande(request, response);break;
            default:
        }
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String nom = request.getParameter("lname");
        String prenom = request.getParameter("fname");
        String num = request.getParameter("num");
        if (cm.isClientExist(email)==0) {
            if (password.equals(cpassword) && cm.getClient(email) == null) {
                Client client = new Client(email, password, nom, prenom, num);
                cm.addClient(client);
                request.setAttribute("successRegister","Successful registration");
                ArrayList<Client> listeClient = cm.getAllClients();
                request.setAttribute("listeClient",listeClient);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("failedRegister","Email already exists!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }


    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Client client = cm.getClient(email);
        if(client != null && client.getPassword().equals(password)) {

            ArrayList<Produit> listeProduit = pm.getAllProduits();
            request.setAttribute("listeProduit",listeProduit);

            HttpSession userSession = request.getSession();
            userSession.setAttribute("client", client);
            if(client.getLogin().equals("admin@gmail.com")) {
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("ClientNotExist", "Email or password incorrect!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String nom = request.getParameter("lname");
        String prenom = request.getParameter("fname");
        String num = request.getParameter("num");
        if (cm.isClientExist(email)==0) {
            if (password.equals(cpassword) && cm.getClient(email) == null) {
                Client client = new Client(email, password, nom, prenom, num);
                cm.addClient(client);
                ArrayList<Client> listeClient = cm.getAllClients();
                request.setAttribute("listeClient",listeClient);
                request.setAttribute("userAdded","Successful registration");
                request.getRequestDispatcher("gestionUser.jsp").forward(request, response);
            }
        }else{
            ArrayList<Client> listeClient = cm.getAllClients();
            request.setAttribute("listeClient",listeClient);
            request.setAttribute("failedAdding","Email already exists!");
            request.getRequestDispatcher("gestionUser.jsp").forward(request, response);
        }
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cm.deleteClient(request.getParameter("clientEmail"));
        ArrayList<Client> listeClient = cm.getAllClients();
        request.setAttribute("listeClient",listeClient);
        request.getRequestDispatcher("gestionUser.jsp").forward(request, response);
    }

    private void deleteProduit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        pm.deleteProduit(request.getParameter("produitId"));
        ArrayList<Produit> listeProduit = pm.getAllProduits();
        request.setAttribute("listeProduit",listeProduit);
        request.getRequestDispatcher("gestionProduit.jsp").forward(request, response);
    }

    private void addProduit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("Here is addProduit");
        String id = request.getParameter("pid");
        String nom = request.getParameter("pnom");
        String description = request.getParameter("pdescription");
        String qte = request.getParameter("pqte");
        String prix = request.getParameter("pprix");
        String categorie = request.getParameter("pcategorie");
        String image="images/"+request.getParameter("pimage");
        if (pm.isProduitExist(id)==0) {
            System.out.println("doesnt exist");

            System.out.println("not null");
            Produit produit = new Produit(id, nom, description,parseInt(qte),parseFloat(prix) ,categorie,image);
            pm.insertProduit(produit);
            request.setAttribute("produitAdded","Successful product insertion");
            ArrayList<Produit> listeProduit = pm.getAllProduits();
            request.setAttribute("listeProduit",listeProduit);
            request.getRequestDispatcher("gestionProduit.jsp").forward(request, response);

        }else{
            request.setAttribute("PfailedAdding","ID already exists!");
            request.getRequestDispatcher("gestionProduit.jsp").forward(request, response);
        }
    }
    private void editProduit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldId = request.getParameter("oldpid");
        String id = request.getParameter("pid");
        String nom = request.getParameter("pnom");
        String description = request.getParameter("pdes");
        String qte = request.getParameter("pqte");
        String prix = request.getParameter("pprix");
        String categorie = request.getParameter("pcat");
        String image="images/"+request.getParameter("pimage");
        if (pm.isProduitExist(id)==0 || oldId.equals(id)){
            System.out.println("doesnt exist");
            System.out.println(oldId+prix + "  " + qte+id);
            Produit produit = new Produit(id, nom, description,parseInt(qte),parseFloat(prix),categorie,image);
            System.err.println(pm.updateProduit(produit,oldId));
            request.setAttribute("produitUpdated","Successful product update");
            ArrayList<Produit> listeProduit = pm.getAllProduits();
            request.setAttribute("listeProduit",listeProduit);
            request.getRequestDispatcher("gestionProduit.jsp").forward(request, response);

        }else{
            request.setAttribute("PfailedEditing","ID already exists!");
            request.getRequestDispatcher("gestionProduit.jsp").forward(request, response);
        }
    }

    private void editClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("im in edit client");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String nom = request.getParameter("lname");
        String prenom = request.getParameter("fname");
        String num = request.getParameter("num");
        String oldLogin = request.getParameter("oldLogin");

        if (cm.isClientExist(email)==0 || email.equals(oldLogin)) {
            if (password.equals(cpassword)) {
                Client client = new Client(email, password, nom, prenom, num);
                System.out.println("everything is good");
                cm.updateClient(client, oldLogin);
                request.setAttribute("userEdited","Successful Update");
                ArrayList<Client> listeClient = cm.getAllClients();
                request.setAttribute("listeClient",listeClient);
                request.getRequestDispatcher("gestionUser.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("failedUpdating","Email already exists!");
            request.getRequestDispatcher("gestionUser.jsp").forward(request, response);
        }
    }

    public void livrerCommande(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int commandeId = Integer.parseInt(request.getParameter("commandeId"));
        cam.livrerCommande(commandeId);
        ArrayList<Produit> listeProduit = pm.getAllProduits();
        ArrayList<Commande> listeCommande = cam.getCommandesNonLivree();
        ArrayList<Achat> listeAchat = cam.getAchats();

        request.setAttribute("listeProduit",listeProduit);
        request.setAttribute("listeCommande",listeCommande);
        request.setAttribute("listeAchat",listeAchat);

        request.getRequestDispatcher("gestionAchat.jsp").forward(request, response);
    }

    public void addToCart(HttpServletRequest request,HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        String prodId = request.getParameter("cProduit");
        Client client = (Client) request.getSession().getAttribute("client");
        String clientId = client.getLogin();
        int isExistRecentCookie = 0;
        for (Cookie c: cookies) {
            if(c.getName().equals("panier")) {
                isExistRecentCookie = 1;
                String valueCookie = c.getValue();
                int isValueExists = 0;
                String[] cookiesValue = c.getValue().split("-");
                for (String s: cookiesValue) {
                    if(s.equals(prodId+"/"+clientId)) {
                        isValueExists = 1;
                    }
                }
                if(isValueExists == 0) {
                    valueCookie = valueCookie + "-"+prodId+"/"+clientId;
                    Cookie cookie = new Cookie("panier", valueCookie);
                    cookie.setMaxAge(604800);
                    response.addCookie(cookie);
                }
            }
        }
        if(isExistRecentCookie == 0) {
            Cookie cookie = new Cookie("panier", prodId+"/"+clientId);
            response.addCookie(cookie);
        }
    }

}
