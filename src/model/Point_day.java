package model;
import java.io.Serializable;

public class Point_day implements Serializable {
	private String id;
	private int year;
	private int month;
	private int day;
	private int point_b;
	private int point_p;
	private int point_m;

	public Point_day(String id, int year, int month, int day, int point_b, int point_p, int point_m) {
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
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getPoint_b() {
		return point_b;
	}
	public void setPoint_b(int point_b) {
		this.point_b = point_b;
	}
	public int getPoint_p() {
		return point_p;
	}
	public void setPoint_p(int point_p) {
		this.point_p = point_p;
	}
	public int getPoint_m() {
		return point_m;
	}
	public void setPoint_m(int point_m) {
		this.point_m = point_m;
	}

	}