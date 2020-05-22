package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Long id;
	
	@Column(name = "task_name")
	private String taskName;
	
	@Column(name = "task_desc")
	private String taskDescription;
	
	@Column(name = "task_assignedto")
	private String assignedTo;
	
	@Column(name = "task_startdate")
	private String startDate;
	
	@Column(name = "task_enddate")
	private String endDate;
	
	@Column(name = "task_completed")
	private boolean completed;
	
	
}
