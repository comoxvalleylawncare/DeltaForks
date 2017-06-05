package com.deltaforks;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Elegance {
	
	Map<String, Class> memoryMap = new HashMap<String, Class>();

	protected void selection(Option... options) {
		for (Option option : options) {
			option.select();
		}
	}

	protected <T> T description(T subject,
			@SuppressWarnings("unchecked") Class<T>... characterization)
			throws NoSuchMethodException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {

		return Solution.delta(subject, characterization);
	}

	// action
	
	
	protected <T> T the(Class<T> type) {
		return Solution.singular(type);
	} 
	
	protected <T> T the(String name, Class<T> type) {
		return null;
	
	}
	
	protected <T> T the(String name) {
		return null;
	}
}
