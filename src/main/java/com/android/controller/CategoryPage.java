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
import android.content.SharedPreferences;
import com.android.R;

public class CategoryPage extends Activity {
	
	SharedPreferences sharedpreferences;
	public static String category_content = "letters";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if(CategoryPage.category_content == "letters"){
        	setContentView(R.layout.category_page_letters);
        }else if(CategoryPage.category_content == "shapes"){
        	setContentView(R.layout.category_page_shapes);
        }else if(CategoryPage.category_content == "numbers"){
        	setContentView(R.layout.category_page_numbers);
        }

		sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedpreferences.edit();				
	
	}
	
	
	public void go_big_letters_a(View view){			
			Practice_tracing.category_type = "big_a";
			Practice_tracing.category_letters = "big_a";
			Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
			finish(); 
			startActivity(refresh);
	}

	public void go_big_letters_i(View view){			
			Practice_tracing.category_type = "big_i";
			Practice_tracing.category_letters = "big_i";
			Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
			finish(); 
			startActivity(refresh);
	}

	public void go_big_letters_r(View view){
			Practice_tracing.category_type = "big_r";
			Practice_tracing.category_letters = "big_r";
			Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
			finish(); 
			startActivity(refresh);
	}
	
	public void go_small_letters_a(View view){			
			Practice_tracing.category_type = "small_a";
			Practice_tracing.category_letters = "small_a";
			Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
			finish(); 
			startActivity(refresh);
	}

	public void go_small_letters_i(View view){	
			Practice_tracing.category_type = "small_i";
			Practice_tracing.category_letters = "small_i";
			Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
			finish(); 
			startActivity(refresh);
	}

	public void go_small_letters_r(View view){	
			Practice_tracing.category_type = "small_r";
			Practice_tracing.category_letters = "small_r";
			Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
			finish(); 
			startActivity(refresh);
	}

	public void go_shapes(View view){
			Practice_tracing.category_type = "circle";
			Practice_tracing.category_letters = "shapes";
			Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
			finish(); 
			startActivity(refresh);
	}

	public void go_numbers(View view){
			Practice_tracing.category_type = "number_1";
			Practice_tracing.category_letters = "numbers";
			Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
			finish(); 
			startActivity(refresh);
	}

	public void goHome(View view){
		HomePage.page_type = "menus";
		finish();
		startActivity(new Intent(getApplicationContext(), HomePage.class)); 
	}

	public void goBack(View view){		
		HomePage.page_type = "home";
		finish();
		startActivity(new Intent(getApplicationContext(), HomePage.class)); 
	}

	
}