package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


		//リクエストパラメーターを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String year = request.getParameter("YEAR");
		String month = request.getParameter("MONTH");
		String point_b = request.getParameter("POINT_B");
		String POINT_p = request.getParameter("POINT_P");
		String POINT_m = request.getParameter("POINT_M");

		//検索処理を行う
/*	Point_dayDAO pDao = new Point_dayDAO();
		List<Point_day> pointList = pDao.select(new Point_day(*));



		//検索結果をリクエストスコープに格納する
		request.setAttributa("p", pointList);

*/
		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pointDetial.jsp");
		dispatcher.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
