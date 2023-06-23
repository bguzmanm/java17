package cl.awakelab.controller;

import java.io.IOException;
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
       
	
	private ActorService as = new ActorService();
	
    public ActorController() {
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
		
		switch (op) {
			case "new": {
				getServletContext().getRequestDispatcher("/views/actor.jsp").forward(request, response);
				break;
			}
			case "edit": {
				if (id > 0) {
					Actor actor = as.findOne(id);			
					request.setAttribute("actor", actor);	
					getServletContext().getRequestDispatcher("/views/actor.jsp").forward(request, response);			
				}
				break;
			}
			case "read": {
				if (id > 0) {
					Actor actor = as.findOne(id);			
					request.setAttribute("actor", actor);	
					getServletContext().getRequestDispatcher("/views/actor.jsp").forward(request, response);			
				}
			}
			case "delete": {
				if (id > 0) {
					
					as.delete(id);
					response.sendRedirect(request.getContextPath() + "/actors");		
								
				}
			}
		
		}
		
		/*
		
		if (id > 0) {
			Actor actor = as.findOne(id);			
			request.setAttribute("actor", actor);	
			getServletContext().getRequestDispatcher("/views/actor.jsp").forward(request, response);			
		} else {			
			if (op.equals("new")) {
				getServletContext().getRequestDispatcher("/views/actor.jsp").forward(request, response);
			} else {
			
			//	response.sendRedirect(request.getContextPath() + "/actors");
			}
			//getServletContext().getRequestDispatcher("/views/actors.jsp").forward(request, response);
		}
		
		*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String strId = request.getParameter("id");
		
		if (!strId.isEmpty()) {
			int id = Integer.parseInt(strId);
			
			Actor actor = new Actor(id, nombre, apellido);
			as.update(actor);
			
		} else {
			Actor actor = new Actor();
			actor.setFirstName(nombre);
			actor.setLastName(apellido);
			
			as.create(actor);
			
		}
		
		response.sendRedirect(request.getContextPath() + "/actors");
		
	}

}
