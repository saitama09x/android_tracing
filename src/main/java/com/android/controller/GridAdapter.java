package com.android.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.*;
import android.content.Intent;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Arrays;
import java.util.HashMap;
import android.database.Cursor;
import com.android.model.*;
import com.android.R;
import com.android.controller.evaluation.*;
import android.graphics.Typeface;

public class GridAdapter extends BaseAdapter {
   private Context mContext;
   Db_sqlite db;   
   int user_id;
   String category;
   private HashMap<String, String> map;
   private HashMap<String, Integer> number_img;
   private HashMap<String, Integer> letter_img;
   private HashMap<String, Integer> shape_img;
   // Constructor
   public GridAdapter(Context c,  HashMap map) {
      mContext = c;
	  db = new Db_sqlite(mContext);
	  user_id = 1;
	  this.map = map;	
	  if(Evaluation.eval_type == "scoring_numbers"){

	  number_img = new HashMap<String, Integer>();

	  number_img.put("number_0", R.drawable.icon_number_0);
	  number_img.put("number_1", R.drawable.icon_number_1_dup);
	  number_img.put("number_2", R.drawable.icon_number_2);
	  number_img.put("number_3", R.drawable.icon_number_3);
	  number_img.put("number_4", R.drawable.icon_number_4);
	  number_img.put("number_5", R.drawable.icon_number_5);
	  number_img.put("number_6", R.drawable.icon_number_6);
	  number_img.put("number_7", R.drawable.icon_number_7);
	  number_img.put("number_8", R.drawable.icon_number_8);
	  number_img.put("number_9", R.drawable.icon_number_9);
	  	
	  }

	  if(Evaluation.eval_type == "scoring_big_letters"){

	  letter_img = new HashMap<String, Integer>();
	  letter_img.put("big_a", R.drawable.icon_big_a);
	  letter_img.put("big_b", R.drawable.icon_big_b);
	  letter_img.put("big_c", R.drawable.icon_big_c);
	  letter_img.put("big_d", R.drawable.icon_big_d);
	  letter_img.put("big_e", R.drawable.icon_big_e);
	  letter_img.put("big_f", R.drawable.icon_big_f);
	  letter_img.put("big_g", R.drawable.icon_big_g);
	  letter_img.put("big_h", R.drawable.icon_big_h);
	  letter_img.put("big_i", R.drawable.icon_big_i);
	  letter_img.put("big_j", R.drawable.icon_big_j);
	  letter_img.put("big_k", R.drawable.icon_big_k);
	  letter_img.put("big_l", R.drawable.icon_big_l);
	  letter_img.put("big_m", R.drawable.icon_big_m);
	  letter_img.put("big_n", R.drawable.icon_big_n);
	  letter_img.put("big_o", R.drawable.icon_big_o);
	  letter_img.put("big_p", R.drawable.icon_big_p);
	  letter_img.put("big_q", R.drawable.icon_big_q);
	  letter_img.put("big_r", R.drawable.icon_big_r);
	  letter_img.put("big_s", R.drawable.icon_big_s);
	  letter_img.put("big_t", R.drawable.icon_big_t);
	  letter_img.put("big_u", R.drawable.icon_big_u);
	  letter_img.put("big_v", R.drawable.icon_big_v);
	  letter_img.put("big_w", R.drawable.icon_big_w);
	  letter_img.put("big_x", R.drawable.icon_big_x);
	  letter_img.put("big_y", R.drawable.icon_big_y);
	  letter_img.put("big_z", R.drawable.icon_big_z);
	  }

	  if(Evaluation.eval_type == "scoring_small_letters"){
  	  letter_img = new HashMap<String, Integer>();
	  letter_img.put("small_a", R.drawable.letter_small_a);
	  letter_img.put("small_b", R.drawable.letter_small_b);
	  letter_img.put("small_c", R.drawable.letter_small_c);
	  letter_img.put("small_d", R.drawable.letter_small_d);
	  letter_img.put("small_e", R.drawable.letter_small_e);
	  letter_img.put("small_f", R.drawable.letter_small_f);
	  letter_img.put("small_g", R.drawable.letter_small_g);
	  letter_img.put("small_h", R.drawable.letter_small_h);
	  letter_img.put("small_i", R.drawable.letter_small_i);
	  letter_img.put("small_j", R.drawable.letter_small_j);
	  letter_img.put("small_k", R.drawable.letter_small_k);
	  letter_img.put("small_l", R.drawable.letter_small_l);
	  letter_img.put("small_m", R.drawable.letter_small_m);
	  letter_img.put("small_n", R.drawable.letter_small_n);
	  letter_img.put("small_o", R.drawable.letter_small_o);
	  letter_img.put("small_p", R.drawable.letter_small_p);
	  letter_img.put("small_q", R.drawable.letter_small_q);
	  letter_img.put("small_r", R.drawable.letter_small_r);
	  letter_img.put("small_s", R.drawable.letter_small_s);
	  letter_img.put("small_t", R.drawable.letter_small_t);
	  letter_img.put("small_u", R.drawable.letter_small_u);
	  letter_img.put("small_v", R.drawable.letter_small_v);
	  letter_img.put("small_w", R.drawable.letter_small_w);
	  letter_img.put("small_x", R.drawable.letter_small_x);
	  letter_img.put("small_y", R.drawable.letter_small_y);
	  letter_img.put("small_z", R.drawable.letter_small_z);
	  }


	  if(Evaluation.eval_type == "scoring_shapes"){
	  shape_img = new HashMap<String, Integer>();
	  shape_img.put("circle", R.drawable.icon_circle);
	  shape_img.put("diamond", R.drawable.icon_diamond);
	  shape_img.put("rectangle", R.drawable.icon_rectangle);
	  shape_img.put("square", R.drawable.icon_square);
	  shape_img.put("star", R.drawable.icon_star);
	  shape_img.put("triangle", R.drawable.icon_triangle);
	  }
	  
   }
   
