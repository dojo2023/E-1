package model;
import java.io.Serializable;

public class Rank_bonus implements Serializable {
	private int year;
	private int month;
	private String sc_s;
	private String sc_a;

	public Rank_bonus(int year, int month, String sc_s, String sc_a) {
		super();
		this.year = year;
		this.month = month;
		this.sc_s = sc_s;
		this.sc_a = sc_a;
	}

	public Rank_bonus() {
		super();
		this.year = 0;
		this.month = 0;
		this.sc_s = "";
		this.sc_a = "";
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

	public String getSc_s() {
		return sc_s;
	}

	public void setSc_s(String sc_s) {
		this.sc_s = sc_s;
	}

	public String getSc_a() {
		return sc_a;
	}

	public void setSc_a(String sc_a) {
		this.sc_a = sc_a;
	}

}