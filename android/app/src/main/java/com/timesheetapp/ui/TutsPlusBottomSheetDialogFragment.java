package com.timesheetapp.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.timesheetapp.R;

/**
 * Created by Najeeb.Idrees on 03-Oct-17.
 */

public class TutsPlusBottomSheetDialogFragment extends BottomSheetDialogFragment implements
		View.OnClickListener
{
	private Button project, activity;

	@Override
	public void setupDialog(Dialog dialog, int style)
	{
		super.setupDialog(dialog, style);
		final View contentView = View.inflate(getContext(), R.layout.fragment_bottom_sheet, null);


		//set to adjust screen height automatically, when soft keyboard appears on screen
//		getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


		project = (Button) contentView.findViewById(R.id.project);
		activity = (Button) contentView.findViewById(R.id.activity);

		project.setOnClickListener(this);
		activity.setOnClickListener(this);

		((Button) contentView.findViewById(R.id.show_popup)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog();
			}
		});

		dialog.setContentView(contentView);

		final CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
		final CoordinatorLayout.Behavior behavior = params.getBehavior();

		if (behavior != null && behavior instanceof BottomSheetBehavior)
		{
			//			((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
			contentView.post(new Runnable()
			{
				@Override
				public void run()
				{
					Log.i("Height is", contentView.getHeight() + " ");
//					((BottomSheetBehavior) behavior).setPeekHeight(contentView.getHeight());
				}
			});
		}
	}

	private void showDialog()
	{
		//		final String listItems[] = new String[10];
		//		listItems[0] = "August Corrales - UMC";
		//		listItems[1] = "August Corrales - Hospital 2";
		//		listItems[2] = "August Corrales - Hospital 3";
		//		listItems[3] = "August Corrales - UMC";
		//		listItems[4] = "August Corrales - Hospital 2";
		//		listItems[5] = "August Corrales - Hospital 3";
		//		listItems[6] = "August Corrales - UMC";
		//		listItems[7] = "August Corrales - Hospital 2";
		//		listItems[8] = "August Corrales - Hospital 3";
		//
		//
		//		AlertDialog.Builder facilitiesDialog = new AlertDialog.Builder(getActivity());
		//		facilitiesDialog.setTitle("Select Project");
		//		facilitiesDialog.setCancelable(false);
		//		facilitiesDialog.setItems(listItems,
		//				new DialogInterface.OnClickListener()
		//				{
		//					@Override
		//					public void onClick(DialogInterface dialog, int which)
		//					{
		//
		//					}
		//				});
		//
		//		facilitiesDialog.show();


		final CharSequence[] items = {"A", "B", "C"};

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Make your selection");
		builder.setItems(items, new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int item)
			{
				// Do something with the selection
				//				mDoneButton.setText(items[item]);
			}
		});
		AlertDialog alert = builder.create();
		alert.show();

		//		String names[] = {"A", "B", "C", "D"};
		//		final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
		//		LayoutInflater inflater = getActivity().getLayoutInflater();
		//		View convertView = (View) inflater.inflate(R.layout.custom, null);
		//		alertDialog.setView(convertView);
		//		alertDialog.setTitle("List");
		//		ListView lv = (ListView) convertView.findViewById(R.id.listView1);
		//		lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
		//		{
		//			@Override
		//			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
		//			{
		//
		//			}
		//		});
		//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, names);
		//		lv.setAdapter(adapter);
		//
		//		AlertDialog alertDialog1 = alertDialog.create();
		//		alertDialog.show();

	}

	@Override
	public void onClick(View v)
	{
		if (v.getId() == R.id.project)
		{
			showDialog();
		}
		else if (v.getId() == R.id.activity)
		{
			showDialog();
		}
	}
}