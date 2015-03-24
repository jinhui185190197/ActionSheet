package com.example.actionsheet;

import com.example.dialog.ActionSheetDialog;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends Activity {
	ActionSheetDialog dialog;
	FragmentTransaction transaction;
	Button test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		test = (Button) findViewById(R.id.test);
		test.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				transaction = getFragmentManager().beginTransaction();
				transaction.setCustomAnimations(R.anim.enter_anim,
						R.anim.abc_slide_out_bottom);
				dialog.show(transaction, "actionSheet");
			}
		});

		dialog = new ActionSheetDialog();
		

	}
}
