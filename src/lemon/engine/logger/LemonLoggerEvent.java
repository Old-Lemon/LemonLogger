package lemon.engine.logger;

public class LemonLoggerEvent implements LoggerEvent {
	private LoggerItem item;
	public LemonLoggerEvent(LoggerItem item){
		this.item = item;
	}
	@Override
	public LoggerItem getLoggerItem() {
		return item;
	}
}
