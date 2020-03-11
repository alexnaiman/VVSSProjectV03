import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.XMLFileRepository.StudentXMLRepo;
import VVSSProjectV03MV.Service.XMLFileService.StudentXMLService;
import VVSSProjectV03MV.Validator.StudentValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAddStudent{

    @Test
    public void testAddStudent1() throws ValidatorException {

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        String[] params = {"1", "Alexandru", "935", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"};
        stsrv.add(params);
        Assertions.assertEquals(strepo.size(), 1);
    }

    @Test
    public void testAddStudent2() {

        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        String[] params = {"1", "Alexandru", "93a", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"};
        Assertions.assertThrows(ValidatorException.class, () -> stsrv.add(params));

    }
}