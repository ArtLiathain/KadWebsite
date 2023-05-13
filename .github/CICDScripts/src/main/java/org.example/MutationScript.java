import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.lang.Math.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class MutationScript {
  private int getMutationCoverage(){
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
      double strength = (sum/((double)amount-noCoverage))*100;


      return (int) Math.round(strength);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return 0;
  }





  public static void main(String[] args) {
    MutationScript mutationScript = new MutationScript();
    int strength = mutationScript.getMutationCoverage();
    String fileName;
    System.out.println(strength);
    if(strength < 35){
      fileName = "Red_Circle.svg";
    }
    else if (strength < 80){
      fileName = "Amber_Circle.svg";
    }
    else {
      fileName = "Green_Circle.svg";
    }

    File sourceFile = new File("Images/" + fileName);
    File destinationFile = new File("Images/Current_Image.svg");

    try {
      Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
