package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		String tetuya =  "0";

		request.setAttribute("tetsuya",tetuya);

		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");

		// ログイン処理を行う
		UserDAO uDao = new UserDAO();
		User user = new User();
		user.setId(id);
		user.setPw(pw);

		try {
			if (uDao.isLoginOK(user)) {
			// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("flag", "1");


			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");
			String sql = "select mode_shift from user WHERE ID = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			rs.next();
			String mode = rs.getString("mode_shift");
			session.setAttribute("mode", mode);

			Connection conn2 = null;
			conn2 = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");
			String sql2 = "select tetsuya from user WHERE ID = ?";

			PreparedStatement pStmt2 = conn2.prepareStatement(sql2);
			pStmt2.setString(1, id);
			ResultSet rs2 = pStmt2.executeQuery();

			rs2.next();
			String tetsuya = rs2.getString("tetsuya");
			session.setAttribute("tetsuya", tetsuya);


			Connection conn3 = null;
			conn3 = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");
			String sql3 = "select tetsuya_time from user WHERE ID = ?";

			PreparedStatement pStmt3 = conn3.prepareStatement(sql3);
			pStmt3.setString(1, id);
			ResultSet rs3 = pStmt3.executeQuery();

			rs3.next();
			String tetsuya_time = rs3.getString("tetsuya_time");
			session.setAttribute("tetsuya_time", tetsuya_time);

			// サーブレットにリダイレクトする
			response.sendRedirect("CalendarServlet");
		}
		else {
			// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result","※IDまたはパスワードに間違いがあります。");

			request.setAttribute("tetsuya","0");

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
			e = null;

		}
	}
}