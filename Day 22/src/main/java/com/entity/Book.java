package com.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="generalbooks")

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookid")
	private long bookId;
	
	@Column(name="commonname", nullable = false)
	private String commonName;
	
	@Column(name="description", length=50000, nullable = false)
    private String description;
	
	@Column(name="bookauthor", nullable = false)
    private String bookAuthor;
	
	@Column(name="booktype", nullable = false)
    private String bookType;
	
	@Column(name="growing", length=50000, nullable = false)
    private String growingConditions;
	
	@Column(name="maintenance", length=50000, nullable = false)
    private String maintenance;
	
	@Column(name="available", nullable = false)
    private String bookAvailable;
	
	
	@Column(name="varieties", length=5000, nullable = false)
    private List<String> varieties;
	
	@Column(name="rating", nullable = false)
    private double averageRating;
	
	@Column(name="source", nullable = false)
    private String sourceCompany;
	
	@Column(name="bookimage", nullable = false)
    private String bookImage;
}
