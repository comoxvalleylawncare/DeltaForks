package com.deltaforks;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * forks, deltas and the transformational artifacts(FP declaration) between them
 * @author tertioptus
 *
 */
public abstract class Solution {

	static protected void fork(Prong... prongs) {
		for (Prong prong : prongs) {
			prong.strike();
		}
	}

	/**
	 * Decorator abstraction
	 * 
	 * @param initialState
	 * @param stateClasses
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	static protected <T> T delta(T initialState, Class<T>... stateClasses)
			throws NoSuchMethodException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		T finalState = initialState;
		if (stateClasses.length > 0) {
			T nextState = initialState;
			for (Class<T> stateClass : stateClasses) {
				Constructor<T> constructor = stateClass
						.getConstructor(stateClass);
				nextState = constructor.newInstance(new Object[] { nextState });
			}
			finalState = nextState;
		}
		return finalState;
	}
}
