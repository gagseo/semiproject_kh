package com.market.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.frontController.Controller;
import common.frontController.ModelAndView;

public class IndexController implements Controller {

	/**
	 * com.market.index.controller
	 * IndexController.java
	 *
	 * @작성자 : Ryan Oh
	 * @작업일 : 2020. 4. 23.
	 * @해야할일 :TODO
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		mav.setView("index/index");
		return mav;
	}
}
