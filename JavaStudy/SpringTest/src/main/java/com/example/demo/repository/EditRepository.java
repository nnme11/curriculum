package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EditEntity;

/**
 * タスク編集 Repository
 */
@Repository
public interface EditRepository extends JpaRepository<EditEntity, Integer> {}