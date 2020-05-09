package VVSSProjectV03MV;

import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.XMLFileRepository.*;
import VVSSProjectV03MV.Service.XMLFileService.*;
import VVSSProjectV03MV.Validator.GradeValidator;
import VVSSProjectV03MV.Validator.StudentValidator;
import VVSSProjectV03MV.Validator.AssignmentValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIntegration {

    private AssignmentXMLRepository temaLabXMLRepo;
    private AssignmentXMLService temaLabXMLService;

    private StudentXMLRepository studentXMLRepo;
    private StudentXMLService studentXMLService;

    private GradeXMLRepository notaXMLRepo;
    private GradeXMLService notaXMLService;

    @Before
    public void setup() {
        StudentValidator studentValidator = new StudentValidator();
        this.studentXMLRepo = new StudentXMLRepository(studentValidator, "StudentiXML.xml");
        this.studentXMLService = new StudentXMLService(this.studentXMLRepo);

        AssignmentValidator assignmentValidator = new AssignmentValidator();
        this.temaLabXMLRepo = new AssignmentXMLRepository(assignmentValidator, "TemaLaboratorXML.xml");
        this.temaLabXMLService = new AssignmentXMLService(this.temaLabXMLRepo);

        GradeValidator gradeValidator = new GradeValidator();
        this.notaXMLRepo = new GradeXMLRepository(gradeValidator, "NotaXML.xml");
        this.notaXMLService = new GradeXMLService(this.notaXMLRepo);
    }

    @Test
    public void testAddStudent() throws ValidatorException {

        String[] params = {"1", "Alexandru", "935", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"};
        this.studentXMLService.add(params);
        assertEquals(this.studentXMLRepo.size(), 1);
    }

    @Test
    public void testAddStudentAddAssignment() throws ValidatorException {

        String[] paramsStudent = {"1", "Alexandru", "935", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"};
        this.studentXMLService.add(paramsStudent);
        assertEquals(this.studentXMLRepo.size(), 1);

        String[] paramsAssignment = {"6", "description", "8", "6"};
        this.temaLabXMLService.add(paramsAssignment);
        assertEquals(this.temaLabXMLRepo.size(), 1);
    }

    @Test
    public void testAddStudentAddAssignmentAddGrade() throws ValidatorException {
        this.studentXMLService.add(new String[]{"1", "Alexandru", "935", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"});
        this.temaLabXMLService.add(new String[]{"6", "description", "8", "6"});
        this.notaXMLService.add(new String[]{"1", "6", "3", "10", "2018-11-03T12:05"});
        assertEquals(this.studentXMLRepo.size(), 1);
        assertEquals(this.temaLabXMLRepo.size(), 1);
        assertEquals(this.notaXMLRepo.size(), 1);
    }
}
