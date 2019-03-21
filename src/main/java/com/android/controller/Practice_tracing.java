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
import com.android.controller.evaluation.*;
import com.android.objects.*;
import com.android.model.*;
import com.android.R;
import com.android.tracing.*;
import java.util.*;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.view.ViewGroup.LayoutParams;
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
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Typeface;

public class Practice_tracing extends Activity {
	
	 private MediaPlayer big_letter_a, write_big_letter_a;
	 private Context con = this;
	 public static ArrayList score_arr = new ArrayList();
	 public static ArrayList score_wrong = new ArrayList();		 
	 public static int total_score = 0;
	 public static int user_score = 0;
	 public static boolean wrong_trace = false;	 
	 public static String category_type = "big_a";
	 public static String category_letters = "big_a";
	 public static String tracing_type = "practice";
	 private String speak_letter_type = "";
	 private double position_x = 0;	 
	 public static Db_sqlite db;	 
	 private Button done_btn, next_btn, retry_btn;
	 private Dialog next_diag;	 
	 private HashMap<String, String> letter_map_prev = new HashMap<String, String>();
	 private HashMap<String, String> letter_map_next = new HashMap<String, String>();
	 private int user_id = 1;
	 public static List<Double> list_pixel_x = new ArrayList<Double>();
	 public static List<Double> list_pixel_y = new ArrayList<Double>();	
	 private HashMap<String, int[]> num_grid_map = new HashMap<String, int[]>();
	 private HashMap<String, int[]> wrong_grid_map = new HashMap<String, int[]>();
	 private HashMap<String, String> speak_text = new HashMap<String, String>();
	 private int[] right_tracing;
	 private int[] wrong_tracing;
	 private Grid_list grid;
	 private Tracing_algorithm tracing_alg_1, tracing_alg_2, tracing_alg_3;
	 private TextToSpeech speak_letter;
	 private HashMap<String, Integer> voice_speak = new HashMap<String, Integer>();
	 private MediaPlayer voice_big_letter, voice_letter;
	 private TextView letter_ah;
	 private ImageView logo_a;
	 private SoundObjects sound_obj;
	 private TracingMapObjects tracing_map;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);	

        //Call GUI layout from res/layout 									
		setContentView(R.layout.letter_practice);						
		Configuration config = getResources().getConfiguration();
		sound_obj = new SoundObjects();
		tracing_map = new TracingMapObjects();

		int scale_width = 170;
		if (config.smallestScreenWidthDp >= 600) {
			scale_width = 300;				
		}
		
		letter_ah = (TextView) findViewById(R.id.letter_ah);
		logo_a = (ImageView) findViewById(R.id.logo_a);

		Evaluation.eval_type = "intro";

		grid = new Grid_list();	
		this.init_objects();

		right_tracing = Arrays.copyOf(grid.get_rightgrid(Practice_tracing.category_type), 
			grid.get_rightgrid(Practice_tracing.category_type).length);

		wrong_tracing = Arrays.copyOf(grid.get_wronggrid(Practice_tracing.category_type), 
			grid.get_wronggrid(Practice_tracing.category_type).length);		

		num_grid_map.put(Practice_tracing.category_type, right_tracing);
		wrong_grid_map.put(Practice_tracing.category_type, wrong_tracing);

		tracing_alg_1 = new Tracing_algorithm(getApplicationContext()); 		
		tracing_alg_2 = new Tracing_algorithm(getApplicationContext());
		tracing_alg_3 = new Tracing_algorithm(getApplicationContext());

		LinearLayout linear_parent = new LinearLayout(getApplicationContext());
		float scale = tracing_alg_1.getContext().getResources().getDisplayMetrics().density;
		int pixels = (int) (scale_width * scale + 0.5f);
		RelativeLayout write_letter = (RelativeLayout) findViewById(R.id.write_letter);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(pixels, ViewGroup.LayoutParams.WRAP_CONTENT);
		
		if(Practice_tracing.tracing_type == "practice"){						
			lp.setMargins(0, 0, 20, 0);
			linear_parent.setOrientation(LinearLayout.HORIZONTAL);
			linear_parent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			tracing_alg_1.setLayoutParams(lp); 				
			tracing_alg_2.setLayoutParams(lp);
			tracing_alg_3.setLayoutParams(lp);
			linear_parent.addView(tracing_alg_1);
			linear_parent.addView(tracing_alg_2);
			linear_parent.addView(tracing_alg_3);
			linear_parent.setGravity(Gravity.CENTER_HORIZONTAL);
			write_letter.addView(linear_parent);
		}else{	
			lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);			
			tracing_alg_1.setLayoutParams(lp);
			linear_parent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)); 				
			//linear_parent.setBackground(getResources().getDrawable(R.drawable.rectbg));
			linear_parent.addView(tracing_alg_1);
			write_letter.addView(linear_parent);
		}	

		speak_letter = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
	         @Override
	         public void onInit(int status) {
	            if(status != TextToSpeech.ERROR) {	            	
	               speak_letter.setLanguage(Locale.UK);	               
	               speak_letter.setSpeechRate(0.8f);
	               speak_letter.setPitch(0.7f);
	            }
	         }
      	});
		
		db = new Db_sqlite(con);
		
		next_diag = new Dialog(con);
		next_diag.requestWindowFeature(Window.FEATURE_NO_TITLE);
		next_diag.setContentView(R.layout.nextdialog);				
		done_btn = (Button) next_diag.findViewById(R.id.done_btn);		
		next_btn = (Button) next_diag.findViewById(R.id.next_image);
		retry_btn = (Button) next_diag.findViewById(R.id.retry_btn);

		retry_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
					retry_tracing(view);
			}
		});

		done_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
					done_tracing(view);
			}
		});
		
		next_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
					next_tracing(view);					
			}
		});
				

    }

    public void init_objects(){

    	if(Practice_tracing.category_letters == "big_a"){
			letter_ah.setText("A-H");
			tracing_map.setLetter_A_H("big");
			logo_a.setImageResource(R.drawable.icon_letter_1);
		}

		if(Practice_tracing.category_letters == "big_i"){
			letter_ah.setText("I-Q");	
			tracing_map.setLetter_I_Q("big");
			logo_a.setImageResource(R.drawable.icon_letter_1);	
		}

		if(Practice_tracing.category_letters == "big_r"){
			letter_ah.setText("R-Z");	
			tracing_map.setLetter_R_Z("big");	
			logo_a.setImageResource(R.drawable.icon_letter_1);
		}

		if(Practice_tracing.category_letters == "small_a"){
			letter_ah.setText("a-h");
			tracing_map.setLetter_A_H("small");
			logo_a.setImageResource(R.drawable.icon_letter_1);
		}

		if(Practice_tracing.category_letters == "small_i"){
			letter_ah.setText("i-q");
			tracing_map.setLetter_I_Q("small");
			logo_a.setImageResource(R.drawable.icon_letter_1);
		}

		if(Practice_tracing.category_letters == "small_r"){
			letter_ah.setText("r-z");
			tracing_map.setLetter_R_Z("small");
			logo_a.setImageResource(R.drawable.icon_letter_1);

		}

		if(Practice_tracing.category_letters == "shapes"){
			letter_ah.setText("Shapes");
			tracing_map.setShape();
			logo_a.setImageResource(R.drawable.shape_intro);
		}

		if(Practice_tracing.category_letters == "numbers"){
			letter_ah.setText("0-9");
			tracing_map.setNumber();
			logo_a.setImageResource(R.drawable.icon_number_1);
		}

    }
	
	public void voice_write_letter_a(View view){
		//write_big_letter_a.start();
		String toSpeak = new String(sound_obj.getSpeak(Practice_tracing.category_type.toString())); 			           
        speak_letter.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);						
							
	}
		
	public void refresh_page(View view){			
			Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
			finish(); 
			startActivity(refresh);		
	}

	public void home_page(View view){
			HomePage.page_type = "menus";
			Intent refresh = new Intent(getApplicationContext(), HomePage.class);
			finish(); 
			startActivity(refresh);	
	}

	public void go_category(View view){
			Intent refresh = new Intent(getApplicationContext(), CategoryPage.class);
			finish(); 
			startActivity(refresh);	
	}

	public void onPause(){
      if(speak_letter !=null){
         speak_letter.stop();
         speak_letter.shutdown();
      }
      super.onPause();
   	}
	
	public void check_play(View view){
		
		if(Practice_tracing.tracing_type == "practice"){
			score_practice();			
		}else if(Practice_tracing.tracing_type == "voice"){
			score_voice();								
		}				
	}
	
	
	private int avg_score(){
		double score_ = (double) Practice_tracing.user_score;
		double total_score_ = (double) Practice_tracing.total_score;
		double average = (score_ / total_score_) * 100;
		Double avg_score = new Double(average);		
		int my_score = avg_score.intValue();
		return my_score;
	}
	
	private void score_practice(){

		Practice_tracing.tracing_type = "voice";
		Dialog dialog = new Dialog(con);	
		dialog.setContentView(R.layout.scoringdialog);		
		
		int my_score = avg_score();
		
		ImageView draw_star = (ImageView) dialog.findViewById(R.id.draw_star);
		
		if(my_score > 20 && my_score < 40){
			draw_star.setImageResource(R.drawable.star_score_2);	
		}else if(my_score > 39 && my_score < 60){
			draw_star.setImageResource(R.drawable.star_score_3);	
		}else if(my_score > 59 && my_score < 80){
			draw_star.setImageResource(R.drawable.star_score_4);	
		}else if(my_score > 80){
			draw_star.setImageResource(R.drawable.star_score_5);	
		}else{
			draw_star.setImageResource(R.drawable.star_score);	
		}
		
		dialog.setTitle("Your Rating Star");
		dialog.show();		
		dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
		@Override
		public void onDismiss(final DialogInterface arg0) {				
				Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
				finish(); 
				startActivity(refresh);
			}
		});
	}
	
	public int tracing_score(){

		Object[] _list_pixel_x = Practice_tracing.list_pixel_x.toArray();
		Object[] _list_pixel_y = Practice_tracing.list_pixel_y.toArray();

		int[] __list_pixel_x = new int[_list_pixel_x.length];
		for(int x = 0; x < _list_pixel_x.length; x++){
			 Double dbl = Double.valueOf(_list_pixel_x[x].toString());
			__list_pixel_x[x] = dbl.intValue();
		}
		
		Arrays.sort(__list_pixel_x);

		int[] ___list_pixel_x = new int[_list_pixel_x.length];
		int minus_pixels = __list_pixel_x[1];
		for(int x = 0; x < _list_pixel_x.length; x++){
			 Double dbl = Double.valueOf(_list_pixel_x[x].toString());
			___list_pixel_x[x] = dbl.intValue() - (minus_pixels + 10);
		}

		int[] ___list_pixel_y = new int[_list_pixel_y.length];	
		for(int x = 0; x < _list_pixel_y.length; x++){
			 Double dbl = Double.valueOf(_list_pixel_y[x].toString());
			___list_pixel_y[x] = dbl.intValue();
		}
		
		HashMap<Integer, Integer> x_map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> y_map = new HashMap<Integer, Integer>();
		int count = 0;
		int userscore = 0;
		for(int y = 0; y < 300; y += (300 / 10)){
			for(int x = 0; x < 400; x += (400 / 10)){				
				x_map.put(count, x);	
				y_map.put(count, y);
				count++;
			}
		}		
		for(int x = 0; x < ___list_pixel_x.length; x++){
			boolean hit = false;							
			for(int z = 0; z < num_grid_map.get(Practice_tracing.category_type).length; z++){			
			if((___list_pixel_x[x] + 50 > x_map.get(num_grid_map.get(Practice_tracing.category_type)[z]) 
				&& ___list_pixel_x[x] < x_map.get(num_grid_map.get(Practice_tracing.category_type)[z]) + (400 / 10))){									
					hit = true;
				}

			if((___list_pixel_y[x] + 50 > y_map.get(num_grid_map.get(Practice_tracing.category_type)[z])) 
				&& (___list_pixel_y[x] < y_map.get(num_grid_map.get(Practice_tracing.category_type)[z]) + (300 / 10))){
					hit = true;	
				}			
			}
			if(hit)	{
				userscore++;
			}
		}
		
		int wrong_tracing = 0;		
		for(int x = 0; x < ___list_pixel_x.length; x++){
			boolean hit = false;	
			for(int z = 0; z < wrong_grid_map.get(Practice_tracing.category_type).length; z++){				
				if((___list_pixel_x[x] + 50 > x_map.get(wrong_grid_map.get(Practice_tracing.category_type)[z]) 
				&& ___list_pixel_x[x] < x_map.get(wrong_grid_map.get(Practice_tracing.category_type)[z]) + (400 / 10))){									
					hit = true;
				}

				if((___list_pixel_y[x] + 50 > y_map.get(wrong_grid_map.get(Practice_tracing.category_type)[z])) 
				&& (___list_pixel_y[x] < y_map.get(wrong_grid_map.get(Practice_tracing.category_type)[z]) + (300 / 10))){
					hit = true;
				}		
			}
			if(hit)	{
				wrong_tracing++;
				if(wrong_tracing >= 10){
					userscore--;
					wrong_tracing = 0;
				}
			}
		}
		
		Practice_tracing.tracing_type = "practice";
		double total_score_ = (double) Practice_tracing.total_score;
		double average = (userscore / total_score_) * 100;
		Double percent = new Double(userscore);
		int percent_int = percent.intValue();

		return percent_int;	
	}


	public void score_voice(){		
		if(Practice_tracing.list_pixel_x.size() == 0){
			return;
		}

		Dialog dialog = new Dialog(con);		
		dialog.setContentView(R.layout.scoringdialog);	

		int percent_int = this.tracing_score();

		//stored score database
		db.addScore(user_id, Practice_tracing.category_type.toString(), percent_int);		
		
		ImageView draw_star = (ImageView) dialog.findViewById(R.id.draw_star);
		
		if(percent_int > 20 && percent_int < 40){
			draw_star.setImageResource(R.drawable.star_score_2);	
		}else if(percent_int > 39 && percent_int < 60){
			draw_star.setImageResource(R.drawable.star_score_3);	
		}else if(percent_int > 59 && percent_int < 80){
			draw_star.setImageResource(R.drawable.star_score_4);	
		}else if(percent_int > 80){
			draw_star.setImageResource(R.drawable.star_score_5);	
		}else{
			draw_star.setImageResource(R.drawable.star_score);	
		}	
		dialog.setTitle("Your Rating Star");
	
		dialog.show();		
		dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
		@Override
		public void onDismiss(final DialogInterface arg0) {
				next_diag.show();				
			}
		});		
	}	
	
	public void done_tracing(View view){			
			Intent refresh = new Intent(getApplicationContext(), Evaluation.class);
			finish(); 
			startActivity(refresh);
	}
	
	public void prev_tracing(View view){
		Practice_tracing.tracing_type = "practice";			
		Practice_tracing.category_type = tracing_map.getPrev(Practice_tracing.category_type);		
		Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
		finish(); 
		startActivity(refresh);		
	}
	
	public void next_tracing(View view){		
		Practice_tracing.tracing_type = "practice";
		Practice_tracing.category_type = tracing_map.getNext(Practice_tracing.category_type);				
		Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
		finish(); 
		startActivity(refresh);		
	}

	public void retry_tracing(View view){									
		Intent refresh = new Intent(getApplicationContext(), Practice_tracing.class);
		finish(); 
		startActivity(refresh);		
	}	
}