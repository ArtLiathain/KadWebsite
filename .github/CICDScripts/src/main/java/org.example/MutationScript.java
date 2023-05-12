import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.lang.Math.*;

public class MutationScript {
  public static void main(String[] args) {
    try {
      String filePath = "../../app/build/reports/pitest/debug/mutations.xml";
      File file = new File(filePath);
      JAXBContext jaxbContext = JAXBContext.newInstance(Mutations.class);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Mutations mut = (Mutations) jaxbUnmarshaller.unmarshal(file);

      List<mutation> list = mut.getMutationList();
      int amount = list.size();
      int sum = 0;
      int noCoverage = 0;
      for (mutation mutant : list) {
        if (mutant.getDetected().equals("true")) {
          sum++;
        }
        if(mutant.getStatus().equals("NO_COVERAGE")){
          noCoverage++;
        }
      }
      double coverage =  (sum / (double)amount) * 100;
      double strength = (sum/((double)amount-noCoverage))*100;
      System.out.println("Coverage:"+Math.round(coverage) + "%");
      System.out.println("Strength: " + Math.round(strength) + "%");
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }
}
