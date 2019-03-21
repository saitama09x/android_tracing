package com.android.controller;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import com.android.R;
import android.graphics.Typeface;

public class ScoreListAdapter extends ArrayAdapter<String>{

private final Activity context;
private final String[] web;
private final Integer[] imageId;
private final String[] score_;
private final String[] user_eval;
private final String[] user_date;

public ScoreListAdapter(Context context, String[] web, Integer[] imageId, String[] score_, String[] user_eval, String[] user_date) {
super(context, R.layout.score_list, web);
this.context = (Activity) context;
this.web = web;
this.imageId = imageId;
this.score_ = score_;
this.user_eval = user_eval;
this.user_date = user_date;
}

@Override
public View getView(int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.score_list, null, true);
		
	Typeface face= Typeface.createFromAsset(context.getAssets(), "font/snickles.ttf");

	TextView user_eval_ = (TextView) rowView.findViewById(R.id.user_eval);
	user_eval_.setTypeface(face);
	
	ImageView star_score = (ImageView) rowView.findViewById(R.id.star_score);
	star_score.setImageResource(imageId[position]);
	user_eval_.setText(user_eval[position]);	
	return rowView;
}

}