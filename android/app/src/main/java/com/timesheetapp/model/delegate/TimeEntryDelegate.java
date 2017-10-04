package com.timesheetapp.model.delegate;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.timesheetapp.MainApplication;
import com.timesheetapp.model.entities.TimeEntry;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Najeeb.Idrees on 04-Oct-17.
 */

public class TimeEntryDelegate
{
	private Dao<TimeEntry, Integer> TimeEntryDao;
	private QueryBuilder<TimeEntry, Integer> qb;

	public TimeEntryDelegate()
	{
		TimeEntryDao = MainApplication.dbHelper.getTimeEntryDao();
		qb = TimeEntryDao.queryBuilder();
	}

	public TimeEntry get(Integer id)
	{
		try
		{
			qb.where().eq(TimeEntry._ID, id);
			return qb.queryForFirst();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}


	public List<TimeEntry> getAll()
	{
		try
		{
			return qb.query();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public List<TimeEntry> getAllBookmarked(boolean isBokmarked)
	{
		try
		{
			qb.where().eq(TimeEntry.IS_BOOKMARKED, isBokmarked);
			return qb.query();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public List<TimeEntry> getAllTemplatesByCandidateId(Integer id)
	{
		try
		{
			qb.where().eq(TimeEntry._ID, id);
			return qb.query();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}


	public int delete(TimeEntry TimeEntry)
	{
		DeleteBuilder<TimeEntry, Integer> deleteBuilder = TimeEntryDao.deleteBuilder();

		try
		{
			deleteBuilder.where().eq(TimeEntry._ID, TimeEntry.getId());
			return deleteBuilder.delete();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return -1;
	}


	public boolean deleteAll()
	{
		try
		{
			TimeEntryDao.delete(TimeEntryDao.queryForAll());
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return false;
	}


	public boolean add(TimeEntry arg)
	{
		try
		{
			Dao.CreateOrUpdateStatus status = TimeEntryDao.createOrUpdate(arg);
			return (status.isCreated() || status.isUpdated());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}


	public boolean addAll(final List<TimeEntry> arg)
	{
		boolean isInserted = true;
		try
		{
			TimeEntryDao.callBatchTasks(new Callable<TimeEntry>()
			{

				@Override
				public TimeEntry call() throws Exception
				{
					for (TimeEntry TimeEntry : arg)
					{
						TimeEntryDao.createOrUpdate(TimeEntry);
					}
					return null;
				}

			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
			isInserted = false;
		}
		return isInserted;
	}


	public boolean update(TimeEntry arg)
	{
		try
		{
			Dao.CreateOrUpdateStatus status = TimeEntryDao.createOrUpdate(arg);
			return (status.isCreated() || status.isUpdated());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}


}
