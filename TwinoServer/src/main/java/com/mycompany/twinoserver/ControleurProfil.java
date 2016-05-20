/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twinoserver;


import com.mycompany.twinoserver.dao.DAOException;
import com.mycompany.twinoserver.dao.EvaluerDAO;
import com.mycompany.twinoserver.dao.ProfilDAO;
import com.mycompany.twinoserver.dao.TacheDAO;
import com.mycompany.twinoserver.modele.Profil;
import java.io.*;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import com.mycompany.twinoserver.modele.TacheAtom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ControleurProfil", urlPatterns = {"/controleurProfil"})

public class ControleurProfil extends HttpServlet {

    @Resource(name = "jdbc/crowdsourcing_equipe2")

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
            } else if (action_enchaine.equals("modif")) {
                actionModifierProfil(request, response, profilDAO);
            } else if (action.equals("modifierProfil")
                    || action_enchaine.equals("modifierProfil")) {
                actionModifier(request, response, profilDAO);
            } else if (action.equals("inscription")) {
                actionInscription(request, response, profilDAO);
            } else if (action.equals("connexion")) {
                actionConnexion(request, response, tDAO);
            } else if (action.equals("creerUtilisateur")
                    || action_enchaine.equals("creerUtilisateur")) {
                actionCreerUtilisateur(request, response, profilDAO);
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
            } else if (action_enchaine.equals("modif")) {
                actionModifierProfil(request, response, profilDAO);
            } else if (action.equals("modifierProfil")
                    || action_enchaine.equals("modifierProfil")) {
                actionModifier(request, response, profilDAO);
            } else if (action.equals("inscription")) {
                actionInscription(request, response, profilDAO);
            } else if (action.equals("connexion")) {
                actionConnexion(request, response, tDAO);
            } else if (action.equals("creerUtilisateur")
                    || action_enchaine.equals("creerUtilisateur")) {
                actionCreerUtilisateur(request, response, profilDAO);
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

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("utilisateur");
        request.setAttribute("competences", tDAO.getCompetences());
        getServletContext().getRequestDispatcher(
                "/WEB-INF/Accueil_1.jsp").forward(request, response);

    }

    /**
     * Redirige vers la page qui permet de déposer son annonce Envoie aussi les
     * compétences possibles sur la page
     */
    private void actionPoster(HttpServletRequest request,
            HttpServletResponse response,
            ProfilDAO profilDAO)
            throws IOException, ServletException, DAOException {

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
        float latitudeU = Float.parseFloat((String) request.getAttribute("latitudeT"));
        float longitudeU = Float.parseFloat((String) request.getAttribute("longitudeT"));
        String[] competences = request.getParameterValues("competences");
        profilDAO.modifierProfil(request.getParameter("adresseMail"),
                request.getParameter("mdp"), request.getParameter("nom"),
                request.getParameter("prenom"),
                request.getParameter("dateNaissance"),
                Integer.parseInt(request.getParameter("sexe")),
                latitudeU,
                longitudeU, competences);
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
