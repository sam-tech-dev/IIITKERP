package timeTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


public class TimeTableGenerator {
	public static void main(String[] args) {
		int working_days=3;
		int slots=4;
		int professor_count=2;
		int batch_count=2;
		Lecture professor_timetable[][][]=new Lecture[professor_count][working_days][slots];
		Lecture student_timetable[][][]=new Lecture[batch_count][working_days][slots];
		ArrayList<Lecture> allocation=new ArrayList<Lecture>();
		Slot slot_generator[][]=new Slot[working_days][slots];
		for(int day=0;day<working_days;day++)
			for(int slot=0;slot<slots;slot++)
				slot_generator[day][slot]=new Slot(day, slot);
		
		Lecture lecture1=new Lecture("Joey","A","X",3);
		Lecture lecture2=new Lecture("Megha","A","Y",3);
		Lecture lecture3=new Lecture("Joey","B","X",3);
		Lecture lecture4=new Lecture("Megha","B","X",3);
		Lecture lecture5=new Lecture("Megha","B","Y",1);
		Lecture lecture6=new Lecture("Joey","A","",1);
		Lecture lecture7=new Lecture("Joey","B","",1);
		Lecture lecture8=new Lecture("Joey","B","",1);
		Lecture lecture9=new Lecture("Megha","A","",1);
		Lecture lecture10=new Lecture("Megha","A","",1);
		Lecture lecture11=new Lecture("Joey","B","",1);
		Lecture lecture12=new Lecture("Megha","B","",1);
		Lecture lecture13=new Lecture("Megha","B","",1);
				
		allocation.add(lecture1);
		allocation.add(lecture2);
		allocation.add(lecture3);
		allocation.add(lecture4);
//		allocation.add(lecture5);
//		allocation.add(lecture6);
//		allocation.add(lecture7);
//		allocation.add(lecture8);
//		allocation.add(lecture9);
//		allocation.add(lecture10);
//		allocation.add(lecture11);
//		allocation.add(lecture12);
//		allocation.add(lecture13);
		
		Collections.sort(allocation,new Comparator<Lecture>(){

			public int compare(Lecture arg0 ,Lecture arg1) {
				// TODO Auto-generated method stub
				if(arg0.duration>arg1.duration)
				return -1;
				else return 0;
			}});
		Iterator <Lecture>lectureIterator=allocation.iterator();
		while(lectureIterator.hasNext()){
			Lecture current=lectureIterator.next();
			
		}
		lectureIterator=allocation.iterator();
		boolean available=false;
		while(lectureIterator.hasNext()){
			available=false;
			Lecture current=lectureIterator.next();
		//	System.out.println(current.professor+current.batch+current.room+current.duration);
			
			int day=0,index = 0;
			for( day=0;day<working_days;day++)
			{
				int available_slots=0;
			 for(index=0;index<=slots-current.duration+1;index++)
			{ 
			
			  		if(!slot_generator[day][index].unavailable_batches.contains(current.batch)
			  			&& !slot_generator[day][index].unavailable_rooms.contains(current.room)
			  			&& !slot_generator[day][index].unavailable_professors.contains(current.professor))
			  			{available_slots++;
			  			//System.out.println("avail"+available_slots+day+"#"+index);
			  			}
			  		
			  		
			  		if(available_slots==current.duration){available=true;break;}
			  		
			  	
			  
			  	if(available==true)break;
			}
			 if(available==true)break;
			}
			if(available==true){
				current.day=day;
				
			//	System.out.println(day+"#"+index);
			for(int length=0;length<current.duration-1;length++)	
			{
				slot_generator[day][index-length].unavailable_batches.add(current.batch);
				slot_generator[day][index-length].unavailable_professors.add(current.professor);
				slot_generator[day][index-length].unavailable_rooms.add(current.room);
			}
			current.slot_number=index-current.duration+1;
				System.out.println(current.professor+"#"+current.batch+"#"+current.duration+"#"+current.day+"#"+current.slot_number);
				}
			else{System.out.println("Could Not Allocate");}
			
			
		}
			}
			
}


