package com.cg.demo.dao;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String msg){
        super(msg);
    }

    public PostNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}
