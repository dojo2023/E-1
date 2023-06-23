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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userFamilyName = request.getParameter("userFamilyName");
		String userName = request.getParameter("userName");
		String userPW = request.getParameter("userPW");

		User user = new User();
		user.setId(userID);
		user.setL_name(userFamilyName);
		user.setF_name(userName);
		user.setPw(userPW);

		UserDAO uDao = new UserDAO();

		if(uDao.isOkId(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// registerCheck.jspにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerCheck.jsp");
			dispatcher.forward(request, response);
		} else {

			request.setAttribute("result","※入力されたIDはすでに登録されています。");

			// register.jspにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);
		}
	}

}
