package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.CreateRequest;
import com.example.demo.service.CreateService;

/**
 * タスク新規登録 Controller
 */
@Controller
public class CreateController {

	/**
	 * タスク新規登録 Service
	 */
	@Autowired
	private CreateService createService;


	/**
	 * タスク新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/create")
	public String displayAdd(Model model) {
		model.addAttribute("createRequest", new CreateRequest());
		return "create";
	}

	/**
	 * タスク新規登録
	 * @param createRequest リクエストデータ
	 * @param model Model
	 * @return タスク一覧画面
	 */
	@PostMapping("/create/create")
	public String create(@Validated @ModelAttribute CreateRequest createRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "create";
		}
		// タスク新規登録
		createService.create(createRequest);
		return "redirect:/create";
	}

}