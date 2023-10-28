package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EditRequest;
import com.example.demo.entity.EditEntity;
import com.example.demo.repository.EditRepository;

/**
 * タスク編集 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
//@EqualsAndHashCode(callSuper = false)
public class EditService {

	/**
	 * タスク編集 Repository
	 */
	@Autowired
	private EditRepository editRepository;

	/**
	 * タスク編集 主キー検索
	 * @return 検索結果
	 */
	public EditEntity findById(Integer task_id) {
		return editRepository.findById(task_id).get();
	}

	/**
	 * タスク編集 更新
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
	 * タスク編集 削除
	 */
	public void delete(Integer task_id) {
		EditEntity editEntity = findById(task_id);
		editRepository.delete(editEntity);
	}
	
}