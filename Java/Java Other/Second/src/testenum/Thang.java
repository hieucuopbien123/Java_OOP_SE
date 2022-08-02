package testenum;

// Basic - Enum

public enum Thang {
    //Nếu chỉ có giá trị không thì k sao nhưng trong java mỗi giá trị của enum có thể nhận vào params
    // Khi gọi đến bất cứ 1 giá trị nào của Thang, nó sẽ tạo ra hàng loạt các instance của Thang dựa vào số lượng
    //giá trị, mỗi giá trị là 1 instance chạy vào constructor và chạy xong nó mới chọn cái cần lấy
    JAN(31),
    FEB(29),
    MAR(31),
    APR(30);

    private final int soNgay;
    Thang(int soNgay){
        System.out.println("Constructor called: " + soNgay);
        this.soNgay = soNgay;
    }
    public int soNgay() {
        return soNgay;
    }
}
