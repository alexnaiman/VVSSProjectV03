package VVSSProjectV03MV;

import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.XMLFileRepository.StudentXMLRepo;
import VVSSProjectV03MV.Service.XMLFileService.StudentXMLService;
import VVSSProjectV03MV.Validator.StudentValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestAddStudent {

    private StudentValidator validator;
    private StudentXMLRepo repository;
    private StudentXMLService service;

    @Before
    public void setup() {
        this.validator = new StudentValidator();
        this.repository = new StudentXMLRepo(validator, "StudentiXML.xml");
        this.service = new StudentXMLService(repository);
    }

    @Test
    public void testAddStudentValidInput() throws ValidatorException {

        String[] params = {"1", "Alexandru", "935", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"};
        this.service.add(params);
        assertEquals(this.repository.size(), 1);
    }

    @Test
    public void testAddStudentInvalidGroupInput() {

        String[] params = {"1", "Alexandru", "93a", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }
}