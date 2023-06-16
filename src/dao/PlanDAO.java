/*
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Point;

public class PointDAO {
		// 獲得できるポイント一覧の取得
		public List<Point> look() {
		Connection conn = null;
		List<Point> cardList = new ArrayList<Point>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select * from Point";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Point card = new Point(
					rs.getString("b_POINT"),
					rs.getString("P_POINT"),
					rs.getString("TETSUYA_B"),
					rs.getString("TETSUYA_P"),
					rs.getString("CHANCE_BONUS"),
					rs.getString("B_MAX"),
					rs.getString("P_MAX")
					);
					cardList.add(card);
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
				}
			}
			// 結果を返す
			return cardList;
		}
}
*/