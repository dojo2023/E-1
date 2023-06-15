package model;
import java.io.Serializable;

public class Rank_bonus implements Serializable {
	private String year;
	private String month;
	private String sc_s;
	private String sc_a;

	public Rank_bonus(String year, String month, String sc_s, String sc_a) {
		super();
		this.year = year;
		this.month = month;
		this.sc_s = sc_s;
		this.sc_a = sc_a;
	}

	public Rank_bonus() {
		super();
		this.year = "";
		this.month = "";
		this.sc_s = "";
		this.sc_a = "";
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