package lemon.engine.logger;

import lemon.engine.event.Event;

public interface LoggerEvent extends Event {
	public LoggerItem getLoggerItem();
}
