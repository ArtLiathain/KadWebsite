import javax.xml.bind.annotation.XmlAttribute;

public class mutation {
	private String detected;
	private String numberOfTestsRun;
	private String status;
	private String sourceFile;
    private String mutatedClass;
    private String mutatedMethod;
    private String methodDescription;
    private String lineNumber;
    private String mutator;
    private String indexes;
    private String blocks;
	private String description;
	public mutation(){}
	public mutation(String detected, String numberOfTestsRun, String status,
	                String sourceFile, String mutatedClass, String mutatedMethod,
	                String methodDescription, String lineNumber, String mutator,
	                String indexes, String blocks, String description) {
		super();
		this.detected = detected;
		this.numberOfTestsRun = numberOfTestsRun;
		this.status = status;
		this.sourceFile = sourceFile;
		this.mutatedClass = mutatedClass;
		this.mutatedMethod = mutatedMethod;
		this.methodDescription = methodDescription;
		this.lineNumber = lineNumber;
		this.mutator = mutator;
		this.indexes = indexes;
		this.blocks = blocks;
		this.description = description;
	}
	@XmlAttribute
	public String getDetected() {
		return detected;
	}

	public void setDetected(String detected) {
		this.detected = detected;
	}


}