   public int getCount() {
   	if(Evaluation.eval_type == "scoring_big_letters"){
   		return letter_category_big.length;	
   	}else if(Evaluation.eval_type == "scoring_small_letters"){
   		return letter_category_small.length;	
   	}else if(Evaluation.eval_type == "scoring_shapes"){
   		return shape_array.length;	
   	}else if(Evaluation.eval_type == "scoring_numbers"){
   		return number_category.length;	
   	}
      	return 0;
   }

   public Object getItem(int position) {
      return null;
   }

   public long getItemId(int position) {
      return 0;
   }
   
   	@Override
     public boolean isEnabled(int i) {
     return true;
	}

   public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View gridView = new View(mContext);		
		Typeface face= Typeface.createFromAsset(mContext.getAssets(), "font/colvetica.ttf");		

		if(Evaluation.eval_type == "scoring_big_letters"){	
			gridView = inflater.inflate(R.layout.gridview, null);
			ImageView letter_tag = (ImageView) gridView.findViewById(R.id.letter_label);
			letter_tag.setImageResource(letter_img.get(letter_category_big[position]));	
			letter_tag.setTag(letter_category_big[position]);
		}else if(Evaluation.eval_type == "scoring_small_letters"){
			gridView = inflater.inflate(R.layout.gridview, null);
			ImageView letter_tag = (ImageView) gridView.findViewById(R.id.letter_label);
			letter_tag.setImageResource(letter_img.get(letter_category_small[position]));	
			letter_tag.setTag(letter_category_small[position]);
		}else if(Evaluation.eval_type == "scoring_shapes"){
			gridView = inflater.inflate(R.layout.gridview_shape, null);
			ImageView shape_label = (ImageView) gridView.findViewById(R.id.shape_label);
			shape_label.setImageResource(shape_img.get(shape_category[position]));	
			shape_label.setTag(shape_category[position]);
		}else if(Evaluation.eval_type == "scoring_numbers"){
			gridView = inflater.inflate(R.layout.gridview_numbers, null);
			ImageView number_label = (ImageView) gridView.findViewById(R.id.number_label);
			number_label.setImageResource(number_img.get(number_category[position]));	
			number_label.setTag(number_category[position]);
		}
		

		int poor = 0;
		int good = 0;
		int v_good = 0;
		int vv_good = 0;
		int excelent = 0;
				
		TextView total_score = (TextView) gridView.findViewById(R.id.total_score);
			
		Cursor res = db.getTotalScore(user_id, letter_category_big[position]);

		if(Evaluation.eval_type == "scoring_small_letters"){
			res = db.getTotalScore(user_id, letter_category_small[position]);
		}else if(Evaluation.eval_type == "scoring_shapes"){
			res = db.getTotalScore(user_id, shape_category[position]);
		}else if(Evaluation.eval_type == "scoring_numbers"){
			res = db.getTotalScore(user_id, number_category[position]);
		}

		res.moveToFirst();
		while(res.isAfterLast() == false){				
			if(res.getInt(res.getColumnIndex("score")) > 20 && res.getInt(res.getColumnIndex("score")) < 40){
				good++;	
			}else if(res.getInt(res.getColumnIndex("score")) > 39 && res.getInt(res.getColumnIndex("score")) < 60){
				v_good++;
			}else if(res.getInt(res.getColumnIndex("score")) > 59 && res.getInt(res.getColumnIndex("score")) < 80){
				vv_good++;
			}else if(res.getInt(res.getColumnIndex("score")) > 80){
				excelent++;
			}else{
				poor++;
			}			
			res.moveToNext();
		}
		

		HashMap<Integer, String> user_eval_map = new HashMap<Integer, String>();
		
		user_eval_map.put(good, "Nice");
		user_eval_map.put(v_good, "Good");
		user_eval_map.put(vv_good, "Excellent");
		user_eval_map.put(excelent, "Perfect");
		user_eval_map.put(poor, "");
		int[] user_eval_int = {good, v_good, vv_good, excelent, poor};
		Arrays.sort(user_eval_int);
		total_score.setTypeface(face);
		total_score.setText(user_eval_map.get(user_eval_int[user_eval_int.length - 1]));	
		return gridView;
   }

  public String[] letter_array_big = {
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
   };
  
  public String[] letter_array_small = {
		"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
   }; 

  public String[] shape_array = {
  	"circle", "diamond", "rectangle", "star", "triangle", "square"
  };

  public String[] number_array = {
  	"Number Zero", "Number One", "Number Two", "Number Three"
  };

  public String[] letter_category_big = {
	  "big_a", "big_b", "big_c", "big_d", "big_e", "big_f", "big_g", "big_h", "big_i", "big_j", "big_k", "big_l", "big_m", "big_n", "big_o", "big_p",
	   "big_q", "big_r", "big_s", "big_t", "big_u", "big_v", "big_w", "big_x", "big_y", "big_z" };

  public String[] letter_category_small = {
	  "small_a", "small_b", "small_c", "small_d", "small_e", "small_f", "small_g", "small_h", "small_i", "small_j", "small_k", "small_l", "small_m", "small_n", "small_o", "small_p",
	   "small_q", "small_r", "small_s", "small_t", "small_u", "small_v", "small_w", "small_x", "small_y", "small_z" };
    
  public String[] shape_category = {
  	"circle", "diamond", "rectangle", "star", "triangle", "square"
  };

  public String[] number_category = {
  	"number_0", "number_1", "number_2", "number_3", "number_4", "number_5", "number_6", "number_7", "number_8", "number_9"
  };



}
