package com.market.service.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.frontController.Controller;
import common.frontController.ModelAndView;

public class ServiceController implements Controller {

	/**
	 * com.market.service.controller ServiceController.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 24.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView support(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setView("service/support");

		return mav;
	}

}
