package testcomparable;

// Collection Framework trong java

//Java có sẵn 1 interface Comparable có hàm compareTo để thực hiện việc so sánh cho object
public class SinhVien implements Comparable<SinhVien> {
    private int maSinhVien;
	private String hoVaTen;
	
	public SinhVien(int maSinhVien, String hoVaTen) {
		this.maSinhVien = maSinhVien;
		this.hoVaTen = hoVaTen;
	}

	public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getTen() {
		String s = this.hoVaTen.trim();
		if(s.indexOf(" ")>=0) {
			int vt = s.lastIndexOf(" ");
			return s.substring(vt+1);
		}else {
			return s;
		}
	}
    //sắp xếp theo tên
    @Override
    public int compareTo(SinhVien o) {
        String tenThis = this.getTen();
		String tenO = o.getTen();
		
		return tenThis.compareTo(tenO);//cái này khác là compareTo của String có sẵn
        //nó phải return ra 3 TH > = < 0
    }
}
