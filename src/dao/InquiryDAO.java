package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Inquirys;

public class InquiryDAO {
		// ランクの基準ポイントを見るために取得
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Inquirys card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "insert into INQUIRY values (?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getId() != null && !card.getId().equals("")) {
					pStmt.setString(1, card.getId());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getGenre() != null && !card.getGenre().equals("")) {
					pStmt.setString(2, card.getGenre());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getText() != null && !card.getText().equals("")) {
					pStmt.setString(3, card.getText());
				}
				else {
					pStmt.setString(3, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

}


