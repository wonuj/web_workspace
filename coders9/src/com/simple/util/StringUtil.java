package com.simple.util;

public class StringUtil {

	/**
	 * 臾몄옄�뿴 媛믪씠 null�씠硫� 吏��젙�맂 defaultValue媛믪쓣 諛섑솚�븳�떎
	 * @param str null�씤吏� 泥댄겕�븷 臾몄옄�뿴
	 * @param defaultValue null�씪�븣 諛섑솚�븷 湲곕낯媛�
	 * @return
	 */
	public static String nullToValue(String str, String defaultValue) {
		if(str == null) {
			return defaultValue;
		}
		return str;
	}
	
	/**
	 * 臾몄옄�뿴 媛믪씠 null�씠硫� ""�쓣 諛섑솚�븳�떎.
	 * @param str null�씤吏� 泥댄겕�븷 臾몄옄�뿴
	 * @return
	 */
	public static String nullToBlank(String str) {		
		return nullToValue(str, "");
	}
	
	 
	/**
	 * 臾몄옄�뿴�쓽 以꾨컮轅덈Ц�옄瑜� &lt:br&gr;濡� 蹂��솚�빐�꽌 諛섑솚�븳�떎.
	 * @param text
	 * @return
	 */
	public static String strWithBr(String text) {
		if(text == null) {
			return "";
		}
		return text.replace(System.lineSeparator(), "<br/>");
	}
}
