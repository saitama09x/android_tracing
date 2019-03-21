package com.android.objects;

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
import com.android.model.*;
import com.android.R;
import com.android.tracing.*;
import java.util.*;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.view.ViewGroup.LayoutParams;

public class SoundObjects{

	private HashMap<String, String> speak_text = new HashMap<String, String>();

	public SoundObjects(){

		speak_text.put("big_a", "Write Big A");
		speak_text.put("big_b", "Write Big B");
		speak_text.put("big_c", "Write Big C");
		speak_text.put("big_d", "Write Big D");
		speak_text.put("big_e", "Write Big E");
		speak_text.put("big_f", "Write Big F");
		speak_text.put("big_g", "Write Big G");
		speak_text.put("big_h", "Write Big H");

		speak_text.put("big_i", "Write Big I");
		speak_text.put("big_j", "Write Big J");
		speak_text.put("big_k", "Write Big K");
		speak_text.put("big_l", "Write Big L");
		speak_text.put("big_m", "Write Big M");
		speak_text.put("big_n", "Write Big N");
		speak_text.put("big_o", "Write Big O");
		speak_text.put("big_p", "Write Big P");
		speak_text.put("big_q", "Write Big Q");	

		speak_text.put("big_r", "Write Big R");
		speak_text.put("big_s", "Write Big S");
		speak_text.put("big_t", "Write Big T");
		speak_text.put("big_u", "Write Big U");
		speak_text.put("big_v", "Write Big V");
		speak_text.put("big_w", "Write Big W");
		speak_text.put("big_x", "Write Big X");
		speak_text.put("big_y", "Write Big Y");
		speak_text.put("big_z", "Write Big Z");


		speak_text.put("small_a", "Write small A");
		speak_text.put("small_b", "Write small B");
		speak_text.put("small_c", "Write small C");
		speak_text.put("small_d", "Write small D");
		speak_text.put("small_e", "Write small E");
		speak_text.put("small_f", "Write small F");
		speak_text.put("small_g", "Write small G");
		speak_text.put("small_h", "Write small H");

		speak_text.put("small_i", "Write small I");
		speak_text.put("small_j", "Write small J");
		speak_text.put("small_k", "Write small K");
		speak_text.put("small_l", "Write small L");
		speak_text.put("small_m", "Write small M");
		speak_text.put("small_n", "Write small N");
		speak_text.put("small_o", "Write small O");
		speak_text.put("small_p", "Write small P");
		speak_text.put("small_q", "Write small Q");	

		speak_text.put("small_r", "Write small R");
		speak_text.put("small_s", "Write small S");
		speak_text.put("small_t", "Write small T");
		speak_text.put("small_u", "Write small U");
		speak_text.put("small_v", "Write small V");
		speak_text.put("small_w", "Write small W");
		speak_text.put("small_x", "Write small X");
		speak_text.put("small_y", "Write small Y");
		speak_text.put("small_z", "Write small Z");

		speak_text.put("circle", "Draw Circle");
		speak_text.put("triangle", "Draw Triangle");
		speak_text.put("star", "Draw Star");
		speak_text.put("rectangle", "Draw Rectangle");
		speak_text.put("diamond", "Draw Diamond");
		speak_text.put("square", "Draw Square");

		speak_text.put("number_0", "Write Number 0");
		speak_text.put("number_1", "Write Number 1");
		speak_text.put("number_2", "Write Number 2");
		speak_text.put("number_3", "Write Number 3");
		speak_text.put("number_4", "Write Number 4");
		speak_text.put("number_5", "Write Number 5");
		speak_text.put("number_6", "Write Number 6");
		speak_text.put("number_7", "Write Number 7");
		speak_text.put("number_8", "Write Number 8");
		speak_text.put("number_9", "Write Number 9");

	}


	public void setSpeak(String key, String value){
		speak_text.put(key, value);
	}

	public String getSpeak(String key){
		return speak_text.get(key);
	}
}