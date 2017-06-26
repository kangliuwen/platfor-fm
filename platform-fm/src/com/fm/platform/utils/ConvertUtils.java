package com.fm.platform.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

public class ConvertUtils {


	/**
	 * 将String数组转换为Long类型数组
	 * 
	 * @param strs
	 * @return
	 */
	public static Long[] StringToLong(String[] strs) {
		Long[] longArr = new Long[strs.length];
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			Long thelong = Long.valueOf(str);
			longArr[i] = thelong;
		}
		return longArr;
	}

	/**
	 * 将Long数组转换为String类型数组
	 * 
	 * @param longs
	 * @return
	 */
	public static String[] LongToString(Long[] longs) {
		String[] strArr = new String[longs.length];
		for (int i = 0; i < longs.length; i++) {
			String str = longs[i] + "";
			strArr[i] = str;
		}
		return strArr;
	}
	
	

	/**
	 * 将null转为""
	 * 
	 * @param str
	 * @return
	 */
	public static String NVL(String str) {
		return str == null ? "" : str;
	}

	/**
	 * 将null转为""
	 * 
	 * @param obj
	 * @return
	 */
	public static String NVL(Object obj) {
		return obj == null ? "" : obj.toString();
	}

	/**
	 * obj为null时返回value,否则不变
	 * 
	 * @param obj
	 *            ,value
	 * @return object
	 */
	public static Object NVL(Object obj, Object value) {
		return obj == null ? value : obj;
	}

	/**
	 * 解析字符串为Long类型，若字符串是无效的Long型数据，则返回null，否则返回Long型数据
	 * 
	 * @param sLongId
	 * @return
	 */
	public static Long parseLong(String sLong) {
		Long l = null;
		try {
			l = (sLong == null) ? null : Long.parseLong(sLong);
		} catch (Exception e) {
			l = null;
		}
		return l;
	}

	/**
	 * 右补填字符串，为长度length的字符串，例如将字符串右补空格：'123'->'123 '
	 * 
	 * @param str
	 * @param length
	 *            长度
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String fillSpace(String str, int length)
			throws UnsupportedEncodingException {
		if (str == null)
			str = "";
		int fill_length = length - str.getBytes().length;
		// System.out.println(str+" 不齐空格长度："+fill_length);
		for (int i = 0; i < fill_length; i++) {
			str += " ";
		}

		return str;
	}

	/**
	 * 右补填字符串，为长度length的字符串，例如将字符串右补空格：'123'->'123 '
	 * 
	 * @param str
	 * @param length
	 *            长度
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String fillLeftSpace(String str, int length)
			throws UnsupportedEncodingException {
		if (str == null)
			str = "";

		int fill_length = length - str.getBytes().length;

		for (int i = 0; i < fill_length; i++) {
			str = " " + str;
		}

		return str;
	}
	/**
	 * 报错信息输出
	 * @param e
	 * @return
	 */
	public static String getMessage(Exception e){
		if(e!=null && e.getStackTrace().length>0){
			if("com.xyzq.platform.exception.BusinessException".equals(e.getClass().getName())){
				return e.getMessage();
			}
		   	  return getStackTrace(e);
		}else{
		   	  return "Exception is null";
		}
   	 
	}
	
	/**
	* 获取异常的堆栈信息
	* 
	* @param t
	* @return
	*/
	private static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		try {
			t.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}
	}
}
