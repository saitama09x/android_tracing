package com.android.tracing;


public class Grid_algorithm{


	int[] right_big_a = {15, 92, 16, 89, 56};
	int[] wrong_big_a = {11, 41, 20, 30, 86};
	int[] right_big_b = {13, 53, 98, 28, 78};
	int[] wrong_big_b = {31, 71, 36, 76, 60};
	int[] right_big_c = {15, 53, 38, 96, 79};
	int[] wrong_big_c = {11, 56, 66};
	int[] right_big_d = {38, 28, 17, 16, 15};
	int[] wrong_big_d = {41, 71, 46, 66, 20};
	int[] right_big_e = {13, 15, 18, 19, 23};
	int[] wrong_big_e = {31, 81, 36, 76, 50};
	int[] right_big_f = {14, 16, 18, 20, 23};
	int[] wrong_big_f = {31, 71, 37, 76, 86};
	int[] right_big_g = {16, 17, 25, 34, 43};
	int[] wrong_big_g = {11, 31, 46, 60, 50};
	int[] right_big_h = {12, 22, 32, 42, 52};
	int[] wrong_big_h = {15, 16, 75, 85, 37};
	int[] right_big_i = {12, 14, 16, 18, 20};
	int[] wrong_big_i = {32, 62, 38, 68, 60};
	int[] right_big_j = {14, 17, 18, 19, 26};
	int[] wrong_big_j = {32, 43, 54, 50, 80};
	int[] right_big_k = {12, 22, 32, 42, 52};
	int[] wrong_big_k = {48, 68, 50, 70, 80};
	int[] right_big_l = {13, 23, 33, 43, 63};
	int[] wrong_big_l = {37, 47, 57, 40, 60};
	int[] right_big_m = {15, 17, 65, 67, 75};
	int[] wrong_big_m = {75, 76, 85, 86, 16};
	int[] right_big_n = {12, 22, 32, 42, 52};
	int[] wrong_big_n = {16, 85, 96};
	int[] right_big_o = {24, 62, 95, 59, 29};
	int[] wrong_big_o = {46, 56, 66};
	int[] right_big_p = {13, 53, 88, 65, 49};
	int[] wrong_big_p = {36, 77, 78, 97, 99};
	int[] right_big_q = {33, 24, 16, 29, 39};
	int[] wrong_big_q = {36, 46};
	int[] right_big_r = {33, 24, 16, 29, 39};
	int[] wrong_big_r = {35, 68, 69, 60, 70};
	int[] right_big_s = {16, 33, 56, 88, 83};
	int[] wrong_big_s = {11, 41, 50, 75};
	int[] right_big_t = {12, 17, 35, 55, 85};
	int[] wrong_big_t = {42, 62, 72, 59, 69};
	int[] right_big_u = {13, 52, 94, 49, 19};
	int[] wrong_big_u = {26, 36, 46};
	int[] right_big_v = {12, 53, 85, 48, 29};
	int[] wrong_big_v = {15, 16, 81, 91, 90};
	int[] right_big_w = {12, 62, 35, 77, 39};
	int[] wrong_big_w = {71, 81, 91, 80, 90};
	int[] right_big_x = {33, 24, 16, 29, 39};
	int[] wrong_big_x = {42, 52, 96, 60, 70};
	int[] right_big_y = {23, 44, 65, 75, 29};
	int[] wrong_big_y = {51, 71, 70, 80};
	int[] right_big_z = {25, 55, 83, 95, 99};
	int[] wrong_big_z = {21, 31, 60, 70, 80};

	int[] right_small_a = {15, 92, 16, 89, 56};
	int[] wrong_small_a = {0};
	int[] right_small_b = {13, 53, 98, 28, 78};
	int[] wrong_small_b = {0};
	int[] right_small_c = {15, 53, 38, 96, 79};
	int[] wrong_small_c = {0};
	int[] right_small_d = {38, 28, 17, 16, 15};
	int[] wrong_small_d = {0};
	int[] right_small_e = {13, 15, 18, 19, 23};
	int[] wrong_small_e = {0};
	int[] right_small_f = {14, 16, 18, 20, 23};
	int[] wrong_small_f = {0};
	int[] right_small_g = {16, 17, 25, 34, 43};
	int[] wrong_small_g = {0};
	int[] right_small_h = {12, 22, 32, 42, 52};
	int[] wrong_small_h = {0};
	int[] right_small_i = {12, 14, 16, 18, 20};
	int[] wrong_small_i = {0};
	int[] right_small_j = {14, 17, 18, 19, 26};
	int[] wrong_small_j = {0};
	int[] right_small_k = {12, 22, 32, 42, 52};
	int[] wrong_small_k = {0};
	int[] right_small_l = {13, 23, 33, 43, 63};
	int[] wrong_small_l = {0};
	int[] right_small_m = {15, 17, 65, 67, 75};
	int[] wrong_small_m = {0};
	int[] right_small_n = {12, 22, 32, 42, 52};
	int[] wrong_small_n = {0};
	int[] right_small_o = {24, 62, 95, 59, 29};
	int[] wrong_small_o = {0};
	int[] right_small_p = {13, 53, 88, 65, 49};
	int[] wrong_small_p = {0};
	int[] right_small_q = {33, 24, 16, 29, 39};
	int[] wrong_small_q = {0};
	int[] right_small_r = {33, 24, 16, 29, 39};
	int[] wrong_small_r = {0};
	int[] right_small_s = {16, 33, 56, 88, 83};
	int[] wrong_small_s = {0};
	int[] right_small_t = {12, 17, 35, 55, 85};
	int[] wrong_small_t = {0};
	int[] right_small_u = {13, 52, 94, 49, 19};
	int[] wrong_small_u = {0};
	int[] right_small_v = {12, 53, 85, 48, 29};
	int[] wrong_small_v = {0};
	int[] right_small_w = {12, 62, 35, 77, 39};
	int[] wrong_small_w = {0};
	int[] right_small_x = {33, 24, 16, 29, 39};
	int[] wrong_small_x = {0};
	int[] right_small_y = {23, 44, 65, 75, 29};
	int[] wrong_small_y = {0};
	int[] right_small_z = {25, 55, 83, 95, 99};
	int[] wrong_small_z = {0};


