package com.timesheetapp.events;

/**
 * Created by Najeeb.Idrees on 04-Oct-17.
 */

public interface RowListener<T>
{
	public void rowTap(T agr, int pos);

	public void rowLongPress(T agr, int pos);
}
