package util;

import java.util.List;

public class QueryUtil {
	
	public static <T> T getSingleResult(List<T> values) {
		if (values.isEmpty()) {
			return null;
		}
		return values.get(0);
	}

}
