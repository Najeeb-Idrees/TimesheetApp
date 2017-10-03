package com.timesheetapp.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.timesheetapp.R;
import com.timesheetapp.util.Constant;

public class LogTimeActivity extends AppCompatActivity implements View.OnClickListener
{
	private BottomSheetBehavior mBottomSheetBehavior;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_time);

		View bottomSheet = findViewById(R.id.bottom_sheet);
		Button button1 = (Button) findViewById(R.id.button_1);
		Button button2 = (Button) findViewById(R.id.button_2);
		Button button3 = (Button) findViewById(R.id.button_3);

		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);

		mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
			case R.id.button_1:
			{
				//				mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
				//				break;
				TutsPlusBottomSheetDialogFragment bottomSheetDialogFragment = new TutsPlusBottomSheetDialogFragment();
				bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
				break;
			}
			case R.id.button_2:
			{
				showDialog();
			}
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

		final CharSequence[] items = {"A", "B", "C"};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Make your selection");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				// Do something with the selection
//				mDoneButton.setText(items[item]);
			}
		});
		AlertDialog alert = builder.create();
		alert.show();

//		String names[] = {"A", "B", "C", "D"};
//		AlertDialog.Builder alertDialog = new AlertDialog.Builder(LogTimeActivity.this);
//		LayoutInflater inflater = getLayoutInflater();
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
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
//		lv.setAdapter(adapter);
//		alertDialog.show();

		//		AlertDialog.Builder facilitiesDialog = new AlertDialog.Builder(this);
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
	}
}
