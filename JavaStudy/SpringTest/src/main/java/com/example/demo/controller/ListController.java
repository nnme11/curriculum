package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.ListEntity;
import com.example.demo.service.ListService;

/**
 * タスク一覧 Controller
 */
@Controller
public class ListController {

	/**
	 * タスク一覧 Service
	 */
	@Autowired
	private ListService listService;

	/**
	 * タスク一覧画面を表示
	 * @param model Model
	 * @return タスク一覧画面
	 */
	@GetMapping(value = "/list")
	public String displayList(Model model) {
		List<ListEntity> list = listService.searchAll();
		model.addAttribute("list", list);
		return "list";
	}
}