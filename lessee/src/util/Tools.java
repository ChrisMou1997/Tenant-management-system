package util;

import java.util.Calendar;
import java.util.Vector;

public class Tools {

	//��ȡ�꼶
		public static Vector<String> Createage(){
			Vector<String> vector = new Vector<String>();
			vector.add("");	//���һ����ѡ�� 
			Calendar c = Calendar.getInstance();
			int Year = c.get(Calendar.YEAR);
			for(int i=0;i<4;i++){
				vector.add(String.valueOf(Year--));
			}
			return vector;
			
		}
}
