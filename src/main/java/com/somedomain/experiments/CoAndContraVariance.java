package com.somedomain.experiments;

import java.util.ArrayList;
import java.util.List;

public class CoAndContraVariance {

    public static void main(String[] args) {

        List<? extends Number> myNums = new ArrayList<Long>();

        Long lo = (Long) myNums.get(0);
    }

}
