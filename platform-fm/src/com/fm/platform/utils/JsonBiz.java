package com.fm.platform.utils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.log4j.Logger;
public class JsonBiz {

	  public static Logger log = Logger.getLogger(JsonBiz.class);

	  public static JSONObject getJsonDataForPage(List<?> list, int iRecords, int pageSize)
	  {
	    JSONObject result = new JSONObject();
	    result.put("succeed", Boolean.valueOf(true));
	    try {
	      JSONObject dataObj = new JSONObject();
	      dataObj.put("total", Integer.valueOf(iRecords));
	      dataObj.put("pagesize", Integer.valueOf(pageSize));

	      JSONArray dataArr = new JSONArray();
	      Iterator i$;
	      if (list != null) {
	        for (i$ = list.iterator(); i$.hasNext(); ) { Object o = i$.next();
	          if (o != null) {
	            Class c = o.getClass();
	            if ((c.isArray()) || ((o instanceof List)))
	              dataArr.add(JSONArray.toJSON(o));
	            else {
	              dataArr.add(JSONObject.toJSON(o));
	            }
	          }
	        }
	      }
	      dataObj.put("rows", dataArr);
	      result.put("data", dataObj);
	    } catch (Exception e) {
	      log.error(ConvertUtils.getMessage(e), e);
	      result.put("succeed", Boolean.valueOf(false));
	      result.put("error", "出错");
	      result.put("error_detail", ConvertUtils.getMessage(e));
	    }
	    return result;
	  }

	  public static JSONObject getJsonDataForOneRecord(Object object)
	  {
	    JSONObject result = new JSONObject();
	    result.put("succeed", Boolean.valueOf(true));
	    try {
	      if (object != null) {
	        Class c = object.getClass();
	        if ((object instanceof String)) {
	          result.put("data", JSONObject.parse((String)object));
	        }
	        else if ((c.isArray()) || ((object instanceof List)))
	          result.put("data", JSONArray.toJSON(object));
	        else
	          result.put("data", JSONObject.toJSON(object));
	      }
	    }
	    catch (Exception e) {
	      log.error(ConvertUtils.getMessage(e), e);
	      result.put("succeed", Boolean.valueOf(false));
	      result.put("error", "出错");
	      result.put("error_detail", ConvertUtils.getMessage(e));
	    }
	    return result;
	  }

	  public static JSONObject getJsonDataForOneRecord(Object object, Map<String, Object> props)
	  {
	    JSONObject result = new JSONObject();
	    result.put("succeed", Boolean.valueOf(true));
	    try {
	      if (object != null) {
	        Class c = object.getClass();
	        if ((object instanceof String)) {
	          result.put("data", JSONObject.parse((String)object));
	        }
	        else if ((c.isArray()) || ((object instanceof List))) {
	          result.put("data", JSONArray.toJSON(object));
	        } else {
	          JSONObject data = (JSONObject)JSONObject.toJSON(object);
	          if ((props != null) && (!props.isEmpty())) {
	            Iterator iterator = props.entrySet().iterator();
	            while (iterator.hasNext()) {
	              Map.Entry entry = (Map.Entry)iterator.next();
	              data.put((String)entry.getKey(), JSONObject.toJSON(entry.getValue()));
	            }
	          }
	          result.put("data", data);
	        }
	      }
	    } catch (Exception e) {
	      log.error(ConvertUtils.getMessage(e), e);
	      result.put("succeed", Boolean.valueOf(false));
	      result.put("error", "出错");
	      result.put("error_detail", ConvertUtils.getMessage(e));
	    }
	    return result;
	  }

	  public static JSONObject getJsonDataForOption(List<?> list)
	  {
	    JSONObject result = new JSONObject();
	    result.put("succeed", Boolean.valueOf(true));
	    try {
	      JSONObject dataObj = new JSONObject();
	      JSONArray dataArr = new JSONArray();
	      Iterator i$;
	      if (list != null) {
	        for (i$ = list.iterator(); i$.hasNext(); ) { Object o = i$.next();
	          if (o != null) {
	            Class c = o.getClass();
	            if ((c.isArray()) || (c.isInstance(List.class)))
	              dataArr.add(JSONArray.toJSON(o));
	            else {
	              dataArr.add(JSONObject.toJSON(o));
	            }
	          }
	        }
	      }
	      dataObj.put("list", dataArr);
	      result.put("data", dataObj);
	    }
	    catch (Exception e) {
	      log.error(ConvertUtils.getMessage(e), e);
	      result.put("succeed", Boolean.valueOf(false));
	      result.put("error", "出错");
	      result.put("error_detail", ConvertUtils.getMessage(e));
	    }
	    return result;
	  }

