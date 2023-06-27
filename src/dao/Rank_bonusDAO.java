package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Rank_bonus;

public class Rank_bonusDAO {
		// Sランク、Aランクの背景を見るために取得
		// dayには年月を与える
		public Rank_bonus select(Rank_bonus day) {
		Connection conn = null;
		Rank_bonus bonus = new Rank_bonus();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/apu", "sa", "");

				// SQL文を準備する
				String sql = "select * from RANK_BONUS WHERE YEAR = ? AND MONTH = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
					pStmt.setInt(1,   day.getYear());
					pStmt.setInt(2,  day.getMonth());


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
					rs.next();
					bonus.setSc_s(rs.getString("SC_S"));
					bonus.setSc_a(rs.getString("SC_A"));
			}

			catch (SQLException e) {
				e.printStackTrace();
				bonus = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				bonus = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						bonus = null;
					}
				}
			}
			// 結果を返す
			return bonus;
		}

}