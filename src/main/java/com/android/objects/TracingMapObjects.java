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

public class TracingMapObjects{

	private HashMap<String, String> letter_map_prev = new HashMap<String, String>();
	private HashMap<String, String> letter_map_next = new HashMap<String, String>();


	public void setLetter_A_H(String type){

		letter_map_prev.put( type + "_a",  type + "_h");
		letter_map_prev.put( type + "_b",  type + "_a");
		letter_map_prev.put( type + "_c",  type + "_b");
		letter_map_prev.put( type + "_d",  type + "_c");
		letter_map_prev.put( type + "_e",  type + "_d");
		letter_map_prev.put( type + "_f",  type + "_e");
		letter_map_prev.put( type + "_g",  type + "_f");
		letter_map_prev.put( type + "_h",  type + "_g");

		//next letters
		letter_map_next.put( type + "_a",  type + "_b");
		letter_map_next.put( type + "_b",  type + "_c");
		letter_map_next.put( type + "_c",  type + "_d");
		letter_map_next.put( type + "_d",  type + "_e");
		letter_map_next.put( type + "_e",  type + "_f");
		letter_map_next.put( type + "_f",  type + "_g");
		letter_map_next.put( type + "_g",  type + "_h");
		letter_map_next.put( type + "_h",  type + "_a");

	}

	public void setLetter_I_Q(String type){
		letter_map_prev.put( type + "_i",  type + "_q");
		letter_map_prev.put( type + "_j",  type + "_i");
		letter_map_prev.put( type + "_k",  type + "_j");
		letter_map_prev.put( type + "_l",  type + "_k");
		letter_map_prev.put( type + "_m",  type + "_l");
		letter_map_prev.put( type + "_n",  type + "_m");
		letter_map_prev.put( type + "_o",  type + "_n");
		letter_map_prev.put( type + "_p",  type + "_o");
		letter_map_prev.put( type + "_q",  type + "_p");
		//next letters
		letter_map_next.put( type + "_i",  type + "_j");
		letter_map_next.put( type + "_j",  type + "_k");
		letter_map_next.put( type + "_k",  type + "_l");
		letter_map_next.put( type + "_l",  type + "_m");
		letter_map_next.put( type + "_m",  type + "_n");
		letter_map_next.put( type + "_n",  type + "_o");
		letter_map_next.put( type + "_o",  type + "_p");
		letter_map_next.put( type + "_p",  type + "_q");
		letter_map_next.put( type + "_q",  type + "_i");	
	}

	public void setLetter_R_Z(String type){
		letter_map_prev.put( type + "_z", type + "_y");
		letter_map_prev.put( type + "_y", type + "_x");
		letter_map_prev.put( type + "_x", type + "_w");
		letter_map_prev.put( type + "_w", type + "_v");
		letter_map_prev.put( type + "_v", type + "_u");
		letter_map_prev.put(type + "_u", type + "_t");
		letter_map_prev.put(type + "_t", type + "_s");
		letter_map_prev.put(type + "_s", type + "_r");
		letter_map_prev.put(type + "_r", type + "_z");

		letter_map_next.put(type + "_r", type + "_s");
		letter_map_next.put(type + "_s", type + "_t");
		letter_map_next.put(type + "_t", type + "_u");
		letter_map_next.put(type + "_u", type + "_v");
		letter_map_next.put(type + "_v", type + "_w");
		letter_map_next.put(type + "_w", type + "_x");
		letter_map_next.put(type + "_x", type + "_y");
		letter_map_next.put(type + "_y", type + "_z");
		letter_map_next.put(type + "_z", type + "_r");
	}

	public void setShape(){
		letter_map_next.put("circle", "diamond");	
		letter_map_next.put("diamond", "rectangle");	
		letter_map_next.put("rectangle", "star");
		letter_map_next.put("star", "triangle");
		letter_map_next.put("triangle", "square");
		letter_map_next.put("square", "circle");

		letter_map_prev.put("circle", "triangle");	
		letter_map_prev.put("triangle", "star");	
		letter_map_prev.put("star", "rectangle");
		letter_map_prev.put("rectangle", "diamond");
		letter_map_prev.put("diamond", "square");
		letter_map_prev.put("square", "circle");
	}

	public void setNumber(){
		letter_map_prev.put("number_9", "number_8");	
		letter_map_prev.put("number_8", "number_7");	
		letter_map_prev.put("number_7", "number_6");	
		letter_map_prev.put("number_6", "number_5");	
		letter_map_prev.put("number_5", "number_4");	
		letter_map_prev.put("number_4", "number_3");	
		letter_map_prev.put("number_3", "number_2");	
		letter_map_prev.put("number_2", "number_1");	
		letter_map_prev.put("number_1", "number_0");
		letter_map_prev.put("number_0", "number_9");
		
		letter_map_next.put("number_0", "number_1");	
		letter_map_next.put("number_1", "number_2");	
		letter_map_next.put("number_2", "number_3");
		letter_map_next.put("number_3", "number_4");
		letter_map_next.put("number_4", "number_5");
		letter_map_next.put("number_5", "number_6");
		letter_map_next.put("number_6", "number_7");
		letter_map_next.put("number_7", "number_8");
		letter_map_next.put("number_8", "number_9");
		letter_map_next.put("number_9", "number_0");
	}

	public String getNext(String key){
		return letter_map_next.get(key);
	}

	public String getPrev(String key){
		return letter_map_prev.get(key);	
	}	

}