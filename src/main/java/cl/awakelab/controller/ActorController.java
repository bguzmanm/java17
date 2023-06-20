package cl.awakelab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.model.dto.Actor;
import cl.awakelab.model.service.ActorService;


@WebServlet("/actor")
public class ActorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	ActorService as = new ActorService();
	
    public ActorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Actor> actors = as.findAll();
		request.setAttribute("actors", actors);
		
		getServletContext().getRequestDispatcher("/views/actors.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
