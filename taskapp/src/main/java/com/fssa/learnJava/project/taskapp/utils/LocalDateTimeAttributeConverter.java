/**
 * 
 */
package com.fssa.learnJava.project.taskapp.utils;

/**
 * @author Vinit Gore
 *
 **/
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LocalDateTimeAttributeConverter {
    public static Timestamp convertToSQLTimestamp(LocalDateTime localDateTime) {
        return localDateTime != null ? Timestamp.valueOf(localDateTime) : null;
    }

    public static LocalDateTime convertToLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
