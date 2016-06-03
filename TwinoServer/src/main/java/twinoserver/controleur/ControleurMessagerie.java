package twinoserver.controleur;

import twinoserver.dao.DAOException;
import twinoserver.dao.MessageDAO;
import twinoserver.dao.ProfilDAO;
import twinoserver.dao.TacheDAO;
import java.io.*;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ControleurMessagerie", urlPatterns = {"/controleurMessagerie"})

public class ControleurMessagerie extends HttpServlet {

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
        TacheDAO tDAO = new TacheDAO(ds);
        MessageDAO mDAO = new MessageDAO(ds);

        try {
            if (action == null) {
                actionAfficher(request, response, tDAO);
            } else if (action.equals("messagerie")) {
                actionMessagerie(request, response, mDAO);
            } else if (action.equals("demanderTache")) {
                actionDemanderTache(request, response, mDAO, tDAO);
            } else if (action.equals("gestionMessages")) {
                actionGestionMessages(request, response, mDAO);
            } else if (action.equals("supprimerMessage")) {
                actionSupprimerMessages(request, response, mDAO);
            } else if (action.equals("repondre")) {
                actionRepondre(request, response, mDAO);
            } else if (action.equals("accept")) {
                actionAccept(request, response, mDAO, tDAO);
            } else if (action.equals("payer")) {
                actionPayer(request, response, mDAO, tDAO);
            } else if (action.equals("confirmerTache")) {
                actionConfirmerTache(request, response, mDAO, tDAO);
            } else {
                getServletContext().getRequestDispatcher(
                        "/WEB-INF/controleurErreur.jsp").forward(
                                request, response);
            }
        } catch (DAOException e) {
            request.setAttribute("erreurMessage", e.getMessage());
            getServletContext().getRequestDispatcher(
                    "/WEB-INF/bdErreur.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControleurMessagerie.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        TacheDAO tDAO = new TacheDAO(ds);
        MessageDAO mDAO = new MessageDAO(ds);

        try {
            if (action == null) {
                actionAfficher(request, response, tDAO);
            } else if (action.equals("messagerie")) {
                actionMessagerie(request, response, mDAO);
            } else if (action.equals("demanderTache")) {
                actionDemanderTache(request, response, mDAO, tDAO);
            } else if (action.equals("gestionMessages")) {
                actionGestionMessages(request, response, mDAO);
            } else if (action.equals("supprimerMessage")) {
                actionSupprimerMessages(request, response, mDAO);
            } else if (action.equals("repondre")) {
                actionRepondre(request, response, mDAO);
            } else if (action.equals("accept")) {
                actionAccept(request, response, mDAO, tDAO);
            } else if (action.equals("payer")) {
                actionPayer(request, response, mDAO, tDAO);
            } else if (action.equals("confirmerTache")) {
                actionConfirmerTache(request, response, mDAO, tDAO);
            } else {
                getServletContext().getRequestDispatcher(
                        "/WEB-INF/controleurErreur.jsp").forward(
                                request, response);
            }
        } catch (DAOException e) {
            request.setAttribute("erreurMessage", e.getMessage());
            getServletContext().getRequestDispatcher(
                    "/WEB-INF/bdErreur.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControleurMessagerie.class.getName()).log(
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
                "/WEB-INF/Accueil_1.jsp").forward(request, response);

    }

    /**
     * Renvoi sur la messagerie avec les messages insérés dans la request
     */
    private void actionMessagerie(HttpServletRequest request,
            HttpServletResponse response,
            MessageDAO mDAO)
            throws IOException, ServletException, DAOException {
request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        request.setAttribute("messages", mDAO.getListeMessages(
                (String) session.getAttribute("email")));
        getServletContext().getRequestDispatcher(
                "/WEB-INF/messagerie_1.jsp").forward(request, response);
    }

    /**
     * Envoi un email à celui qui a posté la tâche et redirige sur la page
     * d'accueil
     */
    private void actionDemanderTache(HttpServletRequest request,
            HttpServletResponse response,
            MessageDAO mDAO, TacheDAO tDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String numTache = request.getParameter("numTache");
        String numTacheAtomique = request.getParameter("numTacheAtomique");
        mDAO.ajouterMessage("Reponse à votre offre : " + numTache + "-"
                + numTacheAtomique,
                "Un utilisateur souhaite executer cette tâche.",
                (String) session.getAttribute("email"),
                tDAO.getAdresseDest(Integer.parseInt(numTache)),
                0);
        actionAfficher(request, response, tDAO);
    }

    /**
     * Redirige vers la page qui donne le contenu integral du message
     */
    private void actionGestionMessages(HttpServletRequest request,
            HttpServletResponse response,
            MessageDAO mDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        //pour marquer le message comme lu (en fait ne modifie que la valeur estLu)
        mDAO.modifierMessage(Integer.parseInt(request.getParameter("numMessage")));
        request.setAttribute("messages", mDAO.getMessage(
                Integer.parseInt(request.getParameter("numMessage"))));
        getServletContext().getRequestDispatcher(
                "/WEB-INF/gestionMessages_1.jsp").forward(request, response);
    }

    /**
     * Supprime le message de numero numMessage
     */
    private void actionSupprimerMessages(HttpServletRequest request,
            HttpServletResponse response,
            MessageDAO mDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        mDAO.supprimerMessage(Integer.parseInt(request.getParameter("numMessage")));
        this.actionMessagerie(request, response, mDAO);
    }

    /**
     * Renvoie un message en réponse à un message reçu
     */
    private void actionRepondre(HttpServletRequest request,
            HttpServletResponse response,
            MessageDAO mDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        mDAO.ajouterMessage(request.getParameter("titre"),
                request.getParameter("message"),
                request.getParameter("adresseMailExp"),
                request.getParameter("adresseMailDest"), 0);
        this.actionMessagerie(request, response, mDAO);
    }

    /**
     * Renvoie un message en réponse à un message reçu on recupere deja numTache
     * et numTacheAtomique contenu dans le titre du message
     */
    private void actionAccept(HttpServletRequest request,
            HttpServletResponse response,
            MessageDAO mDAO, TacheDAO tDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        String adresseMailDest = request.getParameter("adresseMailDest");
        String adresseMailExp = request.getParameter("adresseMailExp");
        if (request.getParameter("confirm").equals("Refuser")) {
            //Titre du message envoyé par le futur executant qui contient
            //les numéros de tache et tacheatomique
            String titre = request.getParameter("titre").substring(24);
            String[] parts = titre.split("-");
            int numTache = Integer.parseInt(parts[0]);
            int numTacheAtomique = Integer.parseInt(parts[1]);
            mDAO.ajouterMessage("Tâche refusée",
                    "La demande n'a pas été acceptée par le commanditaire "
                    + "de la tâche.",
                    adresseMailExp, adresseMailDest, 0);
        } else if (request.getParameter("confirm").equals("Accepter")) {
            //Titre du message envoyé par le futur executant qui contient
            //les numéros de tache et tacheatomique
            String titre = request.getParameter("titre").substring(24);
            String[] parts = titre.split("-");
            int numTache = Integer.parseInt(parts[0]);
            int numTacheAtomique = Integer.parseInt(parts[1]);
            mDAO.ajouterMessage("Tâche acceptée",
                    "La demande a été acceptée par le commanditaire de la tâche. "
                    + "Veuillez-vous rendre sur la page de votre compte, "
                    + "dans la catégorie \"Tâche en cours\" "
                    + "pour avoir accès à "
                    + "toutes les informations nécessaires. ",
                    adresseMailExp, adresseMailDest, 0);
            //ajoute executant à la tache donné
            tDAO.execute(numTache, numTacheAtomique, adresseMailDest);
        }
        actionMessagerie(request, response, mDAO);
    }

    /**
     * Renvoie un message en réponse à un message reçu on recupere deja numTache
     * et numTacheAtomique contenu dans le titre du message
     */
    private void actionPayer(HttpServletRequest request,
            HttpServletResponse response,
            MessageDAO mDAO, TacheDAO tDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        String adresseMailDest = request.getParameter("adresseMailDest");
        String adresseMailExp = request.getParameter("adresseMailExp");
        //Titre du message envoyé par le futur executant qui
        //contient les numéros de tache et tacheatomique
        String message = request.getParameter("message").substring(17);
        String[] parts = message.split("-");
        int numTache = Integer.parseInt(parts[0]);
        int numTacheAtomique = Integer.parseInt(parts[1]);
        if (request.getParameter("confirm").equals("Refuser")) {
            mDAO.ajouterMessage("Tâche refusée", "Le paiement "
                    + "n'a pas été acceptée par le commanditaire de la tâche.",
                    adresseMailExp, adresseMailDest, 0);
        } else if (request.getParameter("confirm").equals("Payer")) {
            tDAO.effectue(numTache, numTacheAtomique);
            mDAO.ajouterMessage("Tâche payée",
                    "Le commanditaire de la tâche a procédé au paiment. "
                    + "Veuillez-vous rendre sur la page de votre compte, "
                    + "dans la catégorie \"Historique\" pour "
                    + "avoir accès à toutes les informations nécessaires "
                    + "et pour avoir accès à votre facture. "
                    + "En espérant vous revoir bientôt sur notre site. ",
                    adresseMailExp, adresseMailDest, 0);
        }
        actionMessagerie(request, response, mDAO);
    }

    /**
     * Confirme l'execution d'une tache
     */
    private void actionConfirmerTache(HttpServletRequest request,
            HttpServletResponse response,
            MessageDAO mDAO, TacheDAO tDAO)
            throws IOException, ServletException, DAOException {
        request.setCharacterEncoding("UTF-8");
        ProfilDAO pDAO = new ProfilDAO(ds);
        HttpSession session = request.getSession();

        if (request.getParameter("confirm").equals("Oui")) {

            String adresseMailExp = (String) session.getAttribute("email");
            int numTache = Integer.parseInt(request.getParameter("numTache"));
            String adresseMailDest = tDAO.getAdresseDest(numTache);
            int numTacheAtomique = Integer.parseInt(request.getParameter("numTacheAtomique"));
            mDAO.ajouterMessage("Tâche terminée : " + numTache + "-" + numTacheAtomique,
                    "L'exécutant de la tâche n°" + numTache + "-" + numTacheAtomique
                    + " a terminé. Veuillez-vous rendre sur la page de "
                    + "votre compte, dans la catégorie \"Annonces postées\" "
                    + "pour avoir accès à toutes les informations nécessaires. ",
                    adresseMailExp, adresseMailDest, 0);
            request.setAttribute("action_enchaine", "menuProfil");
            getServletContext().getRequestDispatcher("/controleurProfil").forward(request, response);
        } else {
            request.setAttribute("action_enchaine", "mesTaches");
            getServletContext().getRequestDispatcher("/controleurTache").forward(request, response);
        }
    }
}
