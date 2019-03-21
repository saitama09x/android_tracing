package com.android.controller.evaluation;

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
import com.android.controller.*;
import com.android.model.*;
import java.util.HashMap;
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

public class Evaluation extends Activity {
	
	public static String eval_type = "intro";
	Context con = this;	
	private HashMap<String, String> map = new HashMap<String, String>();
	private int user_id = 1;
	private GridView gridview;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		if(Evaluation.eval_type == "intro"){
			setContentView(R.layout.eval_intro);			
		}else if(Evaluation.eval_type == "letters"){
			setContentView(R.layout.letter_case);
		}else if(Evaluation.eval_type == "shapes"){
			setContentView(R.layout.shape_case);	
		}else if(Evaluation.eval_type == "numbers"){
			setContentView(R.layout.number_case);	
		}else{
			if(Evaluation.eval_type == "scoring_big_letters"){				
				setContentView(R.layout.scoring_big_letters);	
			}else if(Evaluation.eval_type == "scoring_small_letters"){
				setContentView(R.layout.scoring_big_letters);	
			}else if(Evaluation.eval_type == "scoring_shapes"){
				setContentView(R.layout.scoring_shapes);
			}else if(Evaluation.eval_type == "scoring_numbers"){
				setContentView(R.layout.scoring_numbers);
			}

			gridview = (GridView) findViewById(R.id.gridview);
			gridview.setAdapter(new GridAdapter(con, map));				
		}
	}
	
	public void eval_letter(View view){
		Evaluation.eval_type = "letters";
		Intent refresh = new Intent(getApplicationContext(), Evaluation.class);
		finish(); 
		startActivity(refresh);	
	}

	public void eval_number(View view){
		Evaluation.eval_type = "numbers";
		Intent refresh = new Intent(getApplicationContext(), Evaluation.class);
		finish(); 
		startActivity(refresh);	
	}
	
	public void eval_shape(View view){
		Evaluation.eval_type = "shapes";
		Intent refresh = new Intent(getApplicationContext(), Evaluation.class);
		finish(); 
		startActivity(refresh);	
	}
	
	public void scoring_big_letters(View view){
		Evaluation.eval_type = "scoring_big_letters";
		Intent refresh = new Intent(getApplicationContext(), Evaluation.class);
		finish(); 
		startActivity(refresh);			
	}

	public void scoring_small_letters(View view){
		Evaluation.eval_type = "scoring_small_letters";
		Intent refresh = new Intent(getApplicationContext(), Evaluation.class);
		finish(); 
		startActivity(refresh);			
	}

	public void scoring_shapes(View view){
		Evaluation.eval_type = "scoring_shapes";
		Intent refresh = new Intent(getApplicationContext(), Evaluation.class);
		finish(); 
		startActivity(refresh);			
	}

	public void scoring_numbers(View view){
		Evaluation.eval_type = "scoring_numbers";
		Intent refresh = new Intent(getApplicationContext(), Evaluation.class);
		finish(); 
		startActivity(refresh);			
	}	
		
	public void goResult(View view){
		Student_score.category = view.getTag().toString();
		Intent goToNextActivity = new Intent(this, Student_score.class);
		finish();
		startActivity(goToNextActivity);
	}

	public void goIntro(View view){
		Evaluation.eval_type = "intro";
		Intent goToNextActivity = new Intent(this, Evaluation.class);
		finish();
		startActivity(goToNextActivity);

	}

	public void goBack(View view){	
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
	
}