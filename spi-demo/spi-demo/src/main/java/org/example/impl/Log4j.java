package org.example.impl;

import org.example.Log;

/**
 * @author whx
 */
public class Log4j implements Log {
    @Override
    public void log(String info) {
        System.out.println("Log4j:" + info);
    }
}
