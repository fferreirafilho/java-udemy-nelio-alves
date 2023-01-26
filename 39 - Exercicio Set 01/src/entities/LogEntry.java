package entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class LogEntry {
    private String username;
    private LocalDateTime moment;

    public LogEntry(String username, LocalDateTime moment) {
	this.username = username;
	this.moment = moment;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public LocalDateTime getMoment() {
	return moment;
    }

    public void setMoment(LocalDateTime moment) {
	this.moment = moment;
    }

    @Override
    public int hashCode() {
	return Objects.hash(username);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	LogEntry other = (LogEntry) obj;
	return Objects.equals(username, other.username);
    }

}
