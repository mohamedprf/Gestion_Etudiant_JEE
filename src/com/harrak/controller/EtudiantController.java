package com.harrak.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harrak.dao.EtudiantDao;
import com.harrak.model.Etudiant;

/**
 * Servlet implementation class EtudiantController
 */
@WebServlet("/")  

public class EtudiantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/Etudiant.jsp";
    private static String LIST_USER = "/listEtudiant.jsp";
    private EtudiantDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtudiantController() {
        super();
        dao = new EtudiantDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String forward="";
	     String action = request.getParameter("action");
	     
	     if (action.equalsIgnoreCase("delete")){
	            int id = Integer.parseInt(request.getParameter("id"));
	            dao.deleteEtudiant(id);
	            forward = LIST_USER;
	            request.setAttribute("etudiants", dao.getAllEtudiants());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            int id = Integer.parseInt(request.getParameter("id"));
	            Etudiant etudiant = dao.getEtudiantById(id);
	            request.setAttribute("etudiant", etudiant);
	        } else if (action.equalsIgnoreCase("listEtudiant")){
	            forward = LIST_USER;
	            request.setAttribute("etudiants", dao.getAllEtudiants());
	        } else {
	            forward = INSERT_OR_EDIT;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Etudiant etudiant = new Etudiant();
		 	etudiant.setNom(request.getParameter("nom"));
		 	etudiant.setPrenom(request.getParameter("prenom"));
		 	etudiant.setSexe(request.getParameter("sexe"));
		 	etudiant.setEmail(request.getParameter("email"));
		 	etudiant.setFiliere(request.getParameter("filiere"));
	       
	        String id = request.getParameter("id");
	        if(id == null || id.isEmpty())
	        {
	            dao.AjouterEtudiant(etudiant);
	        }
	        else
	        {
	        	etudiant.setId(Integer.parseInt(id));
	            dao.updateEtudiant(etudiant);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
	        request.setAttribute("etudiants", dao.getAllEtudiants());
	        view.forward(request, response);
	    }
	}


