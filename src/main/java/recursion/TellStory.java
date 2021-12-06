package recursion;

public class TellStory {

	public static void main(String[] args) {
		new TellStory().老和尚给小和尚讲故事();
	}

	public void 老和尚给小和尚讲故事() {
		从前有座山();
		山上有座庙();
		庙里有个老和尚和小和尚();
		老和尚给小和尚讲故事();
	}

	private void 山上有座庙() {
	}

	private void 从前有座山() {
	}

	private void 庙里有个老和尚和小和尚() {
	}


}
