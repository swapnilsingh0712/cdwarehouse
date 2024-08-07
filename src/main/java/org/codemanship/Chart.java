package org.codemanship;

public interface Chart {
     void notify(String artist,String title, int quantity);


     int getPosition(String artist, String title);
}
