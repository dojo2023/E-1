package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlanDAO;

/**
 * Servlet implementation class CalendarServlet
 */
@WebServlet("/CalendarMonthPrivateServletDelete")
public class CalendarMonthPrivateServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();


		String number = request.getParameter("SUBMIT");
		session.setAttribute("number", number);

		PlanDAO pDao = new PlanDAO();


		if (pDao.delete((String)session.getAttribute("number"))) {
			// 削除成功
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthBusiness.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CalendarServlet");
			dispatcher.forward(request, response);

		}
		else {
			// 送信失敗
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthPrivate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
