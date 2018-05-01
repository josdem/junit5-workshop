package com.jos.dem.junit;

public class Person {

  private String nickname;
  private String email;

  public Person(){}

  public Person(String nickname, String email){
    this.nickname = nickname;
    this.email = email;
  }

  public String getNickname(){
    return this.nickname;
  }

  public String getEmail(){
    return this.email;
  }

}