	int[] right_circle = {26, 52, 96, 60, 39};
	int[] wrong_circle = {36, 46, 56, 66, 76};

	int[] right_diamond = {25, 52, 96, 59, 38};
	int[] wrong_diamond = {36, 46, 56, 66, 76};

	int[] right_rectangle = {16, 12, 92, 98, 60};
	int[] wrong_rectangle = {44, 56, 68, 74, 76};

	int[] right_star = {35, 54, 58, 78, 86};
	int[] wrong_star = {11, 71, 22, 80, 90};

	int[] right_triangle = {26, 54, 83, 48, 79};
	int[] wrong_triangle = {66, 11, 31, 51, 20};

	int[] right_square = {15, 52, 96, 70, 20};
	int[] wrong_square = {45, 46, 56, 66, 76};

	int[] right_num_0 = {16, 52, 96, 59, 18};
	int[] wrong_num_0 = {11};
	int[] right_num_1 = {23, 35, 56, 96, 99};
	int[] wrong_num_1 = {11};
	int[] right_num_2 = {22, 16, 56, 82, 97};
	int[] wrong_num_2 = {11};
	int[] right_num_3 = {23, 39, 55, 79, 93};
	int[] wrong_num_3 = {11};
	int[] right_num_4 = {17, 45, 75, 38, 98};
	int[] wrong_num_4 = {11};
	int[] right_num_5 = {15, 33, 57, 87, 93};
	int[] wrong_num_5 = {11};
	int[] right_num_6 = {25, 63, 96, 79, 56};
	int[] wrong_num_6 = {11};
	int[] right_num_7 = {12, 17, 46, 65, 94};
	int[] wrong_num_7 = {11};
	int[] right_num_8 = {16, 55, 94, 79, 39};
	int[] wrong_num_8 = {11};
	int[] right_num_9 = {16, 65, 59, 39, 94};
	int[] wrong_num_9 = {11};	

