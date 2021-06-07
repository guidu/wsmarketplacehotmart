package br.com.wsmarketplacehotmart.enums;

public enum AssessProductEnum {

	ZERO(0, "zero"), UM(1, "um"), DOIS(2, "dois"), TRES(3, "tres"), QUATRO(4, "quatro"), CINCO(5, "cinco");

	private int identifier;
	private String description;

	AssessProductEnum(int identifier, String description) {
		this.identifier = identifier;
		this.description = description;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
