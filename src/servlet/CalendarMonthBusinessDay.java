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
@WebServlet("/CalendarMonthBusinessDay")
public class CalendarMonthBusinessDay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String day = request.getParameter("day");
		String x = (String)session.getAttribute("mode");
		String y = (String)session.getAttribute("tetsuya");
		String z = (String)session.getAttribute("tetsuya_time");

		PlanDAO pDao = new PlanDAO();

		List<Plan> planDayList = pDao.lookDay((String)session.getAttribute("id"),day,(String)session.getAttribute("mode"));
		session.setAttribute("day", day);
		session.setAttribute("planDayList", planDayList);

		if (x.equals("business") && y.equals("0") && z.equals("0")) {
			List<Plan> planList = pDao.look((String)session.getAttribute("id"),x);
			session.setAttribute("planList", planList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthBusinessDay.jsp");
			dispatcher.forward(request, response);
		}
		else if (x.equals("business") && y.equals("1") && z.equals("0")) {
			List<Plan> planList = pDao.look((String)session.getAttribute("id"),x);
			session.setAttribute("planList", planList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthBusinessTetsuyaModeTimeOffDay.jsp");
			dispatcher.forward(request, response);
		}
		else if (x.equals("private") && y.equals("0") && z.equals("0")) {
			List<Plan> planList = pDao.look((String)session.getAttribute("id"),x);
			session.setAttribute("planList", planList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthPrivateDay.jsp");
			dispatcher.forward(request, response);
		}
		else if (x.equals("private") && y.equals("1") && z.equals("0")) {
			List<Plan> planList = pDao.look((String)session.getAttribute("id"),x);
			session.setAttribute("planList", planList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthPrivateTetsuyaModeTimeOffDay.jsp");
			dispatcher.forward(request, response);
		}
	}

}