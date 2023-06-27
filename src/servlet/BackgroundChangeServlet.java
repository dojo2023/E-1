
package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Rank_bonusDAO;
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
		request.setCharacterEncoding("UTF-8");

//ランク表示
		//セッションからのデータの取得
		/*		HttpSession session = request.getSession();
		int ID =(int)session.getAttribute("id");

		//検索処理を行う
		UserDAO UDao = new UserDAO();
		List<User> pointList = UDao.select(ID);

		//検索結果をリクエストスコープに格納する
		request.setAttribute("ｒ",pointList);
*/



//ランク表示ここまで

//背景変更↓
		//年月取得
		Calendar calender = Calendar.getInstance();

		int y = calender.get(Calendar.YEAR);
		int m = calender.get(Calendar.MONTH)+1;
		//ここまで

		Rank_bonus bonus = new Rank_bonus();

		//現在の月と年を入れる
		bonus.setYear(y);
		bonus.setMonth(m);


		//検索処理を行う
		Rank_bonusDAO bDao = new Rank_bonusDAO();
		Rank_bonus bonusList = bDao.select(bonus);


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

		//取得したURLをリクエストスコープに入れる
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();


			String url = request.getParameter("url");

			session.setAttribute("url", url);


			// ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
			dispatcher.forward(request, response);


	}

}