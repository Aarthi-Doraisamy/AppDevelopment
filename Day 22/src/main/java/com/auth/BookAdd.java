package com.auth;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor 
public class BookAdd {
	
	private long BookId;
	private String commonName;
    private String description;
    private String BookAuthor;
    private String BookType;
    private String maintenance;
    private List<String> Genre;
    private List<String> collections;
    private double averageRating;
    private String ptice;
    private String bookImage;

}
