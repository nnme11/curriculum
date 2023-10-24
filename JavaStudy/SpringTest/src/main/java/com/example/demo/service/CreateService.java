package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CreateRequest;
import com.example.demo.entity.CreateEntity;
import com.example.demo.repository.CreateRepository;

/**
 * タスク新規作成 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CreateService {
  /**
   * タスク新規作成 Repository
   */
  @Autowired
  private CreateRepository createRepository;

  /**
   * 
   * @param create タスク新規作成
   */
  public void create(CreateRequest createRequest) {
    Date now = new Date();
    CreateEntity create = new CreateEntity();
    create.setTask_id(createRequest.getTask_id());
    create.setTask(createRequest.getTask());
    create.setDeadline(createRequest.getDeadline());
    create.setStatus(createRequest.getStatus());
    createRepository.save(create);
  }
}