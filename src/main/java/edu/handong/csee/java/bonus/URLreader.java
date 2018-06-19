package edu.handong.csee.java.bonus;

import java.net.*;

import java.io.*;

public class URLreader {
	
    public BufferedReader readURL(String url) throws Exception {
        URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        return in;
    }
}