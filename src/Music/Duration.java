package Music;

public class Duration {
	private int seconds;
	private int minutes;
	private int totalLengthSeconds;
	
	public Duration(int minutes, int seconds) {
		this.minutes = minutes;
		this.seconds = seconds;
		this.totalLengthSeconds = (minutes * 60) + seconds;
	}

	public int getSeconds() {
		return this.seconds;
	}

	public int getMinutes() {
		return this.minutes;
	}

	public int getTotalLengthSeconds() {
		return this.totalLengthSeconds;
	}

	@Override
	public String toString() {
		if(this.seconds > 9) { 
			return this.minutes + ":" + this.seconds;
		} else {
			return this.minutes + ":0" + this.seconds;
		}
	}	
}
