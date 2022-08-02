package testfunction;

import java.util.Objects;

// Basic - Other - hashcode

public class FirstClass {
    public int number = 1;

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
	//có thể cho tự sinh ra hashCode và equals cho CT
	//getclass sẽ trả ra class hiện tại của object
	//hàm hashCode nó kiểu như trên
	//phương thức equals có sẵn vốn dĩ chả bh so sánh được 2 object bằng nhau mà ta phải tự override lại
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FirstClass other = (FirstClass) obj;
		return number == other.number;
	}
}
