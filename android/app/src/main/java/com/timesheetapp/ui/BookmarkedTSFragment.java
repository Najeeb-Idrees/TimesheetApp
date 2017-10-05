package com.timesheetapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.timesheetapp.R;
import com.timesheetapp.events.RowListener;
import com.timesheetapp.model.delegate.TimeEntryDelegate;
import com.timesheetapp.model.entities.TimeEntry;
import com.timesheetapp.ui.adapetrs.TimesheetListAdapter;

import java.util.List;

/**
 * Created by Najeeb.Idrees on 04-Oct-17.
 */

public class BookmarkedTSFragment extends Fragment implements RowListener
{
	private RecyclerView bookmarked_ts_list;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.fragment_bookmarked, container, false);

		bookmarked_ts_list = v.findViewById(R.id.bookmarked_ts_list);

		((LogTimeActivity) getActivity()).toolbar_title.setText(String.valueOf("Bookmarked List"));
		setUpList();

		return v;
	}

	private void setUpList()
	{
		List<TimeEntry> timeEntryList = new TimeEntryDelegate().getAllBookmarked(true);
		final TimesheetListAdapter timesheetListAdapter = new TimesheetListAdapter(timeEntryList, this);

		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
		bookmarked_ts_list.setLayoutManager(mLayoutManager);
		bookmarked_ts_list.setItemAnimator(new DefaultItemAnimator());
		bookmarked_ts_list.setAdapter(timesheetListAdapter);
	}

	@Override
	public void rowTap(Object agr, int pos)
	{
		((LogTimeActivity) getActivity()).editTE((TimeEntry) agr);
		getFragmentManager().popBackStack();
	}

	@Override
	public void rowLongPress(Object agr, int pos)
	{

	}
}
