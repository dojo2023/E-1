package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class RegisterCheckServlet
 */
@WebServlet("/RegisterCheckServlet")
public class RegisterCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerCheck.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		if (uDao.insert(user)) {
			// 登録成功
			// リクエストスコープにメッセージを格納する
			request.setAttribute("result","完了");
			// RegisterResultServletにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerResult.jsp");
			dispatcher.forward(request, response);

		}
		else {
			// 登録失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result","失敗");

			//  RegisterResultServletにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerResult.jsp");
			dispatcher.forward(request, response);
		}
	}

}
