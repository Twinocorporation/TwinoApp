/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twinoserver;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.google.maps.model.LatLng; 
import com.mycompany.twinoserver.dao.DAOException;
import com.mycompany.twinoserver.dao.EvaluerDAO;
import com.mycompany.twinoserver2.dao.TacheDAO;
import java.io.*;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import com.mycompany.twinoserver.modele.TacheAtom;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ControleurTache", urlPatterns = {"/controleurTache"})

public class ControleurTache extends HttpServlet {

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
        EvaluerDAO eDAO = new EvaluerDAO(ds);

        try {
            if (action == null || action.equals("accueil")) {
                actionAfficher(request, response, tDAO);
            } else if (action.equals("mesTaches")
                    || action_enchaine.equals("mesTaches")) {
                actionMesTaches(request, response, tDAO);
            } else if (action.equals("mesAnnonces")) {
                actionMesAnnonces(request, response, tDAO);
            } else if (action.equals("historique")) {
                actionHistorique(request, response, tDAO);
            } else if (action.equals("rechercher")) {
                actionRechercher(request, response, tDAO);
            } else if (action.equals("annonce")) {
                actionDeposerAnnonce(request, response, tDAO);
            } else if (action.equals("gestionAnnonce")) {
                actionGestionAnnonce(request, response, tDAO);
            } else if (action_enchaine.equals("modifAnnonce")) {
                actionModifAnnonce(request, response, tDAO);
            } else if (action.equals("searchAnnonces")) {
                actionSearchAnnonce(request, response, tDAO);
            } else if (action.equals("searchAnnonceSuite")) {
                actionSearchAnnonceSuite(request, response, tDAO);
            } else if (action.equals("gestionMesTaches")) {
                actionGestionMesTaches(request, response, tDAO);
            } else if (action.equals("supprimerTache")) {
                actionSupprimerTache(request, response, tDAO);
            } else if (action.equals("annulerTache")) {
                actionAnnulerTache(request, response, tDAO);
            } else if (action.equals("evaluer")) {
                actionEvaluer(request, response, eDAO, tDAO);
            } else if (action.equals("rechercherparville")) {
                actionRechercherparville(request, response, tDAO);
            } else {
                getServletContext().getRequestDispatcher(
                        "/WEB-INF/controleurErreur.jsp").forward(request,
                                response);
            }
        } catch (DAOException e) {
            request.setAttribute("erreurMessage", e.getMessage());
            getServletContext().getRequestDispatcher(
                    "/WEB-INF/bdErreur.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControleurTache.class.getName()).log(
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
        EvaluerDAO eDAO = new EvaluerDAO(ds);

        try {
            if (action == null || action.equals("accueil")) {
                actionAfficher(request, response, tDAO);
            } else if (action.equals("mesTaches")
                    || action_enchaine.equals("mesTaches")) {
                actionMesTaches(request, response, tDAO);
            } else if (action.equals("mesAnnonces")) {
                actionMesAnnonces(request, response, tDAO);
            } else if (action.equals("historique")) {
                actionHistorique(request, response, tDAO);
            } else if (action.equals("rechercher")) {
                actionRechercher(request, response, tDAO);
            } else if (action.equals("annonce")) {
                actionDeposerAnnonce(request, response, tDAO);
            } else if (action.equals("gestionAnnonce")) {
                actionGestionAnnonce(request, response, tDAO);
            } else if (action_enchaine.equals("modifAnnonce")) {
                actionModifAnnonce(request, response, tDAO);
            } else if (action.equals("searchAnnonces")) {
                actionSearchAnnonce(request, response, tDAO);
            } else if (action.equals("searchAnnonceSuite")) {
                actionSearchAnnonceSuite(request, response, tDAO);
            } else if (action.equals("gestionMesTaches")) {
                actionGestionMesTaches(request, response, tDAO);
            } else if (action.equals("supprimerTache")) {
                actionSupprimerTache(request, response, tDAO);
            } else if (action.equals("annulerTache")) {
                actionAnnulerTache(request, response, tDAO);
            } else if (action.equals("evaluer")) {
                actionEvaluer(request, response, eDAO, tDAO);
            } else if (action.equals("rechercherparville")) {
                actionRechercherparville(request, response, tDAO);
            } else {
                getServletContext().getRequestDispatcher(
                        "/WEB-INF/controleurErreur.jsp").forward(request,
                                response);
            }
        } catch (DAOException e) {
            request.setAttribute("erreurMessage", e.getMessage());
            getServletContext().getRequestDispatcher(
                    "/WEB-INF/bdErreur.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControleurTache.class.getName()).log(
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
     * Accès à la page qui affiche les tâches que je suis en train d'exécuter
     */
    private void actionMesTaches(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {

        HttpSession session = request.getSession();
        request.setAttribute("taches", tacheDAO.getListeTacheAtom(
                (String) session.getAttribute("email")));
        getServletContext().getRequestDispatcher(
                "/WEB-INF/mesTaches_1.jsp").forward(request, response);
    }

    /**
     * Accès à la page qui affiche les annonces que j'ai postées
     */
    private void actionMesAnnonces(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {
        HttpSession session = request.getSession();
        request.setAttribute("annonces", tacheDAO.getListeTaches(
                (String) session.getAttribute("email")));
        getServletContext().getRequestDispatcher(
                "/WEB-INF/mesAnnonces_1.jsp").forward(request, response);
    }

    /**
     * Historique des annonces postées et/ou réalisées
     */
    private void actionHistorique(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tDAO)
            throws IOException, ServletException, DAOException {
        getServletContext().getRequestDispatcher(
                "/WEB-INF/historique_1.jsp").forward(request, response);
    }

    /**
     * Redirige vers la page de recherche d'annonces
     */
    private void actionRechercher(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tDAO)
            throws IOException, ServletException, DAOException {
        LinkedList<String> competences = tDAO.getCompetences();
        request.setAttribute("competences", competences);
        getServletContext().getRequestDispatcher(
                "/WEB-INF/rechercher_1.jsp").forward(request, response);
    }

    /**
     * Permet de poster une annonce simple ou multiple
     */
    private void actionDeposerAnnonce(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {
        HttpSession session = request.getSession();
        int numTache = 0;
        String descriptionG = request.getParameter("descriptionGlobale");
        if (descriptionG == null) {
            numTache = tacheDAO.ajouterTache("nop", (String) session.getAttribute("email"));
        } else {
            numTache = tacheDAO.ajouterTache(descriptionG, (String) session.getAttribute("email"));
        }
        String[] titre = request.getParameterValues("titre");
        String[] description = request.getParameterValues("description");
        String[] dateTot = request.getParameterValues("dateTot");
        String[] dateTard = request.getParameterValues("dateTard");
        String[] latitudeT = (String[]) request.getAttribute("latitude");
        String[] longitudeT = (String[]) request.getAttribute("longitude");
        String[] remuneration = request.getParameterValues("remuneration");
        String[] competences = request.getParameterValues("competences");
        int k = 0;
        int numTacheAtomique = 0;

        for (int i = 0; i < titre.length; i++) {
            LinkedList<String> compet = new LinkedList<String>();
            while (!competences[k].equals("parse")) { //le mot parse sépare les compétences associées à des tâches différentes dans la requête
                compet.add(competences[k]);
                k++;
            }
            k++;

            numTacheAtomique = tacheDAO.ajouterTacheAtomique(numTache, titre[i],
                    description[i], dateTot[i], dateTard[i],
                    Float.parseFloat(latitudeT[i]),
                    Float.parseFloat(longitudeT[i]),
                    Float.parseFloat(remuneration[i]));
            tacheDAO.addCompetences(compet, numTache, numTacheAtomique);
        }
        actionAfficher(request, response, tacheDAO);
    }

    /**
     * Envoi les différentes infos utiles sur la page de gestion d'une annonce
     */
    private void actionGestionAnnonce(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {

        //Envoi des compétences nécessaires pour afficher les pages
        LinkedList<String> competences = tacheDAO.getCompetences(
                Integer.parseInt(request.getParameter("numTache")),
                Integer.parseInt(request.getParameter("numTacheAtom")));
        LinkedList<String> competencesP = tacheDAO.getCompetences();
        LinkedList<String> autresCompetences = new LinkedList<String>();
        for (String c1 : competencesP) {
            if (!competences.contains(c1)) {
                autresCompetences.add(c1);
            }
        }
        request.setAttribute("competences", competences);
        request.setAttribute("autresCompetences", autresCompetences);

        request.setAttribute("tacheAtom", tacheDAO.getTacheAtom(
                Integer.parseInt(request.getParameter("numTache")),
                Integer.parseInt(request.getParameter("numTacheAtom"))));

        TacheAtom ta = tacheDAO.getTacheAtom(
                Integer.parseInt(request.getParameter("numTache")),
                Integer.parseInt(request.getParameter("numTacheAtom")));

        //On recupere l'adresse et on l'envoie
        String adresse = null;
        try {
            adresse = this.actionInverseville(ta.getLatitudeT(), ta.getLongitudeT());
        } catch (Exception e) {

        }
        request.setAttribute("adresse", adresse);

        getServletContext().getRequestDispatcher(
                "/WEB-INF/gestionAnnonces_1.jsp").forward(request, response);
    }

    /**
     * Envoi les différentes ifos utiles sur la page de gestion d'une annonce
     */
    private void actionModifAnnonce(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {

        String[] competences = request.getParameterValues("competences");
        tacheDAO.modifierTache(Integer.parseInt(request.getParameter("numTache")),
                Integer.parseInt(request.getParameter("numTacheAtom")),
                request.getParameter("titre"), request.getParameter("description"),
                request.getParameter("dateTot"), request.getParameter("dateTard"),
                Float.parseFloat((String) request.getAttribute("latitudeT")),
                Float.parseFloat((String) request.getAttribute("longitudeT")),
                Float.parseFloat(request.getParameter("remuneration")),
                competences);
        this.actionGestionAnnonce(request, response, tacheDAO);
    }

    /**
     * Execute la recherche et renvoi sur la page web resultSearch
     */
    private void actionSearchAnnonce(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {
        HttpSession session = request.getSession();
        int distance = -2;
        String adresseMailCom = null;
        if (!request.getParameter("distance").equals("")) {
            distance = Integer.parseInt(request.getParameter("distance"));
        }
        if (session != null) {
            adresseMailCom = (String) session.getAttribute("email");
        }
        if (!request.getParameter("action").equals("rechercherparville")) {
            float remuneration = -10;
            float latitude = Float.parseFloat(
                    (String) session.getAttribute("latitude"));
            float longitude = Float.parseFloat(
                    (String) session.getAttribute("longitude"));
            if (!request.getParameter("remuneration").equals("")) {
                remuneration = Float.parseFloat(
                        request.getParameter("remuneration"));
            }
            LinkedList<TacheAtom> tacheAtom = tacheDAO.search(
                    request.getParameterValues("competences"),
                    request.getParameter("dateTot"),
                    request.getParameter("dateTard"), latitude, longitude,
                    remuneration, distance, adresseMailCom);
            request.setAttribute("tacheAtom", tacheAtom);
        } else {
            float latitude = 1000;
            if (!((String) request.getAttribute("latitudeT")).equals("")) {
                latitude = Float.parseFloat(((String) request.getAttribute("latitudeT")));
            }
            float longitude = 1000;
            if (!((String) request.getAttribute("longitudeT")).equals("")) {
                longitude = Float.parseFloat(((String) request.getAttribute("longitudeT")));
            }
            float remuneration = -10;
            if (!(request.getParameter("prix")).equals("")) {
                remuneration = Float.parseFloat((request.getParameter("prix")));
            }
            LinkedList<TacheAtom> tacheAtom = tacheDAO.search(
                    request.getParameterValues("competences"),
                    request.getParameter("dateTot"),
                    request.getParameter("dateTard"), latitude, longitude,
                    remuneration, distance, adresseMailCom);
            request.setAttribute("tacheAtom", tacheAtom);
        }
        getServletContext().getRequestDispatcher(
                "/WEB-INF/resultSearch_1.jsp").forward(request, response);
    }

    /**
     * Envoi les différentes infos utiles sur la page de gestion d'une annonce
     */
    private void actionGestionMesTaches(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {

        //Envoi des compétences nécessaires pour afficher les pages
        LinkedList<String> competences = tacheDAO.getCompetences(
                Integer.parseInt(request.getParameter("numTache")),
                Integer.parseInt(request.getParameter("numTacheAtom")));
        request.setAttribute("competences", competences);
        request.setAttribute("tacheAtom", tacheDAO.getTacheAtom(
                Integer.parseInt(request.getParameter("numTache")),
                Integer.parseInt(request.getParameter("numTacheAtom"))));

        TacheAtom ta = tacheDAO.getTacheAtom(
                Integer.parseInt(request.getParameter("numTache")),
                Integer.parseInt(request.getParameter("numTacheAtom")));

        //On recupere l'adresse et on l'envoie
        String adresse = null;
        try {
            adresse = this.actionInverseville(ta.getLatitudeT(), ta.getLongitudeT());
        } catch (Exception e) {

        }
        request.setAttribute("adresse", adresse);
        getServletContext().getRequestDispatcher(
                "/WEB-INF/gestionMesTaches_1.jsp").forward(request, response);
    }

    /**
     * Envoi les différentes infos utiles sur la page de gestion d'une annonce
     */
    private void actionSearchAnnonceSuite(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {

        //Envoi des compétences nécessaires pour afficher les pages
        LinkedList<String> competences = tacheDAO.getCompetences(
                Integer.parseInt(request.getParameter("numTache")),
                Integer.parseInt(request.getParameter("numTacheAtom")));
        //toutes les compétences possibles
        LinkedList<String> competencesP = tacheDAO.getCompetences();
        LinkedList<String> autresCompetences = new LinkedList<String>();
        for (String c1 : competencesP) {
            if (!competences.contains(c1)) {
                autresCompetences.add(c1);
            }
        }
        TacheAtom ta = tacheDAO.getTacheAtom(
                Integer.parseInt(request.getParameter("numTache")),
                Integer.parseInt(request.getParameter("numTacheAtom")));

        //On recupere l'adresse et on l'envoie
        String adresse = null;
        try {
            adresse = this.actionInverseville(ta.getLatitudeT(), ta.getLongitudeT());
        } catch (Exception e) {

        }
        request.setAttribute("adresse", adresse);

        request.setAttribute("competences", competences);
        //Les compétences de la tâche associée
        request.setAttribute("autresCompetences", autresCompetences);
        //Il reste à envoyer la tacheAtomique associée à numTache et numTacheAtomique
        request.setAttribute("tacheAtom", ta);
        getServletContext().getRequestDispatcher(
                "/WEB-INF/resultSearchSuite_1.jsp").forward(request, response);
    }

    /**
     * Supprime la tache en question
     */
    private void actionSupprimerTache(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tDAO)
            throws IOException, ServletException, DAOException {
        if (request.getParameter("confirm").equals("Oui")) {
            int numTache = Integer.parseInt(request.getParameter("numTache"));
            int numTacheAtomique = Integer.parseInt(
                    request.getParameter("numTacheAtomique"));
            tDAO.supprimerTache(numTache, numTacheAtomique);
        }
        this.actionMesAnnonces(request, response, tDAO);
    }

    /**
     * Annule une tâche en cous d'exécution
     */
    private void actionAnnulerTache(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tDAO)
            throws IOException, ServletException, DAOException {
        if (request.getParameter("confirm").equals("Oui")) {
            int numTache = Integer.parseInt(request.getParameter("numTache"));
            int numTacheAtomique = Integer.parseInt(
                    request.getParameter("numTacheAtomique"));
            tDAO.annulerTache(numTache, numTacheAtomique);
        }
        this.actionMesTaches(request, response, tDAO);
    }

    /**
     * L'evaluation de la tache
     */
    private void actionEvaluer(HttpServletRequest request,
            HttpServletResponse response, EvaluerDAO eDAO, TacheDAO tDAO)
            throws DAOException, ServletException, IOException {

        HttpSession session = request.getSession();
        eDAO.ajouterEvaluation(Integer.parseInt(request.getParameter("numTache")),
                Integer.parseInt(request.getParameter("numTacheAtomique")),
                request.getParameter("adressemailExec"),
                Integer.parseInt(request.getParameter("note")),
                request.getParameter("commentaire"));
        request.setAttribute("annonces", tDAO.getListeTaches(
                (String) session.getAttribute("email")));
        getServletContext().getRequestDispatcher(
                "/WEB-INF/mesAnnonces_1.jsp").forward(request, response);
    }

    /**
     * COde pour recherche d'une ville
     *
     * @param request
     * @param response
     * @param tDAO
     * @throws DAOException
     * @throws ServletException
     * @throws IOException
     * @throws Exception
     */
    private void actionRechercherparville(HttpServletRequest request,
            HttpServletResponse response,
            TacheDAO tDAO) throws DAOException, ServletException, IOException, Exception {

        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBGsnFTtPeMHJAKymad5wJd-2DEutP6nko");
        GeocodingResult[] results;
        float latitude = 1000;
        float longitude = 1000;
        Geometry geometri;
        if (!request.getParameter("ville").equals("")) {
            results = GeocodingApi.geocode(context, request.getParameter("ville")).await();
            System.out.println(results[0].geometry);

            geometri = results[0].geometry;
            latitude = (float) geometri.location.lat;
            longitude = (float) geometri.location.lng;
        }
        request.setAttribute("latitudeT", String.valueOf(latitude));
        request.setAttribute("longitudeT", String.valueOf(longitude));

        if (request.getParameter("what").equals("recherche")) {
            this.actionSearchAnnonce(request, response, tDAO);
        } else if (request.getParameter("what").equals("profil")) {
            request.setAttribute("action_enchaine", "creerUtilisateur");
            getServletContext().getRequestDispatcher(
                    "/controleurProfil").forward(request, response);
        } else if (request.getParameter("what").equals("modifier")) {
            request.setAttribute("action_enchaine", "modif");
            getServletContext().getRequestDispatcher(
                    "/controleurProfil").forward(request, response);
        } else if (request.getParameter("what").equals("modifAnnonce")) {
            request.setAttribute("action_enchaine", "modifAnnonce");
            this.actionModifAnnonce(request, response, tDAO);
        }

        if (request.getParameter("what").equals("annonce")) {
            int k = 0;
            String[] lat = new String[100];
            String[] longi = new String[100];
            String[] ville = request.getParameterValues("ville");
            for (String v : ville) {
                results = GeocodingApi.geocode(context, v).await();
                System.out.println(results[0].geometry);

                geometri = results[0].geometry;
                lat[k] = String.valueOf(geometri.location.lat);
                longi[k] = String.valueOf(geometri.location.lng);
                k++;
            }
            request.setAttribute("latitude", lat);
            request.setAttribute("longitude", longi);
            this.actionDeposerAnnonce(request, response, tDAO);
        }
    }

    private String actionInverseville(float latitude, float longitude) throws Exception {

        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBGsnFTtPeMHJAKymad5wJd-2DEutP6nko");
        GeocodingResult[] results;
        String adresse = null;
        results = GeocodingApi.newRequest(context).latlng(new LatLng(latitude, longitude)).await(); //.latlng(new LatLng(latitude, longitude)).await();
