package com.android.tracing;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.*;
import java.util.ArrayList;
import com.android.controller.*;
import com.android.R;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class Tracing_algorithm extends View {

    private Paint paint = new Paint();
    private Paint font = new Paint();
    private Path path = new Path();
	private String category_type = Practice_tracing.category_type;
	private String tracing_type = Practice_tracing.tracing_type;
    Bitmap b;
    View newView;
    float eventX = 0, eventY = 0;
    static int score = 0;
    ArrayList score_arr = new ArrayList();
	ArrayList step_arr = new ArrayList();
	HashMap<Integer, Integer> x_map = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> y_map = new HashMap<Integer, Integer>();
	HashMap<String, int[]> num_grid_map = new HashMap<String, int[]>();
	HashMap<String, int[]> wrong_grid_map = new HashMap<String, int[]>();
	int[] right_tracing;
	int[] wrong_tracing;
	HashMap<String, Integer> background_letter = new HashMap<String, Integer>();
	Grid_list grid;
    public Tracing_algorithm(Context context) {
        super(context);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(50f);
        if(category_type == "small_a" || category_type == "small_i" || category_type == "small_r"){
        	paint.setStrokeWidth(25f);
        }
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        font.setAntiAlias(true);
        font.setStrokeWidth(1f);
        font.setColor(Color.BLACK);
        font.setStyle(Paint.Style.STROKE);
        font.setStrokeJoin(Paint.Join.ROUND);
        font.setTextSize(15f);	

		grid = new Grid_list();
		
		right_tracing = Arrays.copyOf(grid.get_rightgrid(Practice_tracing.category_type), 
			grid.get_rightgrid(Practice_tracing.category_type).length);

		wrong_tracing = Arrays.copyOf(grid.get_wronggrid(Practice_tracing.category_type), 
			grid.get_wronggrid(Practice_tracing.category_type).length);

		if(Practice_tracing.tracing_type == "practice"){		
			background_letter.put("big_a", R.drawable.letter_big_a);
			background_letter.put("big_b", R.drawable.letter_big_b);
			background_letter.put("big_c", R.drawable.letter_big_c);
			background_letter.put("big_d", R.drawable.letter_big_d);
			background_letter.put("big_e", R.drawable.letter_big_e);
			background_letter.put("big_f", R.drawable.letter_big_f);
			background_letter.put("big_g", R.drawable.letter_big_g);
			background_letter.put("big_h", R.drawable.letter_big_h);
			background_letter.put("big_i", R.drawable.letter_big_i);
			background_letter.put("big_j", R.drawable.letter_big_j);
			background_letter.put("big_k", R.drawable.letter_big_k);
			background_letter.put("big_l", R.drawable.letter_big_l);
			background_letter.put("big_m", R.drawable.letter_big_m);
			background_letter.put("big_n", R.drawable.letter_big_n);
			background_letter.put("big_o", R.drawable.letter_big_o);
			background_letter.put("big_p", R.drawable.letter_big_p);
			background_letter.put("big_q", R.drawable.letter_big_q);
			background_letter.put("big_r", R.drawable.letter_big_r);
			background_letter.put("big_s", R.drawable.letter_big_s);
			background_letter.put("big_t", R.drawable.letter_big_t);
			background_letter.put("big_u", R.drawable.letter_big_u);
			background_letter.put("big_v", R.drawable.letter_big_v);
			background_letter.put("big_w", R.drawable.letter_big_w);
			background_letter.put("big_x", R.drawable.letter_big_x);
			background_letter.put("big_y", R.drawable.letter_big_y);
			background_letter.put("big_z", R.drawable.letter_big_z);


			background_letter.put("small_a", R.drawable.letter_small_a);
			background_letter.put("small_b", R.drawable.letter_small_b);
			background_letter.put("small_c", R.drawable.letter_small_c);
			background_letter.put("small_d", R.drawable.letter_small_d);
			background_letter.put("small_e", R.drawable.letter_small_e);
			background_letter.put("small_f", R.drawable.letter_small_f);
			background_letter.put("small_g", R.drawable.letter_small_g);
			background_letter.put("small_h", R.drawable.letter_small_h);
			background_letter.put("small_i", R.drawable.letter_small_i);
			background_letter.put("small_j", R.drawable.letter_small_j);
			background_letter.put("small_k", R.drawable.letter_small_k);
			background_letter.put("small_l", R.drawable.letter_small_l);
			background_letter.put("small_m", R.drawable.letter_small_m);
			background_letter.put("small_n", R.drawable.letter_small_n);
			background_letter.put("small_o", R.drawable.letter_small_o);
			background_letter.put("small_p", R.drawable.letter_small_p);
			background_letter.put("small_q", R.drawable.letter_small_q);
			background_letter.put("small_r", R.drawable.letter_small_r);
			background_letter.put("small_s", R.drawable.letter_small_s);
			background_letter.put("small_t", R.drawable.letter_small_t);
			background_letter.put("small_u", R.drawable.letter_small_u);
			background_letter.put("small_v", R.drawable.letter_small_v);
			background_letter.put("small_w", R.drawable.letter_small_w);
			background_letter.put("small_x", R.drawable.letter_small_x);
			background_letter.put("small_y", R.drawable.letter_small_y);
			background_letter.put("small_z", R.drawable.letter_small_z);

			background_letter.put("circle", R.drawable.shape_circle);
			background_letter.put("diamond", R.drawable.shape_diamond);
			background_letter.put("rectangle", R.drawable.shape_rectangle);
			background_letter.put("star", R.drawable.shape_star);
			background_letter.put("triangle", R.drawable.shape_triangle);
			background_letter.put("square", R.drawable.shape_square);

			background_letter.put("number_0", R.drawable.number_0);
			background_letter.put("number_1", R.drawable.number_1);
			background_letter.put("number_2", R.drawable.number_2);
			background_letter.put("number_3", R.drawable.number_3);
			background_letter.put("number_4", R.drawable.number_4);
			background_letter.put("number_5", R.drawable.number_5);
			background_letter.put("number_6", R.drawable.number_6);
			background_letter.put("number_7", R.drawable.number_7);
			background_letter.put("number_8", R.drawable.number_8);
			background_letter.put("number_9", R.drawable.number_9);

			setBackgroundResource(background_letter.get(category_type));			
		}
		
		Practice_tracing.list_pixel_x.clear();
		Practice_tracing.list_pixel_y.clear();
		Practice_tracing.score_arr.clear();
		Practice_tracing.score_wrong.clear();
		num_grid_map.clear();
		wrong_grid_map.clear();

		num_grid_map.put(Practice_tracing.category_type, right_tracing);
		wrong_grid_map.put(Practice_tracing.category_type, wrong_tracing);

		Practice_tracing.wrong_trace = false;
		Practice_tracing.user_score = 0;
		Practice_tracing.total_score = num_grid_map.get(category_type).length;		
		
    }
	
    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawPath(path, paint);		
		int count = 0;	
		for(int y = 0; y < getHeight(); y += (getHeight() / 10)){
			for(int x = 0; x < getWidth(); x += (getWidth() / 10)){				
				x_map.put(count, x);	
				y_map.put(count, y);
				count++;
				//canvas.drawText(Integer.toString(count), x, y, font);
			}
		}
				
		if(tracing_type == "voice"){
			Practice_tracing.list_pixel_x.add((double) eventX);
			Practice_tracing.list_pixel_y.add((double) eventY);
		}
		if(tracing_type == "practice"){
			for(int x = 0; x < wrong_grid_map.get(category_type).length; x++){
				if((eventX > x_map.get(wrong_grid_map.get(category_type)[x]) && 
					eventX < x_map.get(wrong_grid_map.get(category_type)[x]) + (getWidth() / 10)) && 
					(eventY > y_map.get(wrong_grid_map.get(category_type)[x]) && 
					eventY < y_map.get(wrong_grid_map.get(category_type)[x]) + (getHeight() / 10)))	{										
					if(!Practice_tracing.score_wrong.contains(num_grid_map.get(category_type)[x])){
						Practice_tracing.score_wrong.add(num_grid_map.get(category_type)[x]);
						Practice_tracing.user_score--;
					}					
				}	
			}	
			
			for(int x = 0; x < num_grid_map.get(category_type).length; x++){
				if((eventX + 30 > x_map.get(num_grid_map.get(category_type)[x]) && eventX < x_map.get(num_grid_map.get(category_type)[x]) + (getWidth() / 10)) && 
					(eventY + 30 > y_map.get(num_grid_map.get(category_type)[x]) && eventY < y_map.get(num_grid_map.get(category_type)[x]) + (getHeight() / 10)))		{					
						if(!Practice_tracing.score_arr.contains(num_grid_map.get(category_type)[x])){
							Practice_tracing.score_arr.add(num_grid_map.get(category_type)[x]);
							Practice_tracing.user_score++;
						}
					}	
			}	
		}
    }
	
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        eventX = event.getX();
        eventY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                // nothing to do
                break;
            default:
                return false;
        }

        // Schedules a repaint.
        invalidate();
        return true;
    }



}
