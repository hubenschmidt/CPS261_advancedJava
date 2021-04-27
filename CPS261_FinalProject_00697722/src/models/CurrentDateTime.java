package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Utility class to format date and time
 */
public class CurrentDateTime {
    private DateTimeFormatter dtf;
    private LocalDateTime now;

    public CurrentDateTime() {
	this.dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	this.now = LocalDateTime.now();
    }

    @Override
    public String toString() {
	return dtf.format(now);
    }

}
