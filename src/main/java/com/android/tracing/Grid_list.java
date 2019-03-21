package com.android.tracing;

import java.util.*;
import java.util.ArrayList;


public class Grid_list{


	private Grid_algorithm grid = new Grid_algorithm();

	public int[] get_rightgrid(String name){
		HashMap<String, int[]> map = new HashMap<String, int[]>();
		map.put("big_a", grid.get_a("big", true));
		map.put("big_b", grid.get_b("big", true));
		map.put("big_c", grid.get_c("big", true));
		map.put("big_d", grid.get_d("big", true));
		map.put("big_e", grid.get_e("big", true));
		map.put("big_f", grid.get_f("big", true));
		map.put("big_g", grid.get_g("big", true));
		map.put("big_h", grid.get_h("big", true));
		map.put("big_i", grid.get_i("big", true));
		map.put("big_j", grid.get_j("big", true));
		map.put("big_k", grid.get_k("big", true));
		map.put("big_l", grid.get_l("big", true));
		map.put("big_m", grid.get_m("big", true));
		map.put("big_n", grid.get_n("big", true));
		map.put("big_o", grid.get_o("big", true));
		map.put("big_p", grid.get_p("big", true));
		map.put("big_q", grid.get_q("big", true));	
		map.put("big_r", grid.get_r("big", true));	
		map.put("big_s", grid.get_s("big", true));	
		map.put("big_t", grid.get_t("big", true));	
		map.put("big_u", grid.get_u("big", true));	
		map.put("big_v", grid.get_v("big", true));	
		map.put("big_w", grid.get_w("big", true));	
		map.put("big_x", grid.get_x("big", true));	
		map.put("big_y", grid.get_y("big", true));	
		map.put("big_z", grid.get_z("big", true));	

		map.put("small_a", grid.get_a("small", true));
		map.put("small_b", grid.get_b("small", true));
		map.put("small_c", grid.get_c("small", true));
		map.put("small_d", grid.get_d("small", true));
		map.put("small_e", grid.get_e("small", true));
		map.put("small_f", grid.get_f("small", true));
		map.put("small_g", grid.get_g("small", true));
		map.put("small_h", grid.get_h("small", true));
		map.put("small_i", grid.get_i("small", true));
		map.put("small_j", grid.get_j("small", true));
		map.put("small_k", grid.get_k("small", true));
		map.put("small_l", grid.get_l("small", true));
		map.put("small_m", grid.get_m("small", true));
		map.put("small_n", grid.get_n("small", true));
		map.put("small_o", grid.get_o("small", true));
		map.put("small_p", grid.get_p("small", true));
		map.put("small_q", grid.get_q("small", true));
		map.put("small_r", grid.get_r("small", true));
		map.put("small_s", grid.get_s("small", true));
		map.put("small_t", grid.get_t("small", true));
		map.put("small_u", grid.get_u("small", true));
		map.put("small_v", grid.get_v("small", true));
		map.put("small_w", grid.get_w("small", true));
		map.put("small_x", grid.get_x("small", true));
		map.put("small_y", grid.get_y("small", true));
		map.put("small_z", grid.get_z("small", true));

		map.put("circle", grid.get_circle(true));
		map.put("diamond", grid.get_diamond(true));
		map.put("rectangle", grid.get_rectangle(true));
		map.put("star", grid.get_star(true));
		map.put("triangle", grid.get_triangle(true));
		map.put("square", grid.get_square(true));

		map.put("number_0", grid.get_num_0(true));
		map.put("number_1", grid.get_num_1(true));
		map.put("number_2", grid.get_num_2(true));
		map.put("number_3", grid.get_num_3(true));		
		map.put("number_4", grid.get_num_4(true));
		map.put("number_5", grid.get_num_5(true));
		map.put("number_6", grid.get_num_6(true));
		map.put("number_7", grid.get_num_7(true));
		map.put("number_8", grid.get_num_8(true));
		map.put("number_9", grid.get_num_9(true));

		return map.get(name);
	}

