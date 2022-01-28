package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;

@Document(collection="todo")
public class ToDO {

    public String getDataID() {
        return DataID;
    }

    public void setDataID(String dataID) {
        DataID = dataID ;
    }

    //id of the user (every user have much of data )
    //we will add the the @annotation one to many
    @Id
    public String DataID ;


    public String userID ;
    public  String firstName;

    public String lastName ;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserID() {
        return userID;
    }

    public void setId(String id) {
        this.userID = id;
    }

    public ToDO(String dataID,String userID, String firstName, String lastName) {
        this.DataID = dataID;
        this.firstName = firstName;
        this.userID = userID;
        this.lastName = lastName;
    }


}
