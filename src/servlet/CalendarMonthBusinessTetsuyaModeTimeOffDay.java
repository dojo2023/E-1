package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlanDAO;
import model.Plan;

/**
 * Servlet implementation class CalendarServlet
 */
@WebServlet("/CalendarMonthBusinessTetsuyaModeTimeOffDay")
public class CalendarMonthBusinessTetsuyaModeTimeOffDay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String day = request.getParameter("day");

		PlanDAO pDao = new PlanDAO();

		List<Plan> planDayList = pDao.lookDay((String)session.getAttribute("id"),day,(String)session.getAttribute("mode"));
		session.setAttribute("day", day);
		session.setAttribute("planDayList", planDayList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthBusinessTetsuyaModeTimeOffDay.jsp");
		dispatcher.forward(request, response);
	}

}