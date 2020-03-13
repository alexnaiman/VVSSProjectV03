import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.XMLFileRepository.StudentXMLRepo;
import VVSSProjectV03MV.Service.XMLFileService.StudentXMLService;
import VVSSProjectV03MV.Validator.StudentValidator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestAddStudent {

    @Test
    public void testAddStudentValidInput() throws ValidatorException {

        StudentValidator vs = new StudentValidator();
        StudentXMLRepo strepo = new StudentXMLRepo(vs, "StudentiXML.xml");
        StudentXMLService stsrv = new StudentXMLService(strepo);
        String[] params = {"1", "Alexandru", "935", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"};
        stsrv.add(params);
        assertEquals(strepo.size(), 1);
    }

    @Test
    public void testAddStudentInvalidGroupInput() {

        StudentValidator vs = new StudentValidator();
        StudentXMLRepo strepo = new StudentXMLRepo(vs, "StudentiXML.xml");
        StudentXMLService stsrv = new StudentXMLService(strepo);
        String[] params = {"1", "Alexandru", "93a", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"};
        try {
            stsrv.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {

        }
    }
}