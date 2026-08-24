package DSA;

import java.util.HashMap;

public class FreqOfWords {
	public static void main(String[] args) {
		String string="Hello This Is India This is Land of Sacred rivers and rivers flow From west to east.";
		String[] words = string.toLowerCase().split("[^a-zA-Z]+");
		HashMap<String,Integer> hs=new HashMap<>();
		for(String str:words) {
			hs.put(str, hs.getOrDefault(str, 0)+1);
		}
		hs.forEach((key,value)->System.out.println(key+" -> "+value));
	}

}