	public int[] get_a(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_a;	
			}
			return wrong_big_a;
		}else{
			if(right){
				return right_small_a;	
			}
			return wrong_small_a;
		}
		
	}
	public int[] get_b(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_b;	
			}
			return wrong_big_b;
		}else{
			if(right){
				return right_small_b;	
			}
			return wrong_small_b;
		}
	}
	public int[] get_c(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_c;	
			}
			return wrong_big_c;
		}else{
			if(right){
				return right_small_c;	
			}
			return wrong_small_c;
		}
	}

	public int[] get_d(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_d;	
			}
			return wrong_big_d;
		}else{
			if(right){
				return right_small_d;	
			}
			return wrong_small_d;
		}
	}

	public int[] get_e(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_e;	
			}
			return wrong_big_e;
		}else{
			if(right){
				return right_small_e;	
			}
			return wrong_small_e;
		}
	}

	public int[] get_f(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_f;	
			}
			return wrong_big_f;
		}else{
			if(right){
				return right_small_f;	
			}
			return wrong_small_f;
		}
	}

	public int[] get_g(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_g;	
			}
			return wrong_big_g;
		}else{
			if(right){
				return right_small_g;	
			}
			return wrong_small_g;
		}
	}

	public int[] get_h(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_h;	
			}
			return wrong_big_h;
		}else{
			if(right){
				return right_small_h;	
			}
			return wrong_small_h;
		}
	}

	public int[] get_i(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_i;	
			}
			return wrong_big_i;
		}else{
			if(right){
				return right_small_i;	
			}
			return wrong_small_i;
		}
	}

	public int[] get_j(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_j;	
			}
			return wrong_big_j;
		}else{
			if(right){
				return right_small_j;	
			}
			return wrong_small_j;
		}
	}

	public int[] get_k(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_k;	
			}
			return wrong_big_k;
		}else{
			if(right){
				return right_small_k;	
			}
			return wrong_small_k;
		}
	}

	public int[] get_l(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_l;	
			}
			return wrong_big_l;
		}else{
			if(right){
				return right_small_l;	
			}
			return wrong_small_l;
		}
	}

	public int[] get_m(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_small_m;	
			}
			return wrong_small_m;
		}else{
			if(right){
				return right_small_m;	
			}
			return wrong_small_m;
		}
	}

	public int[] get_n(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_small_n;	
			}
			return wrong_small_n;
		}else{
			if(right){
				return right_small_n;	
			}
			return wrong_small_n;
		}
	}

	public int[] get_o(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_o;	
			}
			return wrong_big_o;
		}else{
			if(right){
				return right_small_o;	
			}
			return wrong_small_o;
		}
	}

	public int[] get_p(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_p;	
			}
			return wrong_big_p;
		}else{
			if(right){
				return right_small_p;	
			}
			return wrong_small_p;
		}
	}

	public int[] get_q(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_q;	
			}
			return wrong_big_q;
		}else{
			if(right){
				return right_small_q;	
			}
			return wrong_small_q;
		}	}

	public int[] get_r(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_r;	
			}
			return wrong_big_r;
		}else{
			if(right){
				return right_small_r;	
			}
			return wrong_small_r;
		}
	}


	public int[] get_s(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_s;	
			}
			return wrong_big_s;
		}else{
			if(right){
				return right_small_s;	
			}
			return wrong_small_s;
		}
	}

	public int[] get_t(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_t;	
			}
			return wrong_big_t;
		}else{
			if(right){
				return right_small_t;	
			}
			return wrong_small_t;
		}
	}

	public int[] get_u(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_u;	
			}
			return wrong_big_u;
		}else{
			if(right){
				return right_small_u;	
			}
			return wrong_small_u;
		}
	}

	public int[] get_v(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_v;	
			}
			return wrong_big_v;
		}else{
			if(right){
				return right_small_v;	
			}
			return wrong_small_v;
		}
	}

	public int[] get_w(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_w;	
			}
			return wrong_big_w;
		}else{
			if(right){
				return right_small_w;	
			}
			return wrong_small_w;
		}
	}

	public int[] get_x(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_x;	
			}
			return wrong_big_x;
		}else{
			if(right){
				return right_small_x;	
			}
			return wrong_small_x;
		}
	}

	public int[] get_y(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_y;	
			}
			return wrong_big_y;
		}else{
			if(right){
				return right_small_y;	
			}
			return wrong_small_y;
		}
	}

	public int[] get_z(String type, boolean right){
		if(type == "big"){
			if(right){
				return right_big_z;	
			}
			return wrong_big_z;
		}else{
			if(right){
				return right_small_z;	
			}
			return wrong_small_z;
		}
	}

	public int[] get_circle(boolean right){
		if(right){
			return right_circle;
		}

		return wrong_circle;
	}

	public int[] get_square(boolean right){
		if(right){
			return right_square;
		}

		return wrong_square;
	}

	public int[] get_diamond(boolean right){
		if(right){
			return right_diamond;
		}

		return wrong_diamond;
	}

	public int[] get_rectangle(boolean right){
		if(right){
			return right_rectangle;
		}

		return wrong_rectangle;
	}

	public int[] get_star(boolean right){
		if(right){
			return right_star;
		}

		return wrong_star;
	}

	public int[] get_triangle(boolean right){
		if(right){
			return right_triangle;
		}

		return wrong_triangle;
	}

	public int[] get_num_0(boolean right){
		if(right){
			return right_num_0;
		}

		return wrong_num_0;
	}

	public int[] get_num_1(boolean right){
		if(right){
			return right_num_1;
		}

		return wrong_num_1;
	}

	public int[] get_num_2(boolean right){
		if(right){
			return right_num_2;
		}

		return wrong_num_2;
	}

	public int[] get_num_3(boolean right){
		if(right){
			return right_num_3;
		}

		return wrong_num_3;
	}

	public int[] get_num_4(boolean right){
		if(right){
			return right_num_4;
		}

		return wrong_num_4;
	}

	public int[] get_num_5(boolean right){
		if(right){
			return right_num_5;
		}

		return wrong_num_5;
	}

	public int[] get_num_6(boolean right){
		if(right){
			return right_num_6;
		}

		return wrong_num_6;
	}

	public int[] get_num_7(boolean right){
		if(right){
			return right_num_7;
		}

		return wrong_num_7;
	}

	public int[] get_num_8(boolean right){
		if(right){
			return right_num_8;
		}

		return wrong_num_8;
	}

	public int[] get_num_9(boolean right){
		if(right){
			return right_num_9;
		}

		return wrong_num_9;
	}
}