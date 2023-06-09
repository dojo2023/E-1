package model;
import java.io.Serializable;

public class User implements Serializable {
	private String id;
	private String l_name;
	private String f_name;
	private String pw;
	private int now_point;
	private String which;
	private String mode_shift;
	private String tetsuya;

	public User(String id, String l_name, String f_name, String pw, int now_point, String which,
			String mode_shift, String tetsuya) {
		super();
		this.id = id;
		this.l_name = l_name;
		this.f_name = f_name;
		this.pw = pw;
		this.now_point = now_point;
		this.which = which;
		this.mode_shift = mode_shift;
		this.tetsuya = tetsuya;
	}

	public User(int now_point) {
		super();
		this.now_point = now_point;
	}

	public User() {
		super();
		this.id = "";
		this.l_name = "";
		this.f_name = "";
		this.pw = "";
		this.now_point = 0;
		this.which = "";
		this.mode_shift = "";
		this.tetsuya = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public  int getNow_point() {
		return now_point;
	}

	public void setNow_point(int now_point) {
		this.now_point = now_point;
	}

	public String getWhich() {
		return which;
	}

	public void setWhich(String which) {
		this.which = which;
	}

	public String getMode_shift() {
		return mode_shift;
	}

	public void setMode_shift(String mode_shift) {
		this.mode_shift = mode_shift;
	}

	public String getTetsuya() {
		return tetsuya;
	}

	public void setTetsuya(String tetsuya) {
		this.tetsuya = tetsuya;
	}



}