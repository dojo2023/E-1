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
import dao.UserDAO;
import model.Plan;
import model.User;

/**
 * Servlet implementation class CalendarMonthModeChangeBusinessServlet
 */
@WebServlet("/CalendarMonthModeChangeBusinessServlet")
public class CalendarMonthModeChangeBusinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//追加
				HttpSession session = request.getSession();

				session.setAttribute("mode","business");

				UserDAO uDao = new UserDAO();
				User user = new User();

				user.setId((String)session.getAttribute("id"));
				user.setMode_shift("business");

				uDao.modehcange(user);

				RequestDispatcher dispatcher = request.getRequestDispatcher("CalendarServlet");
				dispatcher.forward(request, response);
				//追加終了
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String what = request.getParameter("what");
		String s_time = request.getParameter("s_time");
		String e_time = request.getParameter("e_time");
		String memo = request.getParameter("memo");
		String s_day = request.getParameter("s_day");
		String e_day = request.getParameter("e_day");
		String color = request.getParameter("color");

		//格納するものを作成
		Plan plan = new Plan();

		plan.setWhat(what);
		plan.setS_time(s_time);
		plan.setE_time(e_time);
		plan.setMemo(memo);
		plan.setS_day(s_day);
		plan.setE_day(e_day);
		plan.setColor(color);

		plan.setMode("business");
		plan.setWhich("schebule");

		// セッションスコープにお問い合わせ内容を格納する
		HttpSession session = request.getSession();
		session.setAttribute("plan", plan);

		PlanDAO pDao = new PlanDAO();

		if (pDao.insert((String)session.getAttribute("id"),plan)) {
			// 登録成功
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CalendarServlet");
			dispatcher.forward(request, response);

		}
		else {
			// 送信失敗
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CalendarMonthBusiness.jsp");
			dispatcher.forward(request, response);
		}
	}

}
