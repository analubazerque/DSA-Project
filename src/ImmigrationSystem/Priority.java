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

}
