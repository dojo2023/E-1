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
@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String x = (String)session.getAttribute("mode");
		String y = (String)session.getAttribute("tetsuya");
		String z = (String)session.getAttribute("tetsuya_time");

		PlanDAO pDao = new PlanDAO();

		if (x.equals("business") && y.equals("0")) {
			List<Plan> planList = pDao.look((String)session.getAttribute("id"),x);
			session.setAttribute("planList", planList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthBusiness.jsp");
			dispatcher.forward(request, response);
		}
		else if (x.equals("business") && y.equals("1")) {
			//ここで徹夜チャンス判定
			session.setAttribute("chance","1");

			List<Plan> planList = pDao.look((String)session.getAttribute("id"),x);
			session.setAttribute("planList", planList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthBusinessTetsuyaModeTimeOff.jsp");
			dispatcher.forward(request, response);
		}
		else if (x.equals("private") && y.equals("0")) {
			List<Plan> planList = pDao.look((String)session.getAttribute("id"),x);
			session.setAttribute("planList", planList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthPrivate.jsp");
			dispatcher.forward(request, response);
		}
		else if (x.equals("private") && y.equals("1")) {

			//ここで徹夜チャンス判定
			session.setAttribute("chance","1");
			List<Plan> planList = pDao.look((String)session.getAttribute("id"),x);
			session.setAttribute("planList", planList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthPrivateTetsuyaModeTimeOff.jsp");
			dispatcher.forward(request, response);
		}
	}

}