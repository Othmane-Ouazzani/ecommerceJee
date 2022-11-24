package Servlets;

import businessLayer.ClientManager;
import businessLayer.ProduitManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Client;
import models.Produit;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Servlet", value = {"/index"})
public class MainServlet extends HttpServlet {
    ClientManager cm=new ClientManager();
    ProduitManager pm=new ProduitManager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Produit> listeProduit = pm.getAllProduits();
        ArrayList<Client> listeClient = cm.getAllClients();

        request.setAttribute("listeProduit",listeProduit);
        request.setAttribute("listeClient",listeClient);

            String whichPage = "";

            try {
                whichPage = request.getParameter("page");
            } catch (Exception e) {
                whichPage = "";
            }
            if (whichPage != null)
                switch (whichPage) {
                    case "register": {
                        request.getRequestDispatcher("register.jsp").forward(request, response);
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
                    case "": {
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        break;
                    }
                }
            else
                request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");

        switch (type){
            case "register":register(request,response);break;
            case "login":login(request,response);break;
            case "addUser":addUser(request, response);break;
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

            ArrayList<Produit> listeProduit=listeProduit=pm.getAllProduits();
            request.setAttribute("listeProduit",listeProduit);

            HttpSession userSession = request.getSession();
            userSession.setAttribute("client", client);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }else {
            request.setAttribute("ClientNotExist", "Email or password incorrect!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("im in add user ");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String nom = request.getParameter("lname");
        String prenom = request.getParameter("fname");
        String num = request.getParameter("num");
        if (cm.isClientExist(email)==0) {
            System.out.println("doesnt exist");
            if (password.equals(cpassword) && cm.getClient(email) == null) {
                System.out.println("not null");
                Client client = new Client(email, password, nom, prenom, num);
                cm.addClient(client);
                request.setAttribute("userAdded","Successful registration");
                request.getRequestDispatcher("gestionUser.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("failedAdding","Email already exists!");
            request.getRequestDispatcher("gestionUser.jsp").forward(request, response);
        }
    }

}
