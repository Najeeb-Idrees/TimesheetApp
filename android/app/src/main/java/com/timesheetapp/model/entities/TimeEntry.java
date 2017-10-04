package com.timesheetapp.model.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.timesheetapp.model.db.DBConstant;


import java.io.Serializable;

/**
 * Created by Najeeb.Idrees on 04-Oct-17.
 */

@DatabaseTable(tableName = DBConstant.TABLE_TIME_ENTRY)
public class TimeEntry implements Serializable
{
	public static final String _ID = "_id";
	public static final String PROJECT = "project";
	public static final String ACTIVITY = "activity";
	public static final String TASK_DESCRIPTION = "task_description";
	public static final String HOUR = "hour";
	public static final String IS_BOOKMARKED = "IS_BOOKMARKED";

	@DatabaseField(generatedId = true, columnName = _ID)
	private Integer id;

	@DatabaseField(columnName = PROJECT)
	private String project;

	@DatabaseField(columnName = ACTIVITY)
	private String activity;

	@DatabaseField(columnName = TASK_DESCRIPTION)
	private String taskDescription;

	@DatabaseField(columnName = HOUR)
	private double hour;

	@DatabaseField(columnName = IS_BOOKMARKED)
	private boolean is_bookmarked;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getProject()
	{
		return project;
	}

	public void setProject(String project)
	{
		this.project = project;
	}

	public String getActivity()
	{
		return activity;
	}

	public void setActivity(String activity)
	{
		this.activity = activity;
	}

	public String getTaskDescription()
	{
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription)
	{
		this.taskDescription = taskDescription;
	}

	public double getHour()
	{
		return hour;
	}

	public void setHour(double hour)
	{
		this.hour = hour;
	}

	public boolean is_bookmarked()
	{
		return is_bookmarked;
	}

	public void setIs_bookmarked(boolean is_bookmarked)
	{
		this.is_bookmarked = is_bookmarked;
	}
}
