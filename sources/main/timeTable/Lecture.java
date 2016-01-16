package timeTable;


public class Lecture {
String professor;
String batch;
String room;
int day,slot_number,duration;
public Lecture(String professor, String batch, String room,int duration,int day,int slot_number) {
	this.professor = professor;
	this.batch = batch;
	this.room = room;
	this.day=day;
	this.slot_number=slot_number;
	this.duration=duration;
	
}

public Lecture(String professor, String batch, String room,int duration) {
	this.professor = professor;
	this.batch = batch;
	this.room = room;
	this.duration=duration;
	}




}
