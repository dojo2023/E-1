
package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Rank_bonusDAO;
import dao.UserDAO;
import model.Rank_bonus;

/**
 * Servlet implementation class BackgroundChangeServlet
 */
@WebServlet("/BackgroundChangeServlet")
public class BackgroundChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

//ランク表示
		//セッションからのデータの取得
		HttpSession session = request.getSession();
		String UID =(String)session.getAttribute("id");

		//検索処理を行う
		UserDAO UDao = new UserDAO();
		User = UDao.select(UID);




//ランク表示ここまで
//背景変更↓
		Calendar calender = Calendar.getInstance();

		int y = calender.get(Calendar.YEAR)+1;
		int m = calender.get(Calendar.MONTH)+1;

		Rank_bonus bonus = new Rank_bonus();

		//現在の月と年を入れる
		bonus.setYear(y+"");
		bonus.setMonth(m+"");


		//検索処理を行う
		Rank_bonusDAO bDao = new Rank_bonusDAO();
		List<Rank_bonus> bonusList = bDao.select(bonus);


		//検索結果をリクエストスコープに格納する
		request.setAttribute("j",bonusList);
//背景変更ここまで

		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/backgroundChange.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = request.getParameter("url");

			request.setAttribute("url", url);

			// ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/backgroundChange.jsp");
			dispatcher.forward(request, response);


	}

}
