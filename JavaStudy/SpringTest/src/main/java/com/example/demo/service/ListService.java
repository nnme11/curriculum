package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ListEntity;
import com.example.demo.repository.ListRepository;

/**
 * タスク一覧 Service
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class ListService {
	
	/**
	 * タスク一覧 Repository
	 */
	@Autowired
	private ListRepository expenseListRepository;

	/**
	 * タスク一覧 全検索
	 * @return 検索結果
	 */
	public List<ListEntity> searchAll() {
		return expenseListRepository.findAll();
	}
}