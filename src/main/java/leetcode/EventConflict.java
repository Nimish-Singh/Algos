package leetcode;

// https://leetcode.com/problems/determine-if-two-events-have-conflict/
public class EventConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        EventTime e1StartTime = new EventTime(event1[0]);
        EventTime e1EndTime = new EventTime(event1[1]);

        EventTime e2StartTime = new EventTime(event2[0]);
        EventTime e2EndTime = new EventTime(event2[1]);

        boolean isConflictFree = (e2StartTime.isBefore(e1StartTime) && e2EndTime.isBefore(e1StartTime)) ||
                (e1StartTime.isBefore(e2StartTime) && e1EndTime.isBefore(e2StartTime));
        return !isConflictFree;
    }
}

class EventTime {
    int hour, minute;

    public EventTime(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        this.hour = hour;
        this.minute = minute;
    }

    public boolean isBefore(EventTime other) {
        if (this.hour < other.hour)
            return true;

        return this.hour == other.hour && this.minute < other.minute;
    }
}
