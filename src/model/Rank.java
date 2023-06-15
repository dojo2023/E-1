package model;
import java.io.Serializable;

public class Rank implements Serializable {
	private String c_start;
	private String b_start;
	private String a_start;
	private String s_start;

	public Rank(String c_start, String b_start, String a_start, String s_start) {
		super();
		this.c_start = c_start;
		this.b_start = b_start;
		this.a_start = a_start;
		this.s_start = s_start;
	}

	public Rank() {
		super();
		this.c_start = "";
		this.b_start = "";
		this.a_start = "";
		this.s_start = "";
	}

	public String getC_start() {
		return c_start;
	}

	public void setC_start(String c_start) {
		this.c_start = c_start;
	}

	public String getB_start() {
		return b_start;
	}

	public void setB_start(String b_start) {
		this.b_start = b_start;
	}

	public String getA_start() {
		return a_start;
	}

	public void setA_start(String a_start) {
		this.a_start = a_start;
	}

	public String getS_start() {
		return s_start;
	}

	public void setS_start(String s_start) {
		this.s_start = s_start;
	}
}