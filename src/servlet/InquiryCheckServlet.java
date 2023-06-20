package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InquiryDAO;
import model.Inquirys;

/**
 * Servlet implementation class InquiryCheckServlet
 */
@WebServlet("/InquiryCheckServlet")
public class InquiryCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 問い合わせ確認画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/InquiryCheck.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Inquirys inquiry = (Inquirys)session.getAttribute("inquiry");

		InquiryDAO iDao = new InquiryDAO();

		if (iDao.insert(inquiry)) {
			// 登録成功
			// リクエストスコープにメッセージを格納する
			request.setAttribute("result","完了");
			// RegisterResultServletにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/InquiryResult.jsp");
			dispatcher.forward(request, response);

		}
		else {
			// 送信失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result","失敗");

			//  RegisterResultServletにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/InquiryResult.jsp");
			dispatcher.forward(request, response);
		}
	}

}
