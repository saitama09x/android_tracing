package com.android.controller;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.*;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;
import android.view.View.OnTouchListener;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.android.R;
import android.graphics.Typeface;
import com.android.controller.evaluation.*;

public class HomePage extends Activity {
	ImageView letter_btn, shape_btn, start_btn, exit_btn;
	TextView head_title;
	public static String page_type = "menus";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(HomePage.page_type.equals("start")){
        	setContentView(R.layout.home_start);
        }else if(HomePage.page_type.equals("menus")){
        	setContentView(R.layout.home_menus);	   
        }else if(HomePage.page_type.equals("home")){
        	setContentView(R.layout.home_page);	 
        }
	}

	public void home(View view){
		HomePage.page_type = "menus";
		Intent refresh = new Intent(getApplicationContext(), HomePage.class);
		finish(); 
		startActivity(refresh);
	}

	public void scorepage(View view){
		Evaluation.eval_type = "intro";
		Intent refresh = new Intent(getApplicationContext(), Evaluation.class);
		finish(); 
		startActivity(refresh);
	}

	public void goHome(View view){
		HomePage.page_type = "start";
		Intent refresh = new Intent(getApplicationContext(), HomePage.class);
		finish(); 
		startActivity(refresh);
	}

	public void category_start(View view){
		HomePage.page_type = "home";
		Intent refresh = new Intent(getApplicationContext(), HomePage.class);
		finish(); 
		startActivity(refresh);
	}

	public void letter_click(View view){
		CategoryPage.category_content = "letters";
		HomePage.page_type = "menus";
		Intent refresh = new Intent(getApplicationContext(), CategoryPage.class);
		finish(); 
		startActivity(refresh);
	}

	public void shape_click(View view){
		CategoryPage.category_content = "shapes";
		HomePage.page_type = "menus";
		Intent refresh = new Intent(getApplicationContext(), CategoryPage.class);
		finish(); 
		startActivity(refresh);
	}

	public void number_click(View view){
		CategoryPage.category_content = "numbers";
		HomePage.page_type = "menus";
		Intent refresh = new Intent(getApplicationContext(), CategoryPage.class);
		finish(); 
		startActivity(refresh);
	}
}