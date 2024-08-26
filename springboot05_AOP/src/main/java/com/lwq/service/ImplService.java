package com.lwq.service;

import org.springframework.stereotype.Service;

import com.lwq.myInterface.FuncInterface;

@Service
public class ImplService implements FuncInterface {

    @Override
    public void sayhehe() {
        System.out.println("hehhehe");
    }

    @Override
    public void sayHAHA() {
        System.out.println("hahhah");
    }

}
