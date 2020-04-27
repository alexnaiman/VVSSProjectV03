package VVSSProjectV03MV;

import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.XMLFileRepository.AssignmentXMLRepository;
import VVSSProjectV03MV.Service.XMLFileService.AssignmentXMLService;
import VVSSProjectV03MV.Validator.AssignmentValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestAddAssignment {

    private AssignmentXMLRepository repository;
    private AssignmentXMLService service;

    @Before
    public void setup() {
        AssignmentValidator validator = new AssignmentValidator();
        this.repository = new AssignmentXMLRepository(validator, "TemaLaboratorXML.xml");
        this.service = new AssignmentXMLService(repository);
    }

    @Test
    public void testAddAssignmentValidInput() throws ValidatorException {
        String[] params = {"6", "description", "8", "6"};
        this.service.add(params);
        assertEquals(this.repository.size(), 1);
    }

    @Test
    public void testAddAssignmentInvalidDescriptionInput()  {
        String[] params = {"1", "", "3", "2"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (ValidatorException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment1() {
        String[] params = {null, null, null, null};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment2() {
        String[] params = {"", "description", "8", "6"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment3() {
        String[] params = {"1", "", "8", "6"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment4() {
        String[] params = {"1", "description", "2", "0"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment5() {
        String[] params = {"1", "description", "15", "10"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment6() throws ValidatorException {
        String[] params = {"1", "description", "8", "6"};
        this.service.add(params);
        assertEquals(this.repository.size(), 1);
    }

    @Test
    public void testAddAssignment7() {
        String[] params = {"1", "description", "8", "6"};
        try {
            this.service.add(params);
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment8() {
        String[] params = {"5", "description", "0", "2"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment9() {
        String[] params = {"6", "description", "8", "15"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}