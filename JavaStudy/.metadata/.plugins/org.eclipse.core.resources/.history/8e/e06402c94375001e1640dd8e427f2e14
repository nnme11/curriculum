package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EditRequest;
import com.example.demo.entity.EditEntity;
import com.example.demo.repository.EditRepository;

/**
 * 経費情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
//@EqualsAndHashCode(callSuper = false)
public class EditService {

	/**
	 * 経費情報 Repository
	 */
	@Autowired
	private EditRepository editRepository;

	/**
	 * 経費情報 主キー検索
	 * @return 検索結果
	 */
	public EditEntity findById(Integer task_id) {
		return editRepository.findById(task_id).get();
	}

	/**
	 * 経費情報 更新
	 */
	public void update(EditRequest editRequest) {
		EditEntity editEntity = findById(editRequest.getTask_id());
		editEntity.setTask_id(editRequest.getTask_id());
		editEntity.setTask(editRequest.getTask());
		editEntity.setDeadline(editRequest.getDeadline());
		editEntity.setStatus(editRequest.getStatus());
		editRepository.save(editEntity);
	}
}