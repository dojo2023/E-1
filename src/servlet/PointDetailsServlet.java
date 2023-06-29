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

import dao.Point_dayDAO;
import model.Point_day;

/**
 * Servlet implementation class PointDetailsServlet
 */
@WebServlet("/PointDetailsServlet")
public class PointDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

//グラフデータ取得
		//セッションからのデータの取得
		HttpSession session = request.getSession();
		String ID =(String)session.getAttribute("id");
		//String ID ="tetsuya";

		//年月取得
		Calendar calender = Calendar.getInstance();
		int y = calender.get(Calendar.YEAR);
		int m = calender.get(Calendar.MONTH)+1;
//		int y = 2023;
//		int m = 6;

		//検索処理を行う
		Point_dayDAO pDao = new Point_dayDAO();
		List<Point_day> pointList = pDao.look(new Point_day(ID, y, m, 0, 0, 0, 0));

		//検索結果をリクエストスコープに格納する
		request.setAttribute("g", pointList);

		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pointDetial.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}

}
