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
		Cars car = new Cars();
		
		List<Car> carsList = car.recuperercars(); 
		
		request.setAttribute("carslist", carsList);
		this.getServletContext().getRequestDispatcher("/WEB-INF/vente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cars cars = new Cars();
		boolean reserved = cars.isReserved(Integer.parseInt(request.getParameter("carId")));
		boolean blocked = cars.isBlocked(Integer.parseInt(request.getParameter("carId")));
		if (!reserved  && !blocked) {
//			cars.sendMail();
			String notification = "La voiture vous est reservée, vous recevrez un mail de confirmation";
			request.setAttribute("notification", notification);
		}else if(reserved) {
			String notification = "La voiture est deja reservée, veuillez choisir une autre voiture";
			request.setAttribute("notification", notification);
		}else if(blocked){
			String notification = "La voiture est bloquée pour achat, veuillez choisir une autre voiture";
			request.setAttribute("notification", notification);
		}

		doGet(request, response);
	}

}
