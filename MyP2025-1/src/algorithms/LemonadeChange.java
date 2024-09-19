package algorithms;

import java.util.HashMap;

public class LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        dict.put(5, 0);
        dict.put(10, 0);
        for(int i = 0; i < bills.length; i++) {
            switch(bills[i]) {
                case 5:
                    dict.put(5, dict.get(5)+1);
                    break;
                case 10:
                    if(dict.get(5) == null) {
                        return false;
                    } else {
                        dict.put(5, dict.get(5)-1);
                        dict.put(10, dict.get(10)+1);
                    }
                    break;
                case 20:
                    if (dict.get(10) >= 1 && dict.get(5) >= 1) {
                        dict.put(10, dict.get(10)-1);
                        dict.put(5, dict.get(5)-1);
                    } else if(dict.get(5) >= 3) {
                        dict.put(5, dict.get(5)-3);
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
