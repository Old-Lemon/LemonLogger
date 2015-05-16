package lemon.engine.logger;

import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lemon.engine.event.EventManager;

public class Logger extends Writer {
	private static PrintWriter printWriter;
	private static Logger instance;
	private List<LoggerItem> items;
	private LoggerItem buffer;
	static{
		instance = new Logger();
		printWriter = new PrintWriter(instance, true);
	}
	public static PrintWriter getWriter(){
		return printWriter;
	}
	public static Logger getLogger(){
		return instance;
	}
	private Logger(){
		items = new ArrayList<LoggerItem>();
	}
	@Override
	public void close() throws IOException {
		buffer = null;
		items = Collections.unmodifiableList(items);
	}
	@Override
	public void flush() throws IOException {
		items.add(buffer);
		EventManager.callListeners(new LemonLoggerEvent(buffer));
		buffer = null;
	}
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		if(buffer==null){
			buffer = new LoggerItem(System.currentTimeMillis());
		}
		buffer.add(Arrays.copyOfRange(cbuf, off, off+len));
	}
	public List<LoggerItem> getLoggerItems(){
		return Collections.unmodifiableList(items);
	}
}
 