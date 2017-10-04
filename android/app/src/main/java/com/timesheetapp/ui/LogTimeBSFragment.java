package com.timesheetapp.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.timesheetapp.MainApplication;
import com.timesheetapp.R;
import com.timesheetapp.events.AddTimeEvent;
import com.timesheetapp.model.delegate.TimeEntryDelegate;
import com.timesheetapp.model.entities.TimeEntry;
import com.timesheetapp.util.PreferencesManager;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by Najeeb.Idrees on 03-Oct-17.
 */

public class LogTimeBSFragment extends BottomSheetDialogFragment implements
		View.OnClickListener
{
	private LinearLayout project_layout, activity_layout;
	private Button btn_log_time;
	private TextView project_txt, activity_txt;
	private EditText task_desc_et, hour_et;

	private TimeEntry timeEntry = null;

	public LogTimeBSFragment()
	{
		timeEntry = null;
	}

	public static LogTimeBSFragment newInstance(TimeEntry timeEntry)
	{
		LogTimeBSFragment logTimeBSFragment = new LogTimeBSFragment();
		logTimeBSFragment.setRetainInstance(true);

		Bundle bundle = new Bundle();
		bundle.putSerializable("timeEntry", timeEntry);
		logTimeBSFragment.setArguments(bundle);


		return logTimeBSFragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		if (getArguments() != null)
		{
			timeEntry = (TimeEntry) getArguments().get("timeEntry");
		}
	}

	@Override
	public void setupDialog(Dialog dialog, int style)
	{
		super.setupDialog(dialog, style);
		final View contentView = View.inflate(getContext(), R.layout.fragment_bottom_sheet, null);

		project_layout = contentView.findViewById(R.id.project_layout);
		activity_layout = contentView.findViewById(R.id.activity_layout);
		project_txt = contentView.findViewById(R.id.project_txt);
		activity_txt = contentView.findViewById(R.id.activity_txt);
		btn_log_time = contentView.findViewById(R.id.btn_log_time);
		task_desc_et = contentView.findViewById(R.id.task_desc_et);
		hour_et = contentView.findViewById(R.id.hour_et);

		project_layout.setOnClickListener(this);
		activity_layout.setOnClickListener(this);
		btn_log_time.setOnClickListener(this);

		dialog.setContentView(contentView);


		String prjt = MainApplication.preferencesManager.getStringValue(PreferencesManager.PROJECT);
		String actv = MainApplication.preferencesManager.getStringValue(PreferencesManager.ACTIVITY);

		if (!prjt.equals(""))
		{
			project_txt.setText(prjt);
		}
		if (!actv.equals(""))
		{
			activity_txt.setText(actv);
		}

		if (timeEntry != null)
		{
			setUpData();
		}

	}

	private void setUpData()
	{
		project_txt.setText(timeEntry.getProject());
		activity_txt.setText(timeEntry.getActivity());
		task_desc_et.setText(timeEntry.getTaskDescription());
		hour_et.setText(String.valueOf(timeEntry.getHour()));
	}

	@Override
	public void onClick(View v)
	{
		if (v.getId() == R.id.project_layout)
		{
			showProjectDialog();
		}
		else if (v.getId() == R.id.activity_layout)
		{
			showActivityDialog();
		}
		else if (v.getId() == R.id.btn_log_time)
		{
			try
			{
				if (timeEntry == null)
				{
					MainApplication.preferencesManager.setStringValue(PreferencesManager.PROJECT, project_txt.getText().toString().trim());
					MainApplication.preferencesManager.setStringValue(PreferencesManager.ACTIVITY, activity_txt.getText().toString().trim());
					timeEntry = new TimeEntry();
				}
				if (timeEntry.is_bookmarked())
				{
					timeEntry = new TimeEntry();
				}

				timeEntry.setProject(project_txt.getText().toString().trim());
				timeEntry.setActivity(activity_txt.getText().toString().trim());
				timeEntry.setTaskDescription(task_desc_et.getText().toString().trim());
				timeEntry.setHour(Double.parseDouble(hour_et.getText().toString().trim()));
				timeEntry.setIs_bookmarked(false);

				new TimeEntryDelegate().add(timeEntry);
				EventBus.getDefault().post(new AddTimeEvent(true));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			dismiss();
		}
	}

	private void showProjectDialog()
	{
		final CharSequence[] items = {"FOAS",
				"CSymplicity",
				"Cloud Vote",
				"MCI Assist",
				"TS HR",
				"Secure Browser/Messaging",
				"Test Taker App",
				"HealthSlate Pro",
				"Health Touch",
				"Test"};

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Projects");
		builder.setItems(items, new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int item)
			{
				project_txt.setText(items[item]);
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

	private void showActivityDialog()
	{
		final CharSequence[] items = {
				"Coding",
				"Testing",
				"Outage",
				"Design",
				"User Interface Creation",
				"Scrum",
				"Test Cases"};

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Activities");
		builder.setItems(items, new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int item)
			{
				activity_txt.setText(items[item]);
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}
}