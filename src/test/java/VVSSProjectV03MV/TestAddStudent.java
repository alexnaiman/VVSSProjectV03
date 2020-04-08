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

    @Test
    public void testAddStudent1() throws ValidatorException {
        String[] params = {"1", "Alexandra", "935", "naie2377", "Andreea Vescan"};
        this.service.add(params);
        assertEquals(this.repository.size(), 1);
    }

    @Test
    public void testAddStudent2() {
        String[] params = {"1", "Alexandra", "935", "naie2377", "Andreea Vescan"};
        try {
            this.service.add(new String[]{"1", "Alexandra", "935", "naie2377", "Andreea Vescan"});
            this.service.add(new String[]{"1", "Alexandru", "935", "naie2371", "Andreea Vescan"});
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudent3() {
        String[] params = {"", "Alexandra", "935", "naie2377", "Andreea Vescan"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudent4() {
        String[] params = {"2", "Alexandra2", "935", "naie2377", "Andreea Vescan"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudent5() {
        String[] params = {"3", "", "935", "naie2377", "Andreea Vescan"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudent6() {
        String[] params = {"4", "Alexandra", "", "naie2377", "Andreea Vescan"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudent7() {
        String[] params = {"5", "Alexandra", "935.2", "naie2377", "Andreea Vescan"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudent8() {
        String[] params = {"6", "Alexandra", "99", "naie2377", "Andreea Vescan"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudent9() {
        String[] params = {"7", "Alexandra", "1000", "naie2377", "Andreea Vescan"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudent10() {
        String[] params = {"8", "Alexandra", "935", "", "Andreea Vescan"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudent11() {
        String[] params = {"9", "Alexandra", "935", "naie2377", "Andreea Vescan2"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudent12() {
        String[] params = {"10", "Alexandra", "935", "naie2377", ""};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }
}