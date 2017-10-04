package com.timesheetapp.model.db;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by Najeeb.Idrees on 22-Mar-17.
 */

public class ExportDB
{
	public static boolean export(Context context)
	{
		try
		{
			File sd = Environment.getExternalStorageDirectory();
			File data = Environment.getDataDirectory();

			if (sd.canWrite())
			{
				String currentDBPath = "/data/data/" + context.getPackageName() + "/databases/" + DBConstant.FILE_NAME_DB;
				String backupDBPath = DBConstant.FILE_NAME_DB + "_" + DBConstant.DATABASE_VERSION + ".db";
				File currentDB = new File(currentDBPath);
				File backupDB = new File(sd, backupDBPath);

				if (currentDB.exists())
				{
					FileChannel src = new FileInputStream(currentDB).getChannel();
					FileChannel dst = new FileOutputStream(backupDB).getChannel();
					dst.transferFrom(src, 0, src.size());
					src.close();
					dst.close();

					return true;
				}
			}
		}
		catch (Exception e)
		{
			Log.e("Error in", " export DB");
			e.printStackTrace();
		}

		return false;
	}
}