	  public static JSONObject getJsonError(Exception e)
	  {
	    JSONObject jsonObject = new JSONObject();
	    jsonObject.put("succeed", Boolean.valueOf(false));
	    jsonObject.put("error", "出错");
	    jsonObject.put("error_detail", ConvertUtils.getMessage(e));
	    return jsonObject;
	  }

	  public static JSONObject isSucceed(boolean b, String msg)
	  {
	    JSONObject jsonObject = new JSONObject();
	    if (b == true) {
	      jsonObject.put("success", Boolean.valueOf(true));
	      JSONObject subJSONObject = new JSONObject();
	      subJSONObject.put("success", Boolean.valueOf(true));
	      subJSONObject.put("msg", msg);
	      jsonObject.put("data", subJSONObject);
	    } else {
	      jsonObject.put("success", Boolean.valueOf(true));
	      JSONObject subJSONObject = new JSONObject();
	      subJSONObject.put("success", Boolean.valueOf(false));
	      subJSONObject.put("msg", msg);
	      jsonObject.put("data", subJSONObject);
	    }
	    return jsonObject;
	  }

	  public static JSONObject isSucceed(boolean b, Object result)
	  {
	    JSONObject jsonObject = new JSONObject();
	    jsonObject.put("succeed", Boolean.valueOf(true));
	    JSONObject subJSONObject = new JSONObject();
	    subJSONObject.put("succeed", Boolean.valueOf(b));
	    if ((result instanceof Collection))
	      subJSONObject.put("msg", JSONArray.toJSON(result));
	    else {
	      subJSONObject.put("msg", JSONObject.toJSON(result));
	    }
	    jsonObject.put("data", subJSONObject);
	    return jsonObject;
	  }

	  public static JSONObject returnJsonToPage() {
	    return JSONObject.parseObject("{\"succeed\":true}");
	  }

	  public static JSONObject getJsonDataForEasyUi(List<?> list, int iRecords)
	  {
	    JSONObject result = new JSONObject();
	    result.put("total", Integer.valueOf(iRecords));
	    try {
	      JSONArray dataArr = new JSONArray();
	      Iterator i$;
	      if (list != null) {
	        for (i$ = list.iterator(); i$.hasNext(); ) { Object o = i$.next();
	          if (o != null) {
	            Class c = o.getClass();
	            if ((c.isArray()) || ((o instanceof List)))
	              dataArr.add(JSONArray.toJSON(o));
	            else {
	              dataArr.add(JSONObject.toJSON(o));
	            }
	          }
	        }
	      }
	      result.put("rows", dataArr);
	    } catch (Exception e) {
	      log.error(ConvertUtils.getMessage(e), e);
	      result.put("succeed", Boolean.valueOf(false));
	      result.put("error", "出错");
	      result.put("error_detail", ConvertUtils.getMessage(e));
	    }
	    return result;
	  }

