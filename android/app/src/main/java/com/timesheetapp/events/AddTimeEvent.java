package com.timesheetapp.events;

/**
 * Created by Najeeb.Idrees on 04-Oct-17.
 */

public class AddTimeEvent
{
	private boolean isAdded;

	public AddTimeEvent(boolean isAdded)
	{
		this.isAdded = isAdded;
	}

	public boolean isAdded()
	{
		return isAdded;
	}
}
