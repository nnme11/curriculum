package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * CREATE Entity
 */
@Data
@Entity
@Table(name = "task")
public class EditEntity {
	
	/**
	 * タスク ID
	 */

	@Id
	@Column(name = "task_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer task_id;
	
	/**
	 * やること
	 */
	@Column(name = "task")
	private String task;

	/**
	 * 締切
	 */
	@Column(name = "deadline")
	private LocalDate deadline;
	
	/**
	 * ステータス
	 */
	@Column(name = "status")
	private String status;
	
}