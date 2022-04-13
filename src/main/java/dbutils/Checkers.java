package dbutils;

public class Checkers {
	
	public boolean isReserved(Integer id) {
			if (id>10) {
				return false;
			}else {
				return true;
			}
			
		}
	
	public boolean isBlocked(Integer id) {
		if (id>10) {
			return false;
		}else {
			return true;
		}
		
	}
	
	
}
