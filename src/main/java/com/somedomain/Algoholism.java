package com.somedomain;

import com.google.common.flogger.FluentLogger;

public class Algoholism {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static void main(String[] args) {
        logger.atFine().log("Welcome to Algoholism!");
    }
}
