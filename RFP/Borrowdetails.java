package com.cvr;

import java.io.Serializable;

public class Borrowdetails implements Serializable {

    private  String userid;
    private  String bookid;
    private  int borrowid;
    
    public Borrowdetails() {
    }
   
	public  String getuid() {
		return userid;
	}
	public void setuid(String userid) {
		this.userid = userid;
	}
	public  String getbid() {
		return bookid;
	}
	public void setbid(String bookid) {
		this.bookid = bookid;
	}
	
}
