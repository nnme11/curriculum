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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.EditRequest;
import com.example.demo.entity.EditEntity;
import com.example.demo.service.EditService;

/**
 * タスク編集 Controller
 */
@Controller
public class EditController {

	/**
	 * タスク編集 Service
	 */
	@Autowired
	private EditService editService;

	/**
	 * タスク編集画面を表示
	 * @param model Model
	 * @return タスク編集画面
	 */
	@GetMapping(value = "/user/{task_id}/edit")
	public String displayEdit(@PathVariable Integer task_id, Model model) {
		EditEntity user = editService.findById(task_id);
		EditRequest editRequest = new EditRequest();
		editRequest.setTask_id(user.getTask_id());
		editRequest.setTask(user.getTask());
		editRequest.setDeadline(user.getDeadline());
		editRequest.setStatus(user.getStatus());
		model.addAttribute("editRequest", editRequest);
		return "edit";
	}

	/**
	 * タスク編集
	 * @param editRequest リクエストデータ
	 * @param model Model
	 * @return タスク一覧画面
	 */
	@PostMapping("edit/create")
	public String edit(@Validated @ModelAttribute EditRequest editRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "edit";
		}
		// タスク編集
		editService.update(editRequest);
		return "/list";
	}

}