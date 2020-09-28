package org.example.impl;

import org.example.Log;

/**
 * @author whx
 */
public class LogImpl implements Log {
    @Override
    public void log(String info) {
        System.out.println("LogImpl:" + info);
    }
}
