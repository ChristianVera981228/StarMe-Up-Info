package com.nextgen.model;

public class Glober {

    private Integer sentStars;
    private Integer recievedStars;

public Glober(Integer sentStars, Integer recievedStars){
    this.sentStars = sentStars;
    this.recievedStars = recievedStars;
}

@Override
public String toString(){

    return sentStars.toString() + recievedStars.toString();
}


    
} 
