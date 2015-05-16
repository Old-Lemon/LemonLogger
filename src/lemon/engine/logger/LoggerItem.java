package lemon.engine.logger;

import java.util.ArrayList;
import java.util.List;

public class LoggerItem {
	private long time;
	private List<char[]> characters;
	public LoggerItem(long time){
		this.time = time;
		characters = new ArrayList<char[]>();
	}
	public void add(char[] characters){
		this.characters.add(characters);
	}
	public long getTime(){
		return time;
	}
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for(char[] chars: characters){
			builder.append(chars);
		}
		return builder.toString();
	}
}
