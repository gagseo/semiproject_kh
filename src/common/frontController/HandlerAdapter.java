package common.frontController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerAdapter {

	/**
	 * common.frontController HandlerAdapter.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 24.
	 * @해야할일 :TODO
	 *
	 * @param ctr
	 * @param methodName
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView excute(Controller ctr, String methodName, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mav = null;

		Class c = ctr.getClass();

		try {
			Method exMethod = c.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

			mav = (ModelAndView) exMethod.invoke(ctr, request, response);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return mav;

	}

}
