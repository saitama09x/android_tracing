package com.android.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.*;
import android.content.Context;
import java.util.ArrayList;
import android.database.Cursor;
import android.content.DialogInterface;
import android.app.Dialog;
import android.content.SharedPreferences;
import java.util.List; 
import android.widget.Spinner;
import com.android.R;
import com.android.model.*;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.view.LayoutInflater;
//Mysql
import android.os.Handler;
import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import android.graphics.Typeface;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.android.controller.evaluation.*;

public class MainSettings extends Activity {

	private Dialog voldialog;
	private CheckBox vol_on, vol_off;
	public static boolean set_vol = true;
	public static boolean is_instruction = false;
	public static boolean is_settings = false;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!MainSettings.is_instruction){
        	setContentView(R.layout.main_settings);
        }else{
        	setContentView(R.layout.instruction_details);
        }		

		voldialog = new Dialog(this);	
		voldialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		voldialog.getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		View elem = (View) LayoutInflater.from(this).inflate(R.layout.voldialog, null);
		voldialog.setContentView(elem);

		vol_on = (CheckBox) elem.findViewById(R.id.vol_on);
		vol_off = (CheckBox) elem.findViewById(R.id.vol_off);
		MainSettings.is_settings = true;

	}


	public void showVolume(View view){
		voldialog.show();
	}

	public void vol_on_click(View view){
		if (((CheckBox) view).isChecked()) {
			vol_off.setChecked(false);
			MainSettings.set_vol = true;		
		}
	}

	public void vol_off_click(View view){
		if (((CheckBox) view).isChecked()) {
			vol_on.setChecked(false);	
			MainSettings.set_vol = false;	
		}
		
	}

	public void close_diag(View view){
		voldialog.dismiss();
	}

	public void go_evaluation(View view){
		finish();
		startActivity(new Intent(getApplicationContext(), Evaluation.class)); 
	}

	public void go_instruction(View view){
		MainSettings.is_instruction = true;
		finish();
		startActivity(new Intent(getApplicationContext(), MainSettings.class)); 	
	}

	public void goHome(View view){
		finish();
		startActivity(new Intent(getApplicationContext(), HomePage.class)); 
	}

	public void goBack(View view){		
		if(MainSettings.is_instruction){
			MainSettings.is_instruction = false;			
			finish();
			startActivity(new Intent(getApplicationContext(), MainSettings.class)); 
		}else{
			HomePage.page_type = "menus";
			finish();
			startActivity(new Intent(getApplicationContext(), HomePage.class)); 
		}
	}

}