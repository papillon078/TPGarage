package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbutils.Cars;
import entities.Car;

/**
 * Servlet implementation class ReserveCars
 */
@WebServlet("/ReserveCars")
public class ReserveCars extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveCars() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/********************************************
		 * Affichage de la liste des voitures 
		 *******************************************/
		Cars car = new Cars();
		
		List<Car> carsList = car.recuperercars(); 
		
		request.setAttribute("carslist", carsList);
		this.getServletContext().getRequestDispatcher("/WEB-INF/vente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/********************************************
		 * recuperation de l'id de la voiture selectionnée pour reservation
		 * et verification de sa disponibilité
		 * puis notification a l'utilisateur de sa disponibilité
		 *******************************************/
		Cars car = new Cars();
		String notification ="";
		int carId = Integer.parseInt(request.getParameter("carId"));
		
		notification  = car.carReserving(carId);
		request.setAttribute("notification", notification);

		doGet(request, response);
	}

}
