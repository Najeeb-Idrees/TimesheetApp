package com.timesheetapp.ui.adapetrs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.timesheetapp.R;
import com.timesheetapp.events.RowListener;
import com.timesheetapp.model.entities.TimeEntry;

import java.util.List;

/**
 * Created by Najeeb.Idrees on 04-Oct-17.
 */

public class TimesheetListAdapter extends RecyclerView.Adapter<TimesheetListAdapter.MyViewHolder>
{
	private List<TimeEntry> timeEntries;
	private RowListener rowListener = null;

	public TimesheetListAdapter(List<TimeEntry> timeEntries, RowListener rowListener)
	{
		this.timeEntries = timeEntries;
		this.rowListener = rowListener;
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View itemView = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.time_sheet_list_item, parent, false);

		return new MyViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, final int position)
	{
		final TimeEntry timeEntry = timeEntries.get(position);
		holder.project.setText(timeEntry.getProject());
		holder.activity.setText(timeEntry.getActivity());
		holder.description.setText(timeEntry.getTaskDescription());
		holder.hour.setText(String.valueOf(timeEntry.getHour()));
		//		holder.hour.setText(String.valueOf(timeEntry.getHour() + " Hrs."));


		holder.itemRow.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (rowListener != null)
				{
					rowListener.rowTap(timeEntry, position);
				}
			}
		});

		holder.itemRow.setOnLongClickListener(new View.OnLongClickListener()
		{
			@Override
			public boolean onLongClick(View view)
			{
				if (rowListener != null)
				{
					rowListener.rowLongPress(timeEntry, position);
				}
				return true;
			}
		});
	}

	@Override
	public int getItemCount()
	{
		return timeEntries.size();
	}


	public class MyViewHolder extends RecyclerView.ViewHolder
	{
		public TextView project, activity, hour, description;
		RelativeLayout itemRow;

		public MyViewHolder(View view)
		{
			super(view);
			project = view.findViewById(R.id.project);
			activity = view.findViewById(R.id.activity);
			hour = view.findViewById(R.id.hour);
			description = view.findViewById(R.id.description);
			itemRow = view.findViewById(R.id.item_row_layout);
		}
	}
}
