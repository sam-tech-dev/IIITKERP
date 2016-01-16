package timeTable;

import java.util.ArrayList;


public class Slot {
	ArrayList<String> unavailable_batches;
	ArrayList<String> unavailable_rooms;
	ArrayList<String> unavailable_professors;
	int slot_number;
	int day;
	public Slot(int day,int slot_number) {
		unavailable_batches=new ArrayList<String>();
		unavailable_rooms=new ArrayList<String>();
		unavailable_professors=new ArrayList<String>();
		this.slot_number=slot_number;
		this.day=day;
		
	}


}
