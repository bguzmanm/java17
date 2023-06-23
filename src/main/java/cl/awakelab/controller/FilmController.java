package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.model.dto.Actor;
import cl.awakelab.model.dto.Film;
import cl.awakelab.model.service.ActorService;
import cl.awakelab.model.service.FilmService;


@WebServlet("/film")
public class FilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmService fs = new FilmService();
   
    public FilmController() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = 0;
		if (strId != null) {
			id = Integer.parseInt(strId);
		}
		
		String op = request.getParameter("op");
		request.setAttribute("op", op);
		
		Film film = fs.findOne(id);			
		request.setAttribute("film", film);	
		getServletContext().getRequestDispatcher("/views/film.jsp").forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
