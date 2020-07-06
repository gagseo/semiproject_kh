package common;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DataSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataSetting() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JDBCTemplate jdt = JDBCTemplate.getInstance();
		Connection conn = jdt.getConnection();
		PreparedStatement pstm = null;

		String sql = "insert into smw_market values(m_number.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pstm = conn.prepareStatement(sql);
			String prefix = getServletContext().getRealPath("/");
			System.out.println(prefix);
			JsonObject jobj = new Gson().fromJson(
					new FileReader(new File(prefix + "WebContent/resources/전국전통시장표준데이터.json")), JsonObject.class);

			JsonArray datas = jobj.getAsJsonArray("records");

			for (JsonElement j : datas) {

				JsonObject marketInfo = j.getAsJsonObject();


				pstm.setString(1, marketInfo.get("시장명").getAsString());
				pstm.setString(2, marketInfo.get("소재지도로명주소").getAsString());
				pstm.setString(3, marketInfo.get("소재지지번주소").getAsString());
				pstm.setString(4, marketInfo.get("시장개설주기").getAsString());
				pstm.setString(5, marketInfo.get("전화번호").getAsString());
				pstm.setString(6, marketInfo.get("사용가능상품권").getAsString());
				pstm.setString(7, marketInfo.get("공중화장실보유여부").getAsString());
				pstm.setString(8, marketInfo.get("주차장보유여부").getAsString());
				pstm.setString(9, marketInfo.get("홈페이지주소").getAsString());
				pstm.setString(10, marketInfo.get("시장유형").getAsString());
				pstm.setString(11, marketInfo.get("위도").getAsString());
				pstm.setString(12, marketInfo.get("경도").getAsString());
				pstm.setInt(13, marketInfo.get("점포수").getAsInt());
				pstm.setString(14, marketInfo.get("취급품목").getAsString());
				

				pstm.executeUpdate();
			}

			jdt.commit(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(pstm);
			jdt.close(conn);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
