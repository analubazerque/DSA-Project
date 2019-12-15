package ImmigrationSystem;

public enum Priority {
	
	HIGH("HIGH"),
	MEDIUM("MEDIUM"),
	LOW("LOW");

	private String level;

	public String getLevel() {
		return this.level;
	}

	Priority(String level) {
		this.level = level;
	}

//	public String getLevel(String level) {
//		this.level = level;
//		return level;
//	}
//
//	public Priority getLevel(String priotity) {
//		this.level = priotity;
//		return level;
//	}

}
