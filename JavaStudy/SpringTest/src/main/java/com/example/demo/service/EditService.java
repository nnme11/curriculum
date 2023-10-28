package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EditRequest;
import com.example.demo.entity.EditEntity;
import com.example.demo.repository.EditRepository;

/**
 * タスク Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
//@EqualsAndHashCode(callSuper = false)
public class EditService {

	/**
	 * タスク Repository
	 */
	@Autowired
	private EditRepository editRepository;

	/**
	 * タスク 主キー検索
	 * @return 検索結果
	 */
	public EditEntity findById(Integer task_id) {
		return editRepository.findById(task_id).get();
	}

	/**
	 * タスク 更新
	 */
	public void update(EditRequest editRequest) {
		EditEntity editEntity = findById(editRequest.getTask_id());
		editEntity.setTask_id(editRequest.getTask_id());
		editEntity.setTask(editRequest.getTask());
		editEntity.setDeadline(editRequest.getDeadline());
		editEntity.setStatus(editRequest.getStatus());
		editRepository.save(editEntity);
	}
	
	/**
	 * タスク 削除
	 */
	public void delete(Integer task_id) {
		EditEntity editEntity = findById(task_id);
		editRepository.delete(editEntity);
	}
	
}