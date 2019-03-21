package com.android.controller;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import com.android.model.*;
import com.android.R;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
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

public class Student_score extends AppCompatActivity {
	
	private ListView scorelist;
	private ArrayList user, myscore, txtscore, eval_status, date_created, user_date;
	private TextView head_title;
	private Db_sqlite db;
	private int user_id = 1;
	public static String category = "big_a";
	private Context con = this;
	private MediaPlayer intro_music;

    public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.student_score);
			scorelist = (ListView) findViewById(R.id.scorelist);
			scorelist.setDivider(null);	
			head_title = (TextView) findViewById(R.id.head_title);	
			Typeface face = Typeface.createFromAsset(getAssets(), "font/snickles.ttf");
			head_title.setTypeface(face);
			db = new Db_sqlite(con);	
			sqlite_score();
		}
		
	public void sqlite_score(){
			List<Score_img> array_list = db.getScoreByCat(user_id, 
			Student_score.category);		
			
			user = new ArrayList<String>();
			myscore = new ArrayList<Integer>();
			txtscore = new ArrayList<String>();
			eval_status = new ArrayList<String>();
			user_date = new ArrayList<String>();

			int count_row = 1;
			for(Score_img score : array_list){	
				int _score = (int) score.score;
				if(_score > 20 && _score < 40){
					 myscore.add(R.drawable.star_score_2);
					 eval_status.add("Nice");
				 }else if(_score > 39 && _score < 60){
					 myscore.add(R.drawable.star_score_3);
					 eval_status.add("Good");
				 }else if(_score > 59 && _score < 80){
					 myscore.add(R.drawable.star_score_4);
					 eval_status.add("Excellent");
				 }else if(_score > 80){
					 myscore.add(R.drawable.star_score_5);
					 eval_status.add("Perfect");
				 }else{
					 myscore.add(R.drawable.star_score);
					 eval_status.add("");
				 }
				user.add(Integer.toString(count_row));
				txtscore.add(_score);
				user_date.add(score.date_created);
				count_row++;
			}	
			
			list_view_score(user, txtscore, eval_status, myscore, user_date);
			
		}	
		
		public void list_view_score(ArrayList user, ArrayList txtscore, 
		ArrayList eval_status, ArrayList myscore, ArrayList user_date){
			
			 String[] user_arr = new String[user.size()];			
			 int count = 0;
			 for(Object obj : user){
				user_arr[count] = obj.toString();
				count++;
			 }
			 Integer[] user_score_img = new Integer[myscore.size()];
			 count = 0;
			 for(Object obj : myscore){
				user_score_img[count] = (Integer) obj;
				count++;
			 } 			
			 
			 String[] user_score = new String[txtscore.size()];						
			 count= 0;
			 for(Object obj : txtscore){
				user_score[count] = obj.toString();
				count++;
			 }
				
			 String[] user_eval = new String[eval_status.size()];						
			 count= 0;
			 for(Object obj : eval_status){
				user_eval[count] = obj.toString();
				count++;
			 }

			 String[] user_date_ = new String[user_date.size()];						
			 count = 0;
			 for(Object obj : user_date){
				user_date_[count] = obj.toString();
				count++;
			 }	
				
			 ScoreListAdapter adapter = new ScoreListAdapter(con, user_arr, user_score_img, user_score, user_eval, user_date_);
			 scorelist = (ListView) findViewById(R.id.scorelist);
			 scorelist.setAdapter(adapter);						
		}
		
		public void goHome(View v){
			HomePage.page_type = "menus";
			Intent goToNextActivity = new Intent(getApplicationContext(), HomePage.class);
			finish();
			startActivity(goToNextActivity);
		}	
}