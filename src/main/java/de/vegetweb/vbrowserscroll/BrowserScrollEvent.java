package de.vegetweb.vbrowserscroll;

import de.vegetweb.vbrowserscroll.BrowserScrollEvent.Event;

public class BrowserScrollEvent {
    public static enum Event {
        TOP, NOT_TOP
    }

    public static BrowserScrollEvent notTop(int pos) {
        return new BrowserScrollEvent(Event.NOT_TOP, pos);
    }

    public static BrowserScrollEvent top(int pos) {
        return new BrowserScrollEvent(Event.TOP, pos);
    }

    private final BrowserScrollEvent.Event type;

    private final int pos;

    public BrowserScrollEvent(BrowserScrollEvent.Event type, int pos) {
        super();
        this.type = type;
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    public BrowserScrollEvent.Event getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BrowserScrollEvent [type=");
        builder.append(type);
        builder.append(", pos=");
        builder.append(pos);
        builder.append("]");
        return builder.toString();
    }

}