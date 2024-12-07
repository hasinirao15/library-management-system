package com.cvr;

import java.io.Serializable;

public class BookDetails implements Serializable {

    private  String id;
    private  String name;
    private String author;
    private String copies;
    
    public BookDetails() {
    }
    public BookDetails(String id,String name,String author) {
    	this.id=id;
    	this.name=name;
    	this.author=author;
    }
    public BookDetails(String id,String name,String author,String copies) {
    	this.id=id;
    	this.name=name;
    	this.author=author;
    	this.copies=copies;
    }
    public BookDetails(String id) {
    	this.id=id;
    }
    
	public  String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public  String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getauthor() {
		return author;
	}
	public void setauthor(String author) {
		this.author = author;
	}
	public String getcopies() {
		return copies;
	}
	public void setcopies(String copies) {
		this.copies = copies;
	}
	
}