	public int[] get_wronggrid(String name){
		HashMap<String, int[]> map = new HashMap<String, int[]>();
		map.put("big_a", grid.get_a("big", false));
		map.put("big_b", grid.get_b("big", false));
		map.put("big_c", grid.get_c("big", false));
		map.put("big_d", grid.get_d("big", false));
		map.put("big_e", grid.get_e("big", false));
		map.put("big_f", grid.get_f("big", false));
		map.put("big_g", grid.get_g("big", false));
		map.put("big_h", grid.get_h("big", false));
		map.put("big_i", grid.get_i("big", false));
		map.put("big_j", grid.get_j("big", false));
		map.put("big_k", grid.get_k("big", false));
		map.put("big_l", grid.get_l("big", false));
		map.put("big_m", grid.get_m("big", false));
		map.put("big_n", grid.get_n("big", false));
		map.put("big_o", grid.get_o("big", false));
		map.put("big_p", grid.get_p("big", false));
		map.put("big_q", grid.get_q("big", false));	
		map.put("big_r", grid.get_r("big", false));	
		map.put("big_s", grid.get_s("big", false));	
		map.put("big_t", grid.get_t("big", false));	
		map.put("big_u", grid.get_u("big", false));	
		map.put("big_v", grid.get_v("big", false));	
		map.put("big_w", grid.get_w("big", false));	
		map.put("big_x", grid.get_x("big", false));	
		map.put("big_y", grid.get_y("big", false));	
		map.put("big_z", grid.get_z("big", false));	

		map.put("small_a", grid.get_a("small", false));
		map.put("small_b", grid.get_b("small", false));
		map.put("small_c", grid.get_c("small", false));
		map.put("small_d", grid.get_d("small", false));
		map.put("small_e", grid.get_e("small", false));
		map.put("small_f", grid.get_f("small", false));
		map.put("small_g", grid.get_g("small", false));
		map.put("small_h", grid.get_h("small", false));
		map.put("small_i", grid.get_i("small", false));
		map.put("small_j", grid.get_j("small", false));
		map.put("small_k", grid.get_k("small", false));
		map.put("small_l", grid.get_l("small", false));
		map.put("small_m", grid.get_m("small", false));
		map.put("small_n", grid.get_n("small", false));
		map.put("small_o", grid.get_o("small", false));
		map.put("small_p", grid.get_p("small", false));
		map.put("small_q", grid.get_q("small", false));
		map.put("small_r", grid.get_r("small", false));
		map.put("small_s", grid.get_s("small", false));
		map.put("small_t", grid.get_t("small", false));
		map.put("small_u", grid.get_u("small", false));
		map.put("small_v", grid.get_v("small", false));
		map.put("small_w", grid.get_w("small", false));
		map.put("small_x", grid.get_x("small", false));
		map.put("small_y", grid.get_y("small", false));
		map.put("small_z", grid.get_z("small", false));

		map.put("circle", grid.get_circle(false));
		map.put("diamond", grid.get_diamond(false));
		map.put("rectangle", grid.get_rectangle(false));
		map.put("star", grid.get_star(false));
		map.put("triangle", grid.get_triangle(false));
		map.put("square", grid.get_square(false));

		map.put("number_0", grid.get_num_0(false));
		map.put("number_1", grid.get_num_1(false));
		map.put("number_2", grid.get_num_2(false));
		map.put("number_3", grid.get_num_3(false));			
		map.put("number_4", grid.get_num_4(false));
		map.put("number_5", grid.get_num_5(false));
		map.put("number_6", grid.get_num_6(false));
		map.put("number_7", grid.get_num_7(false));
		map.put("number_8", grid.get_num_8(false));
		map.put("number_9", grid.get_num_9(false));

		return map.get(name);
	}

}