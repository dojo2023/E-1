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
 * Servlet implementation class CalendarMonthBusinessSerchServlet
 */
@WebServlet("/CalendarMonthPrivateTetsuyaModeTimeOffSerchServlet")
public class CalendarMonthPrivateTetsuyaModeTimeOffSerchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String serch = request.getParameter("Serch");

		// 検索処理を行う
		PlanDAO pDao = new PlanDAO();
		List<Plan> serchList = pDao.select((String)session.getAttribute("id"),(String)session.getAttribute("mode"),serch);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("serchList", serchList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthPrivateTetsuyaModeTimeOffSerch.jsp");
		dispatcher.forward(request, response);
	}
}
