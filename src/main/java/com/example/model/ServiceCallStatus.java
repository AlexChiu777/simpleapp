package com.example.model;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by alex on 1/4/2018.
 */
public enum ServiceCallStatus {
    ACCEPTED, OPEN, COMPLETE, INCOMPLETE;

    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Stream.of(ServiceCallStatus.values()).map(ServiceCallStatus::name).toArray(String[]::new);
    }
}
