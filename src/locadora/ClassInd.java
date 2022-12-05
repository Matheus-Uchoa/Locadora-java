package locadora;

public enum ClassInd {
	LIVRE(1, "Livre"), ADULTO(2, "Adulto");

	private Integer id;
	private String label;

	ClassInd(Integer id, String label) {
		this.id = id;
		this.label = label;
	}

	public Integer getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public static ClassInd valueOf(Integer id) {

		for (ClassInd classInd : values()) {
			if (classInd.id.equals(id)) {
				return classInd;
			}
		}
		return null;

	}
}
