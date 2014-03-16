package com.beecub.livewallpaper.console;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2 extends Activity implements OnClickListener {

	private EditText et;
	private Button setWall;
	private TextView tv;
	public String passString = "";

	ConsoleWallpaper consol;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);

		consol = new ConsoleWallpaper();

		et = (EditText) findViewById(R.id.editText1);
		setWall = (Button) findViewById(R.id.button1);

		setWall.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.setWall:

			break;

		}

	}
}