	/*  public static JSONObject getJsonDataForCombogrid(List<?> list, int totalCount, Paging p)
	  {
	    JSONObject returnData = getJsonDataForJQGridUi(list, totalCount, p);
	    returnData.put("records", Integer.valueOf(totalCount));
	    returnData.put("total", returnData.get("totalPage"));
	    return returnData;
	  }

	  public static JSONObject getJsonDataForJQGridUi(List<?> list, int totalCount, Paging p, Map<String, Object> otherReturn)
	  {
	    JSONObject result = getJsonDataForJQGridUi(list, totalCount, p);
	    result.putAll(otherReturn);
	    return result;
	  }

	  public static JSONObject getJsonDataForJQGridUi(List<?> list, int totalCount, Paging p)
	  {
	    int page = p.getPage();
	    int rows = p.getRows();
	    int total = 1;
	    if (totalCount % rows != 0)
	      total = totalCount / rows + 1;
	    else {
	      total = totalCount / rows;
	    }
	    JSONObject result = new JSONObject();
	    result.put("totalCount", Integer.valueOf(totalCount));
	    result.put("page", Integer.valueOf(page));
	    result.put("totalPage", Integer.valueOf(total));
	    try {
	      JSONArray dataArr = new JSONArray();
	      Iterator i$;
	      if (list != null) {
	        for (i$ = list.iterator(); i$.hasNext(); ) { Object o = i$.next();
	          if (o != null) {
	            Class c = o.getClass();
	            if ((c.isArray()) || ((o instanceof List)))
	              dataArr.add(JSONArray.toJSON(o));
	            else {
	              dataArr.add(JSONObject.toJSON(o));
	            }
	          }
	        }
	      }
	      result.put("rows", dataArr);
	    } catch (Exception e) {
	      log.error(ConvertUtils.getMessage(e), e);
	      result.put("succeed", Boolean.valueOf(false));
	      result.put("error", "出错");
	      result.put("error_detail", ConvertUtils.getMessage(e));
	    }
	    return result;
	  }

	  public static JSONObject getJsonDataForJQGridUi(List<?> list, int totalCount, Paging p, List<?> listCountAll)
	  {
	    int page = p.getPage();
	    int rows = p.getRows();
	    int total = 1;
	    if (totalCount % rows != 0)
	      total = totalCount / rows + 1;
	    else {
	      total = totalCount / rows;
	    }
	    JSONObject result = new JSONObject();
	    result.put("totalCount", Integer.valueOf(totalCount));
	    result.put("page", Integer.valueOf(page));
	    result.put("totalPage", Integer.valueOf(total));
	    try {
	      JSONArray dataArr = new JSONArray();
	      Iterator i$;
	      if (list != null) {
	        for (i$ = list.iterator(); i$.hasNext(); ) { Object o = i$.next();
	          if (o != null) {
	            Class c = o.getClass();
	            if ((c.isArray()) || ((o instanceof List)))
	              dataArr.add(JSONArray.toJSON(o));
	            else {
	              dataArr.add(JSONObject.toJSON(o));
	            }
	          }
	        }
	      }
	      result.put("rows", dataArr);
	      if ((null != listCountAll) && (!listCountAll.isEmpty())) {
	        if (null != listCountAll.get(0)) {
	          JSONObject jsonObject1 = (JSONObject)JSONObject.toJSON(listCountAll.get(0));
	          result.put("userdata", jsonObject1);
	        } else {
	          result.put("userdata", "");
	        }
	      }
	      else result.put("userdata", ""); 
	    }
	    catch (Exception e)
	    {
	      log.error(ConvertUtils.getMessage(e), e);
	      result.put("succeed", Boolean.valueOf(false));
	      result.put("error", "出错");
	      result.put("error_detail", ConvertUtils.getMessage(e));
	    }
	    return result;
	  }*/

	  public static JSONObject getTreeJsonForZTree(List<Map<String, Object>> listMap)
	  {
	    JSONObject result = new JSONObject();
	    result.put("succeed", Boolean.valueOf(true));
	    try {
	      JSONObject dataObj = new JSONObject();
	      if ((null != listMap) && (!listMap.isEmpty())) {
	        dataObj.put("list", JSONArray.toJSON(listMap));
	        result.put("data", dataObj);
	      }
	    } catch (Exception e) {
	      log.error(ConvertUtils.getMessage(e), e);
	      result.put("succeed", Boolean.valueOf(false));
	      result.put("error", "出错");
	      result.put("error_detail", ConvertUtils.getMessage(e));
	    }
	    return result;
	  }

	  public static JSONObject getTreeJsonForZTreeObject(List<?> listMap)
	  {
	    JSONObject result = new JSONObject();
	    result.put("succeed", Boolean.valueOf(true));
	    try {
	      JSONObject dataObj = new JSONObject();
	      if ((null != listMap) && (!listMap.isEmpty())) {
	        dataObj.put("list", JSONArray.toJSON(listMap));
	        result.put("data", dataObj);
	      }
	    } catch (Exception e) {
	      log.error(ConvertUtils.getMessage(e), e);
	      result.put("succeed", Boolean.valueOf(false));
	      result.put("error", "出错");
	      result.put("error_detail", ConvertUtils.getMessage(e));
	    }
	    return result;
	  }
}
