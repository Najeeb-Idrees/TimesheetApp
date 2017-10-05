package com.timesheetapp.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.timesheetapp.R;
import com.timesheetapp.events.AddTimeEvent;
import com.timesheetapp.events.RowListener;
import com.timesheetapp.model.delegate.TimeEntryDelegate;
import com.timesheetapp.model.entities.TimeEntry;
import com.timesheetapp.ui.adapetrs.TimesheetListAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;


public class LogTimeActivity extends AppCompatActivity implements View.OnClickListener, RowListener
{
	//	private LinearLayout add_time_layout;
	private RecyclerView timesheet_list;

	private boolean fabExpanded = false;
	private FloatingActionButton fab;
	private LinearLayout layoutFabBookmark;
	private LinearLayout layoutFabManual;

	public ImageView btn_back;
	public TextView toolbar_title;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_time);

		timesheet_list = (RecyclerView) findViewById(R.id.timesheet_list);
		fab = (FloatingActionButton) findViewById(R.id.fab);
		layoutFabBookmark = (LinearLayout) findViewById(R.id.layoutFabBookmark);
		layoutFabManual = (LinearLayout) findViewById(R.id.layoutFabManual);
		btn_back = (ImageView) findViewById(R.id.btn_back);
		toolbar_title = (TextView) findViewById(R.id.toolbar_title);

		layoutFabBookmark.setOnClickListener(this);
		layoutFabManual.setOnClickListener(this);
		fab.setOnClickListener(this);
		btn_back.setOnClickListener(this);

		closeSubMenusFab();
		setUpList();
	}

	private void setUpList()
	{
		List<TimeEntry> timeEntryList = new TimeEntryDelegate().getAll();
		final TimesheetListAdapter timesheetListAdapter = new TimesheetListAdapter(timeEntryList, this);

		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
		timesheet_list.setLayoutManager(mLayoutManager);
		timesheet_list.setItemAnimator(new DefaultItemAnimator());
		timesheet_list.setAdapter(timesheetListAdapter);
	}


	@Override
	public void onStart()
	{
		super.onStart();
		EventBus.getDefault().register(this);
	}

	@Override
	public void onStop()
	{
		super.onStop();
		EventBus.getDefault().unregister(this);
	}


	public void onClick(View v)
	{
		switch (v.getId())
		{
			case R.id.fab:
			{
				if (fabExpanded == true)
				{
					closeSubMenusFab();
				}
				else
				{
					openSubMenusFab();
				}
				break;
			}
			case R.id.layoutFabBookmark:
			{
				launchNewFragment(new BookmarkedTSFragment());
				closeSubMenusFab();
				break;
			}

			case R.id.layoutFabManual:
			{
				BottomSheetDialogFragment bottomSheetDialogFragment = new LogTimeBSFragment();
				bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());

				closeSubMenusFab();
				break;
			}
			case R.id.btn_back:
			{
				int noOfFrgmts = getSupportFragmentManager().getBackStackEntryCount();
				Log.d("Number of Fragments", String.valueOf(noOfFrgmts));
				if (noOfFrgmts > 0)
				{
					getSupportFragmentManager().popBackStack();
					if (noOfFrgmts == 1)
					{
						toolbar_title.setText(String.valueOf("Log Time"));
					}
				}
				else
				{
					finish();
				}
			}
		}
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onAddTimeEventEvent(AddTimeEvent event)
	{
		if (event.isAdded())
		{
			Log.i("Time Added", event.isAdded() + " ");
			setUpList();
		}
	}

	@Override
	public void rowTap(Object agr, int pos)
	{
		showOptionDialog((TimeEntry) agr);
	}

	@Override
	public void rowLongPress(Object agr, int pos)
	{
		showOptionDialog((TimeEntry) agr);
	}

	private void showOptionDialog(final TimeEntry timeEntry)
	{
		final CharSequence[] items = {
				"Bookmark",
				"Edit",
				"Delete"};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setItems(items, new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int item)
			{
				if (item == 0)
				{
					markFrequentlyTE(timeEntry);
				}
				else if (item == 1)
				{
					editTE(timeEntry);
				}
				else if (item == 2)
				{
					deleteTE(timeEntry);
				}
			}
		});
		AlertDialog alert = builder.create();
		alert.setCancelable(true);
		alert.setCanceledOnTouchOutside(true);
		alert.show();
	}

	public void editTE(TimeEntry timeEntry)
	{
		BottomSheetDialogFragment bottomSheetDialogFragment = LogTimeBSFragment.newInstance(timeEntry);
		bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
	}

	private void deleteTE(TimeEntry timeEntry)
	{
		new TimeEntryDelegate().delete(timeEntry);
		setUpList();
	}

	private void markFrequentlyTE(TimeEntry timeEntry)
	{
		timeEntry.setIs_bookmarked(true);
		new TimeEntryDelegate().update(timeEntry);
	}

	//closes FAB submenus
	private void closeSubMenusFab()
	{
		layoutFabManual.setVisibility(View.INVISIBLE);
		layoutFabBookmark.setVisibility(View.INVISIBLE);
		fab.setImageResource(R.drawable.icon_add);
		fabExpanded = false;
	}

	//Opens FAB submenus
	private void openSubMenusFab()
	{
		layoutFabManual.setVisibility(View.VISIBLE);
		layoutFabBookmark.setVisibility(View.VISIBLE);
		//Change settings icon to 'X' icon
		fab.setImageResource(R.drawable.icon_close);
		fabExpanded = true;
	}


	public void launchNewFragment(Fragment fragment)
	{
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		fragmentTransaction.replace(R.id.fragment_container, fragment, fragment.getTag());
		fragmentTransaction.addToBackStack(fragment.getClass().getName());
		fragmentTransaction.commit();
	}
}
