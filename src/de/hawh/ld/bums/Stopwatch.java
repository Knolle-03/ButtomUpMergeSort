package de.hawh.ld.bums;

public class Stopwatch {

    private long start = 0;

    public Stopwatch(){
        start = System.currentTimeMillis();
    }

    // Vergangene Zeit in Millisekunden
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return now - start;
    }

}
