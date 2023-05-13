import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mutations")
public class Mutations {
	List<mutation> mutationList;

	public Mutations(){}

	public Mutations(List<mutation> mutationList) {
		this.mutationList = mutationList;

	}
	@XmlElement(name = "mutation")
	public List<mutation> getMutationList() {
		return mutationList;
	}

	public void setMutationList(List<mutation> mutationList) {
		this.mutationList = mutationList;
	}

}