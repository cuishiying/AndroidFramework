package com.irelint.framework.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class GsonTools {
	private static GsonTools instance;
	private static Gson gson;
	public GsonTools() {
		instance = this;
		gson = new Gson();
	}
	public static synchronized GsonTools getInstance(){
		if (instance == null) {
			instance = new GsonTools();
		}
		return instance;
	}

	public String createGsonString(Object object) {
		String gsonString = gson.toJson(object);
		return gsonString;
	}

	public <T> T changeGsonToBean(String gsonString, Class<T> cls) {
		T t = gson.fromJson(gsonString, cls);
		return t;
	}

	//该方法需要在方法中单独调用
	public <T> List<T> changeGsonToList(String gsonString, Class<T> cls) {
		List<T> list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
		}.getType());
		return list;
	}
	
	public <T> List<Map<String, T>> changeGsonToListMaps(
			String gsonString) {
		List<Map<String, T>> list = null;
		list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>() {
		}.getType());
		return list;
	}

	public <T> Map<String, T> changeGsonToMaps(String gsonString) {
		Map<String, T> map = null;
		map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
		}.getType());
		return map;
	}

}
