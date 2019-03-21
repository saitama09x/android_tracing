package com.android.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import com.android.R;

public class Db_sqlite extends SQLiteOpenHelper {
  
  public Db_sqlite(Context context)
   {
      super(context, "myDBName_2.db" , null, 1);
   }
   
   @Override
   public void onCreate(SQLiteDatabase db) {
      // TODO Auto-generated method stub
      db.execSQL(
      "create table if not exists users " +
      "(id integer primary key, fname varchar, lname varchar, uname varchar, pword varchar)"
      );
	  
	  db.execSQL(    
      "create table if not exists user_type (id integer primary key, type varchar, user_id int)"
      );
	  
	  
	  db.execSQL(    
      "create table if not exists user_score (id integer primary key, user_id int, category varchar, score int, date_created varchar)"
      );
	  
	  
		ContentValues contentValues = new ContentValues();
		contentValues.put("fname", "admin");
		contentValues.put("lname", "admin123");
		contentValues.put("uname", "admin");	
		contentValues.put("pword", "admin123");   
		db.insert("users", null, contentValues);
	  
		contentValues = new ContentValues();
		contentValues.put("type", "STUDENT");
		contentValues.put("user_id", 1);
		db.insert("user_type", null, contentValues);

		contentValues = new ContentValues();
		contentValues.put("user_id", 1);
		contentValues.put("category", "big_a");
		contentValues.put("score", 0);
		contentValues.put("date_created", "2016-01-01");
		db.insert("user_score", null, contentValues);
	

		contentValues = new ContentValues();
		contentValues.put("user_id", 1);
		contentValues.put("category", "circle");
		contentValues.put("score", 50);
		contentValues.put("date_created", "2016-01-01");
		db.insert("user_score", null, contentValues);
		
	   	contentValues = new ContentValues();
		contentValues.put("user_id", 1);
		contentValues.put("category", "circle");
		contentValues.put("score", 50);
		contentValues.put("date_created", "2016-01-01");
		db.insert("user_score", null, contentValues);

		contentValues = new ContentValues();
		contentValues.put("fname", "naruto");
		contentValues.put("lname", "uzumaki");
		contentValues.put("uname", "admin3");	
		contentValues.put("pword", "admin123");   
		db.insert("users", null, contentValues);

		contentValues = new ContentValues();
		contentValues.put("type", "STUDENT");
		contentValues.put("user_id", 2);
		db.insert("user_type", null, contentValues);

		contentValues = new ContentValues();
		contentValues.put("user_id", 2);
		contentValues.put("category", "big_a");
		contentValues.put("score", 0);
		contentValues.put("date_created", "2016-01-01");
		db.insert("user_score", null, contentValues);

		contentValues = new ContentValues();
		contentValues.put("fname", "admin");
		contentValues.put("lname", "admin123");
		contentValues.put("uname", "admin1");	
		contentValues.put("pword", "admin123");   
		db.insert("users", null, contentValues);
	  
		contentValues = new ContentValues();
		contentValues.put("type", "TEACHER");
		contentValues.put("user_id", 3);
		db.insert("user_type", null, contentValues);
   }
   
   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      // TODO Auto-generated method stub
      db.execSQL("DROP TABLE IF EXISTS users");
      onCreate(db);
   }
   
   public boolean addUser(String fname, String lname,String uname,String pword)
   {
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put("fname", fname);
      contentValues.put("lname", lname);
      contentValues.put("uname", uname);	
      contentValues.put("pword", pword);   
      db.insert("users", null, contentValues);
      return true;
   }
   
   public boolean addType(String type, String uname){
	   
	   SQLiteDatabase db = this.getWritableDatabase();
	   Cursor res = db.rawQuery("select id from users where uname = '"+uname+"'", null);
	   res.moveToFirst();	   
	   ContentValues contentValues = new ContentValues();
	   contentValues.put("type", type);
	   contentValues.put("user_id", res.getInt(0));
	   db.insert("user_type", null, contentValues);
	   return true;
	   
   }
   
   public Cursor getData(String uname, String pword, String type){
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor res =  db.rawQuery( "select a.id, a.fname, a.lname, a.uname, b.type from users a "+
	  "left join user_type b on a.id = b.user_id "+
	  "where a.uname= '" + uname + "' and a.pword='" + pword + "' and b.type = '" + type + "'", null );
      return res;
   }
   
	public Cursor getUser(int id){
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor res =  db.rawQuery( "select a.id, a.fname, a.lname, a.uname, b.type from users a "+
	  "left join user_type b on a.id = b.user_id "+
	  "where a.id = " + id, null );
      return res;
   }

   public List<AllStudent> getAllStudent(){
	   List<AllStudent> array_list = new ArrayList<AllStudent>();
	   SQLiteDatabase db = this.getReadableDatabase();
	   Cursor res = db.rawQuery("select a.id, a.fname, a.lname from users a "+
	   "left join user_type b on a.id = b.user_id where b.type = 'STUDENT'", null);
	   res.moveToFirst();
	   while(res.isAfterLast() == false){
		    array_list.add(new AllStudent(res.getInt(0), new String(res.getString(1) + " " 
		    	+ res.getString(2))));
		    res.moveToNext();
	   }
	   return array_list;
   }
   
      public List<Score_img>  getDataScore(int user_id){		
		List<Score_img> array_list = new ArrayList<Score_img>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res =  db.rawQuery( "select * from user_score a left join users b on a.user_id = b.id "+
		"where a.user_id= '" + user_id + "' group by a.id", null );
		res.moveToFirst();
		  while(res.isAfterLast() == false){			  
			 if(res.getInt(res.getColumnIndex("score")) > 19 && res.getInt(res.getColumnIndex("score")) < 40){
				array_list.add(new Score_img(res.getString(res.getColumnIndex("fname")), 
				R.drawable.star_score_2, res.getInt(res.getColumnIndex("score")), res.getString(res.getColumnIndex("date_created"))));	
			 } else if(res.getInt(res.getColumnIndex("score")) > 39 && res.getInt(res.getColumnIndex("score")) < 60){
				array_list.add(new Score_img(res.getString(res.getColumnIndex("fname")), 
				R.drawable.star_score_3, res.getInt(res.getColumnIndex("score")), res.getString(res.getColumnIndex("date_created"))));	
			 }	else if(res.getInt(res.getColumnIndex("score")) > 59 && res.getInt(res.getColumnIndex("score")) < 80){
				array_list.add(new Score_img(res.getString(res.getColumnIndex("fname")), 
				R.drawable.star_score_4, res.getInt(res.getColumnIndex("score")), res.getString(res.getColumnIndex("date_created"))));	
			 }	else if(res.getInt(res.getColumnIndex("score")) > 80){
				 array_list.add(new Score_img(res.getString(res.getColumnIndex("fname")), 
				 R.drawable.star_score_5, res.getInt(res.getColumnIndex("score")), res.getString(res.getColumnIndex("date_created"))));	
			 }else{
				 array_list.add(new Score_img(res.getString(res.getColumnIndex("fname")), 
				 R.drawable.star_score, res.getInt(res.getColumnIndex("score")), res.getString(res.getColumnIndex("date_created"))));	
			 }
			 res.moveToNext();
		  }
			return array_list;
	}
      
	public List<Score_img>  getScoreByCat(int user_id, String cat){		
		List<Score_img> array_list = new ArrayList<Score_img>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res =  db.rawQuery( "select a.score, b.fname, a.date_created from user_score a "+
		"left join users b on a.user_id = b.id where a.user_id= '" + user_id + "' and a.category = '" + cat + "'", null );
		res.moveToFirst();
		  while(res.isAfterLast() == false){			  
			 if(res.getInt(res.getColumnIndex("score")) > 19 && res.getInt(res.getColumnIndex("score")) < 40){
				array_list.add(new Score_img(res.getString(res.getColumnIndex("fname")), 
				R.drawable.star_score_2, res.getInt(res.getColumnIndex("score")), 
				res.getString(res.getColumnIndex("date_created"))));	
			 } else if(res.getInt(res.getColumnIndex("score")) > 39 && res.getInt(res.getColumnIndex("score")) < 60){
				array_list.add(new Score_img(res.getString(res.getColumnIndex("fname")), 
				R.drawable.star_score_3, res.getInt(res.getColumnIndex("score")), 
				res.getString(res.getColumnIndex("date_created"))));	
			 }	else if(res.getInt(res.getColumnIndex("score")) > 59 && res.getInt(res.getColumnIndex("score")) < 80){
				array_list.add(new Score_img(res.getString(res.getColumnIndex("fname")), 
				R.drawable.star_score_4, res.getInt(res.getColumnIndex("score")), 
				res.getString(res.getColumnIndex("date_created"))));	
			 }	else if(res.getInt(res.getColumnIndex("score")) > 80){
				 array_list.add(new Score_img(res.getString(res.getColumnIndex("fname")), 
				 R.drawable.star_score_5, res.getInt(res.getColumnIndex("score")),
				 res.getString(res.getColumnIndex("date_created"))));	
			 }else{
				 array_list.add(new Score_img(res.getString(res.getColumnIndex("fname")), 
				 R.drawable.star_score, res.getInt(res.getColumnIndex("score")),
				 res.getString(res.getColumnIndex("date_created"))));	
			 }
			 res.moveToNext();
		  }
			return array_list;
	}
   
   public Cursor getTotalScore(int user_id, String cat){
	   SQLiteDatabase db = this.getReadableDatabase();
	   Cursor res =  db.rawQuery( "select score from user_score where "+
	   "user_id = '" + user_id + "' and category = '" + cat + "'", null);
		return res;   
   }
   
   
   public boolean addScore(int user_id, String category, int score){
	        SQLiteDatabase db = this.getWritableDatabase();
			ContentValues contentValues = new ContentValues();
			contentValues.put("user_id", user_id);
			contentValues.put("category", category);
			contentValues.put("score", score);
			contentValues.put("date_created", "2016-01-01");
			db.insert("user_score", null, contentValues);
			return true;
   }
   
   public int numberOfRows(){
      SQLiteDatabase db = this.getReadableDatabase();
      int numRows = (int) DatabaseUtils.queryNumEntries(db, "users");
      return numRows;
   }
   
    public int numberOfscore(){
		  SQLiteDatabase db = this.getReadableDatabase();
		  int numRows = (int) DatabaseUtils.queryNumEntries(db, "user_score");
		  return numRows;
   }
   
}
