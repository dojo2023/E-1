package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class CalendarMonthTetsuyaChangeOnServlet
 */
@WebServlet("/CalendarMonthTetsuyaChangeOnServlet")
public class CalendarMonthTetsuyaChangeOnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//追加
		HttpSession session = request.getSession();

		session.setAttribute("tetsuya","1");

		UserDAO uDao = new UserDAO();
		User user = new User();

		user.setTetsuya("1");
		user.setId((String)session.getAttribute("id"));

		uDao.tetsuya(user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("CalendarServlet");
		dispatcher.forward(request, response);
		//追加終了
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
