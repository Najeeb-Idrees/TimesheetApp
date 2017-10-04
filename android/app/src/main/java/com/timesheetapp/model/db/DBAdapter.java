package com.timesheetapp.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.timesheetapp.R;
import com.timesheetapp.model.entities.TimeEntry;

import java.sql.SQLException;

/**
 * Created by Najeeb.Idrees on 14-Mar-17.
 */


/**
 * Database helper class used to manage the creation and upgrading of your
 * database. This class also usually provides the DAOs used by the other
 * classes.
 */
public class DBAdapter extends OrmLiteSqliteOpenHelper
{
	private Dao<TimeEntry, Integer> timeEntryDao = null;

	public DBAdapter(Context context)
	{
		super(context, DBConstant.FILE_NAME_DB, null, DBConstant.DATABASE_VERSION, R.raw.ormlite_config);
	}


	/**
	 * This is called when the database is first created. Usually you should
	 * call createTable statements here to create the tables that will store
	 * your data.
	 */
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource)
	{
		try
		{
			Log.i(DBAdapter.class.getName(), "onCreate");

			TableUtils.createTableIfNotExists(connectionSource, TimeEntry.class);

		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion)
	{
		Log.i(DBAdapter.class.getName(), "onUpgrade");
	}

	/**
	 * Returns the Database Access Object (DAO) for our SimpleData class. It
	 * will create it or just give the cached value.
	 *
	 * @throws SQLException
	 */

	public Dao<TimeEntry, Integer> getTimeEntryDao()
	{
		if (timeEntryDao == null)
		{
			try
			{
				timeEntryDao = getDao(TimeEntry.class);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return timeEntryDao;
	}

	@Override
	public void close()
	{
		super.close();
	}
}
