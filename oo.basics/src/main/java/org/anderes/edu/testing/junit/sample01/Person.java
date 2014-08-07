package org.anderes.edu.testing.junit.sample01;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Person {

	/** Der Name der Person */
	public String name = "";
	/** Geburtstag */
	private Date birthday = new Date();
	
	/**
	 * Konstruktor
	 * 
	 * @param name Name der Person
	 */
	public Person(String name) {
		this.name = name;
	}
	
	/**
	 * Setzt den Geburtstag.
	 * 
	 * @param Datum
	 */
	public void setBirthday(Date date) {
		birthday = date;
	}
	
	/**
	 * Gibt das Datum für den Geburtstag zurück.
	 * 
	 * @return Datum des Geburtstag
	 */
	public Date getBirthday() {
		return birthday;
	}
		
	/**
	 * Liefert {@code true}, wenn die Person im angegeben Monat Geburtstag hat.
	 * 
	 * @return {@code true},wenn die Person im angegeben Monat Geburtstag hat, sonst {@code false}
	 */
	public boolean hasBirthday(int month) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(birthday);
		return calendar.get(Calendar.MONTH) == month;
	}
}
