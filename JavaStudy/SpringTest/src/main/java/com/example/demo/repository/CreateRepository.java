package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CreateEntity;

/**
 * タスク新規作成 Repository
 */
@Repository
public interface CreateRepository extends JpaRepository<CreateEntity, Integer> {}