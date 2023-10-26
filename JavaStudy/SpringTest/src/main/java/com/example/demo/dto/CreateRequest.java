package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * タスク新規作成 リクエストデータ
 */
@Data
public class CreateRequest implements Serializable {

	private Integer task_id;
	
	/**
	 * タスク
	 */
	@NotEmpty(message = "タスクを入力してください")
	@Size(max = 50, message = "項目は50文字以内で入力してください")
	private String task;
	
	/**
	 * 締切
	 */
	@NotNull(message = "締切を入力してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate deadline;
	
	/**
	 * ステータス
	 */
	@NotEmpty(message = "ステータスを入力してください")
	private String status;
	
}