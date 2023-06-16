package model;
import java.io.Serializable;

public class Point_day implements Serializable {
	private String id;
	private String year;
	private String month;
	private String day;
	private String point_b;
	private String point_p;
	private String point_m;

	public Point_day(String id, String year, String month, String day, String point_b, String point_p, String point_m) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.point_b = point_b;
		this.point_p = point_p;
		this.point_m = point_m;
	}

	public Point_day() {
		super();
		this.id = "";
		this.year = "";
		this.month = "";
		this.day = "";
		this.point_b = "";
		this.point_p = "";
		this.point_m = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPoint_b() {
		return point_b;
	}

	public void setPoint_b(String point_b) {
		this.point_b = point_b;
	}

	public String getPoint_p() {
		return point_p;
	}

	public void setPoint_p(String point_p) {
		this.point_p = point_p;
	}

	public String getPoint_m() {
		return point_m;
	}

	public void setPoint_m(String point_m) {
		this.point_m = point_m;
	}

}