package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.model.service.FilmService;

@WebServlet("/films")
public class FilmsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private FilmService filmService = new FilmService();
	
    public FilmsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strActorId = request.getParameter("actorId");
		int actorId = 0;
		if (strActorId != null) {
			actorId = Integer.parseInt(strActorId);
		}
		
		if (actorId>0) {
			request.setAttribute("films", filmService.findByActorId(actorId));	
		} else {
			request.setAttribute("films", filmService.findAll());
		}
			
		
		getServletContext().getRequestDispatcher("/views/films.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
