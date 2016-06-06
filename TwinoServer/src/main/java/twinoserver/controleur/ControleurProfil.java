/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twinoserver.controleur;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import twinoserver.dao.DAOException;
import twinoserver.dao.EvaluerDAO;
import twinoserver.dao.ProfilDAO;
import twinoserver.dao.TacheDAO;
import twinoserver.modele.Profil;
import java.io.*;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import twinoserver.modele.TacheAtom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ControleurProfil", urlPatterns = {"/controleurProfil"})

public class ControleurProfil extends HttpServlet {

    @Resource(name = "jdbc/TwinoServer")

    private DataSource ds;

    /**
     * La méthode principale d'aiguillage.
     *
     * @param request
     * @param response
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     */
    @Override
  
  public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        String action_enchaine = (String) request.getAttribute("action_enchaine");
        if (action_enchaine == null) {
            action_enchaine = "vide";
        }

        TacheDAO tDAO = new TacheDAO(ds);
        ProfilDAO profilDAO = new ProfilDAO(ds);
        EvaluerDAO eDAO = new EvaluerDAO(ds);

        try {
            if (action == null) {
                actionAfficher(request, response, tDAO);
            } else if (action.equals("posteruneannonce")) {
                actionPoster(request, response, profilDAO);
            } else if (action.equals("connexionrecevoirservice")) {
                actionRecevoirservice(request, response, tDAO);
            }else if (action.equals("connexiondonnerservice")) {
                actionDonnerservice(request, response, tDAO);
            }else if (action.equals("justeregarder")) {
                actionJusteregarder(request, response);
            }else if (action_enchaine.equals("modif")) {
                actionModifierProfil(request, response, profilDAO);
            } else if (action.equals("modifierProfil")
                    || action_enchaine.equals("modifierProfil")) {
                actionModifier(request, response, profilDAO);
            } else if (action.equals("inscriptiondonnerservice")) {
                actionInscriptiondonnerservice(request, response, profilDAO);
            }else if (action.equals("inscriptionrecevoirservice")) {
                actionInscriptionrecevoirservice(request, response, profilDAO);
            }else if (action.equals("creerUtilisateurjieshou")) {
                actionCreerUtilisateurjieshou(request, response, profilDAO);
            }else if (action.equals("creerUtilisateurtigong")) {
                actionCreerUtilisateurtigong(request, response, profilDAO);
            } else if (action.equals("menuProfil")
                    || action_enchaine.equals("menuProfil")) {
                actionMenuProfil(request, response, profilDAO);
            } else if (action.equals("consulterProfil")) {
                actionConsulter(request, response, profilDAO, eDAO, tDAO);
            } else if (action.equals("connectera")) {
                actionConnectera(request, response, tDAO, profilDAO);
            } else if (action.equals("logout")) {
                actionLogout(request, response, tDAO);
            } else {
                getServletContext().getRequestDispatcher(
                        "/WEB-INF/controleurErreur.jsp").forward(request, response);
            }
        } catch (DAOException e) {
            request.setAttribute("erreurMessage", e.getMessage());
            getServletContext().getRequestDispatcher(
                    "/WEB-INF/bdErreur.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ControleurProfil.class.getName()).log(
                    Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControleurProfil.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        String action_enchaine = (String) request.getAttribute("action_enchaine");
        if (action_enchaine == null) {
            action_enchaine = "vide";
        }

        TacheDAO tDAO = new TacheDAO(ds);
        ProfilDAO profilDAO = new ProfilDAO(ds);
        EvaluerDAO eDAO = new EvaluerDAO(ds);

 try {
            if (action == null) {
                actionAfficher(request, response, tDAO);
            } else if (action.equals("posteruneannonce")) {
                actionPoster(request, response, profilDAO);
            } else if (action.equals("connexionrecevoirservice")) {
                actionRecevoirservice(request, response, tDAO);
            }else if (action.equals("connexiondonnerservice")) {
                actionDonnerservice(request, response, tDAO);
            }else if (action.equals("justeregarder")) {
                actionJusteregarder(request, response);
            }else if (action_enchaine.equals("modif")) {
                actionModifierProfil(request, response, profilDAO);
            } else if (action.equals("modifierProfil")
                    || action_enchaine.equals("modifierProfil")) {
                actionModifier(request, response, profilDAO);
            } else if (action.equals("inscriptionrecevoirservice")) {
                actionInscriptionrecevoirservice(request, response, profilDAO);
            }else if (action.equals("creerUtilisateurjieshou")) {
                actionCreerUtilisateurjieshou(request, response, profilDAO);
            }else if (action.equals("creerUtilisateurtigong")) {
                actionCreerUtilisateurtigong(request, response, profilDAO);
            } else if (action.equals("menuProfil")
                    || action_enchaine.equals("menuProfil")) {
                actionMenuProfil(request, response, profilDAO);
            } else if (action.equals("consulterProfil")) {
                actionConsulter(request, response, profilDAO, eDAO, tDAO);
            } else if (action.equals("connectera")) {
                actionConnectera(request, response, tDAO, profilDAO);
            } else if (action.equals("logout")) {
                actionLogout(request, response, tDAO);
            } else {
                getServletContext().getRequestDispatcher(
                        "/WEB-INF/controleurErreur.jsp").forward(request, response);
            }
        } catch (DAOException e) {
            request.setAttribute("erreurMessage", e.getMessage());
            getServletContext().getRequestDispatcher(
                    "/WEB-INF/bdErreur.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ControleurProfil.class.getName()).log(
                    Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControleurProfil.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    /**
     * La page d'accueil
     */
    private void actionAfficher(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tDAO) throws DAOException, ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("utilisateur");
        request.setAttribute("competences", tDAO.getCompetences());
        getServletContext().getRequestDispatcher(
                "/WEB-INF/index.jsp").forward(request, response);

    }

    /**
     * Redirige vers la page qui permet de déposer son annonce Envoie aussi les
     * compétences possibles sur la page
     */
    private void actionPoster(HttpServletRequest request,
            HttpServletResponse response,
            ProfilDAO profilDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        LinkedList<String> competences = profilDAO.getCompetences();
        request.setAttribute("competences", competences);
        HttpSession session = request.getSession(true);
        String utilisateur = (String) session.getAttribute("utilisateur");
        if (utilisateur != null) {
            getServletContext().getRequestDispatcher(
                    "/WEB-INF/deposerAnnonce_1.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher(
                    "/WEB-INF/connexion_1.jsp").forward(request, response);
        }

    }

    /**
     * Modification du profil
     */
    private void actionModifierProfil(HttpServletRequest request,
            HttpServletResponse response,
            ProfilDAO profilDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        float latitudeU = Float.parseFloat((String) request.getAttribute("latitudeT"));
        float longitudeU = Float.parseFloat((String) request.getAttribute("longitudeT"));
        String[] competences = request.getParameterValues("competences");
        profilDAO.modifierProfil(request.getParameter("adresseMail"),
                request.getParameter("mdp"), request.getParameter("nom"),
                request.getParameter("prenom"),
                request.getParameter("dateNaissance"),
                Integer.parseInt(request.getParameter("sexe")),
                latitudeU,
                longitudeU, competences, Integer.parseInt(request.getParameter("telephone")));
        this.actionMenuProfil(request, response, profilDAO);
    }

    /**
     * Redirection vers la page de modification du profil et envoie des infos de
     * l'utilisateur pour l'instant écrit en dur mais à modifier quand on aura
     * les sessions.
     */
    private void actionModifier(HttpServletRequest request,
            HttpServletResponse response,
            ProfilDAO profilDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        LinkedList<String> competencesPossibles = profilDAO.getCompetences();
        LinkedList<String> competencesUtil = profilDAO.getCompetences((String) session.getAttribute("email"));
        LinkedList<String> cP = new LinkedList<String>();

        request.setAttribute("profil", profilDAO.getProfil((String) session.getAttribute("email")));
        request.setAttribute("competencesUtil", competencesUtil);

        for (String s : competencesPossibles) {
            if (!competencesUtil.contains(s)) {
                cP.add(s);
            }
        }
        String adresse = null;
        try {
            adresse = this.actionInverseville(profilDAO.getProfil(
                    (String) session.getAttribute("email")).getLatitudeU(),
                    profilDAO.getProfil(
                            (String) session.getAttribute("email")).getLongitudeU());
        } catch (Exception e) {

        }
        request.setAttribute("adresse", adresse);
        request.setAttribute("competencesPossibles", cP);
        getServletContext().getRequestDispatcher("/WEB-INF/modifierProfil_1.jsp").forward(request, response);
    }

    private String actionInverseville(float latitude, float longitude) throws Exception {
        

        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBGsnFTtPeMHJAKymad5wJd-2DEutP6nko");
        GeocodingResult[] results;
        String adresse = null;
        results = GeocodingApi.newRequest(context).latlng(new LatLng(latitude, longitude)).await(); //.latlng(new LatLng(latitude, longitude)).await();

        System.out.println(results[0].geometry);
        adresse = results[0].formattedAddress;
        return adresse;
    }

    /**
     * Créer son compte
     */
    private void actionInscriptionrecevoirservice(HttpServletRequest request,
            HttpServletResponse response,
            ProfilDAO profilDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        //on envoie les compétences possibles
       // request.setAttribute("competences", profilDAO.getCompetences());
      request.setAttribute("competences", profilDAO.getCompetences());

        getServletContext().getRequestDispatcher(
                "/WEB-INF/inscrirejieshou.jsp").forward(request, response);
    }
    
      /**
     * Créer son compte
     */
    private void actionInscriptiondonnerservice(HttpServletRequest request,
            HttpServletResponse response,
            ProfilDAO profilDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        //on envoie les compétences possibles
      request.setAttribute("competences", profilDAO.getCompetences());
        getServletContext().getRequestDispatcher(
                "/WEB-INF/inscriretigong.jsp").forward(request, response);
    }


    /**
     * Créer un utilisateur
     */
    private void actionCreerUtilisateurjieshou(HttpServletRequest request,
            HttpServletResponse response,
            ProfilDAO profilDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        String adresseMail = request.getParameter("adresseMail");
        String mdp = request.getParameter("mdp");
        String server_password_2 = request.getParameter("server_password_2");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String sexe = request.getParameter("sexe");
        String dateNaissance = request.getParameter("dateNaissance");
        double latitudeU = 0;
        double longitudeU = 0;
        String[] competences = request.getParameterValues("competences");
        String telephone = request.getParameter("telephone");

        request.setAttribute("competences", profilDAO.getCompetences());
        if (competences != null) {
            request.setAttribute("competences_selected", new LinkedList(Arrays.asList(competences)));
        }

        if (adresseMail == null || mdp == null || nom == null || prenom == null
                || sexe == null || dateNaissance == null || server_password_2 == null
                || adresseMail.equals("") || mdp.equals("")
                || server_password_2.equals("") || nom.equals("") || prenom.equals("")
                || dateNaissance.equals("") || sexe.equals("")) {
            request.setAttribute("manquant", "oui");
            getServletContext().getRequestDispatcher("/WEB-INF/inscrirejieshou.jsp").
                    forward(request, response);
        } else if (!mdp.equals(server_password_2)) {
            request.setAttribute("mdp", "oui");
            getServletContext().getRequestDispatcher("/WEB-INF/inscrirejieshou.jsp").
                    forward(request, response);
        } else {
            profilDAO.ajouterUtilisateur(adresseMail, mdp, nom, prenom,
                    Integer.parseInt(sexe),
                    dateNaissance, latitudeU, longitudeU, competences, Integer.parseInt(telephone));
            //TacheDAO tDAO = new TacheDAO(ds);
            
            HttpSession session = request.getSession(true);
        LinkedList<TacheAtom> ta = null;
        String utilisateur = (String) session.getAttribute("utilisateur");
        TacheDAO tDAO = new TacheDAO(ds);
        if (competences == null) {
            ta = tDAO.search(null, "", "", latitudeU, longitudeU, -10, 30, (String) session.getAttribute("email"));
        } else {
            String[] compet = new String[100];
            int k = 0;
            for (String comp : competences) {
                compet[k] = comp;
                k++;
            }
            ta = tDAO.search(compet, "", "", latitudeU, longitudeU, -10, 30, (String) session.getAttribute("email"));
        }
        if (ta.size() == 0) {
            ta = tDAO.search(null, "", "", latitudeU, longitudeU, -10, 100000, (String) session.getAttribute("email"));
        }
        request.setAttribute("tacheAtom", ta);
        request.setAttribute("competences", competences);
            getServletContext().getRequestDispatcher("/WEB-INF/votreProfil.jsp").forward(request, response);
        }
    }

    
       private void actionCreerUtilisateurtigong(HttpServletRequest request,
            HttpServletResponse response,
            ProfilDAO profilDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        String adresseMail = request.getParameter("adresseMail");
        String mdp = request.getParameter("mdp");
        String server_password_2 = request.getParameter("server_password_2");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String sexe = request.getParameter("sexe");
        String dateNaissance = request.getParameter("dateNaissance");
        double latitudeU = 0;
        double longitudeU = 0;
        String[] competences = request.getParameterValues("competences");
        String telephone = request.getParameter("telephone");

        request.setAttribute("competences", profilDAO.getCompetences());
        if (competences != null) {
            request.setAttribute("competences_selected", new LinkedList(Arrays.asList(competences)));
        }

        if (adresseMail == null || mdp == null || nom == null || prenom == null
                || sexe == null || dateNaissance == null || server_password_2 == null
                || adresseMail.equals("") || mdp.equals("")
                || server_password_2.equals("") || nom.equals("") || prenom.equals("")
                || dateNaissance.equals("") || sexe.equals("")) {
            request.setAttribute("manquant", "oui");
            getServletContext().getRequestDispatcher("/WEB-INF/inscrirejieshou.jsp").
                    forward(request, response);
        } else if (!mdp.equals(server_password_2)) {
            request.setAttribute("mdp", "oui");
            getServletContext().getRequestDispatcher("/WEB-INF/inscrirejieshou.jsp").
                    forward(request, response);
        } else {
            profilDAO.ajouterUtilisateur(adresseMail, mdp, nom, prenom,
                    Integer.parseInt(sexe),
                    dateNaissance, latitudeU, longitudeU, competences, Integer.parseInt(telephone));
            //TacheDAO tDAO = new TacheDAO(ds);
            
            HttpSession session = request.getSession(true);
        LinkedList<TacheAtom> ta = null;
        String utilisateur = (String) session.getAttribute("utilisateur");
        TacheDAO tDAO = new TacheDAO(ds);
        if (competences == null) {
            ta = tDAO.search(null, "", "", latitudeU, longitudeU, -10, 30, (String) session.getAttribute("email"));
        } else {
            String[] compet = new String[100];
            int k = 0;
            for (String comp : competences) {
                compet[k] = comp;
                k++;
            }
            ta = tDAO.search(compet, "", "", latitudeU, longitudeU, -10, 30, (String) session.getAttribute("email"));
        }
        if (ta.size() == 0) {
            ta = tDAO.search(null, "", "", latitudeU, longitudeU, -10, 100000, (String) session.getAttribute("email"));
        }
        request.setAttribute("tacheAtom", ta);
        request.setAttribute("competences", competences);
            getServletContext().getRequestDispatcher("/WEB-INF/votreProfil.jsp").forward(request, response);
        }
    }
    /**
     * Redirige vers la page qui permet de menu du profil qui propose de
     * modifier son profil, de voir ses annonces, ses tâches en cours
     * d'exécution,...
     */
    private void actionMenuProfil(HttpServletRequest request,
            HttpServletResponse response,
            ProfilDAO profilDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(true);
        LinkedList<TacheAtom> ta = null;
        String utilisateur = (String) session.getAttribute("utilisateur");
        String check = request.getParameter("action");
        if (utilisateur == null && check.equals("rechercherparville")) {
            session.setAttribute("utilisateur", (request.getParameter("prenom")));
            session.setAttribute("latitude", (String) request.getAttribute("latitudeT"));
            session.setAttribute("longitude", (String) request.getAttribute("longitudeT"));
            session.setAttribute("email", request.getParameter("adresseMail"));
        }
        LinkedList<String> competences = profilDAO.getCompetences((String) session.getAttribute("email"));
        float latitudeU = Float.parseFloat((String) session.getAttribute("latitude"));
        float longitudeU = Float.parseFloat((String) session.getAttribute("longitude"));
        TacheDAO tDAO = new TacheDAO(ds);
        if (competences == null) {
            ta = tDAO.search(null, "", "", latitudeU, longitudeU, -10, 30, (String) session.getAttribute("email"));
        } else {
            String[] compet = new String[100];
            int k = 0;
            for (String comp : competences) {
                compet[k] = comp;
                k++;
            }
            ta = tDAO.search(compet, "", "", latitudeU, longitudeU, -10, 30, (String) session.getAttribute("email"));
        }
        if (ta.size() == 0) {
            ta = tDAO.search(null, "", "", latitudeU, longitudeU, -10, 100000, (String) session.getAttribute("email"));
        }
        request.setAttribute("tacheAtom", ta);
        request.setAttribute("competences", competences);
        getServletContext().getRequestDispatcher("/WEB-INF/votreProfil.jsp").forward(request, response);
    }

    /**
     * Consultation du profile
     */
    private void actionConsulter(HttpServletRequest request,
            HttpServletResponse response, ProfilDAO profilDAO, EvaluerDAO eDAO,
            TacheDAO tDAO) throws DAOException, ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String exec = request.getParameter("ident");
        Profil execProfil = profilDAO.getProfil(exec);
        request.setAttribute("exec", execProfil);
        request.setAttribute("evals", eDAO.getListeEval(exec));
        getServletContext().getRequestDispatcher("/WEB-INF/autreprofil_1.jsp").forward(request, response);
    }

    /**
     * Permet de connecter l'utilisateur s'il a mis les bon login et mdp
     */
    private void actionConnectera(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tDAO, ProfilDAO profilDAO) throws DAOException, ServletException, IOException {
request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("email");
        String password = request.getParameter("mdp");
        String user = "null";
        Profil connexion = profilDAO.verifieconnexion(login, password);

        if (connexion != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("utilisateur", (connexion.getPrenom()));
            session.setAttribute("latitude", String.valueOf(connexion.getLatitudeU()));
            session.setAttribute("longitude", String.valueOf(connexion.getLongitudeU()));
            session.setAttribute("email", login);
            this.actionAfficher(request, response, tDAO);
        } else {
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/WEB-INF/inscrirejieshou.jsp").forward(request, response);
        }

    }

    /**
     * La déconnexion
     */
    private void actionLogout(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tDAO) throws DAOException, ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        session.invalidate();
        this.actionAfficher(request, response, tDAO);
    }
    
        /**
     * La déconnexion
     */
    
    
        /**
     * Se connecter
     */


    private void actionRecevoirservice(HttpServletRequest request,
            HttpServletResponse response ,
            TacheDAO tDAO) throws DAOException, ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        getServletContext().getRequestDispatcher("/WEB-INF/recevoirservice.jsp").forward(request, response);
      
    }
    
        private void actionDonnerservice(HttpServletRequest request,
            HttpServletResponse response ,
            TacheDAO tDAO) throws DAOException, ServletException, IOException {
request.setCharacterEncoding("UTF-8");
        getServletContext().getRequestDispatcher("/WEB-INF/donnerservice.jsp").forward(request, response);
      
    }
        
        
    private void actionJusteregarder(HttpServletRequest request,
            HttpServletResponse response) throws DAOException, ServletException, IOException {
request.setCharacterEncoding("UTF-8");
        getServletContext().getRequestDispatcher("/WEB-INF/recevoirservice.jsp").forward(request, response);
      
    }
    
}
