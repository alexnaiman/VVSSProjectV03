package VVSSProjectV03MV;

import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.MemoryRepository.TemaLabRepo;
import VVSSProjectV03MV.Repository.XMLFileRepository.StudentXMLRepo;
import VVSSProjectV03MV.Repository.XMLFileRepository.TemaLabXMLRepo;
import VVSSProjectV03MV.Service.XMLFileService.StudentXMLService;
import VVSSProjectV03MV.Service.XMLFileService.TemaLabXMLService;
import VVSSProjectV03MV.Validator.StudentValidator;
import VVSSProjectV03MV.Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestAddAssignment {

    private TemaLabValidator validator;
    private TemaLabXMLRepo repository;
    private TemaLabXMLService service;

    @Before
    public void setup() {
        this.validator = new TemaLabValidator();
        this.repository = new TemaLabXMLRepo(validator, "TemaLaboratorXML.xml");
        this.service = new TemaLabXMLService(repository);
    }

    @Test
    public void testAddAssignmentValidInput() throws ValidatorException {

        String[] params = {"6", "description", "8", "6"};
        this.service.add(params);
        assertEquals(this.repository.size(), 1);
    }

    @Test
    public void testAddAssignmentInvalidIdInput() {
        String[] params = {"x", "homework-description", "3", "2"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
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
    public void testAddAssignment6() {
        String[] params = {"1", "description", "8", "6"};
        try {
            this.service.add(params);
//            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment7() {
        String[] params = {"2", "description", "8", "6"};
        try {
            this.service.add(params);
//            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment8() {
        String[] params = {"3", "description", "8", "6"};
        try {
            this.service.add(params);
//            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment9() {
        String[] params = {"4", "description", "8", "6"};
        try {
            this.service.add(params);
//            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment10() {
        String[] params = {"5", "description", "0", "2"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignment11() {
        String[] params = {"6", "description", "8", "15"};
        try {
            this.service.add(params);
            fail("Method didn't throw when it was expected to");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }


}