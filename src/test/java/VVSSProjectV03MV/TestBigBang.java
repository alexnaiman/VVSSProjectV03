package VVSSProjectV03MV;

import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.XMLFileRepository.NotaXMLRepo;
import VVSSProjectV03MV.Repository.XMLFileRepository.StudentXMLRepo;
import VVSSProjectV03MV.Repository.XMLFileRepository.TemaLabXMLRepo;
import VVSSProjectV03MV.Service.XMLFileService.NotaXMLService;
import VVSSProjectV03MV.Service.XMLFileService.StudentXMLService;
import VVSSProjectV03MV.Service.XMLFileService.TemaLabXMLService;
import VVSSProjectV03MV.Validator.NotaValidator;
import VVSSProjectV03MV.Validator.StudentValidator;
import VVSSProjectV03MV.Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBigBang {

    private TemaLabXMLRepo temaLabXMLRepo;
    private TemaLabXMLService temaLabXMLService;

    private StudentXMLRepo studentXMLRepo;
    private StudentXMLService studentXMLService;

    private NotaXMLRepo notaXMLRepo;
    private NotaXMLService notaXMLService;

    @Before
    public void setup() {
        StudentValidator studentValidator = new StudentValidator();
        this.studentXMLRepo = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        this.studentXMLService = new StudentXMLService(this.studentXMLRepo);

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        this.temaLabXMLRepo = new TemaLabXMLRepo(temaLabValidator, "TemaLaboratorXML.xml");
        this.temaLabXMLService = new TemaLabXMLService(this.temaLabXMLRepo);

        NotaValidator notaValidator = new NotaValidator();
        this.notaXMLRepo = new NotaXMLRepo(notaValidator, "NotaXML.xml");
        this.notaXMLService = new NotaXMLService(this.notaXMLRepo);
    }

    @Test
    public void testAddStudent() throws ValidatorException {

        String[] params = {"1", "Alexandru", "935", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"};
        this.studentXMLService.add(params);
        assertEquals(this.studentXMLRepo.size(), 1);
    }

    @Test
    public void testAddAssignment() throws ValidatorException {

        String[] params = {"6", "description", "8", "6"};
        this.temaLabXMLService.add(params);
        assertEquals(this.temaLabXMLRepo.size(), 1);
    }

    @Test
    public void testAddGrade() throws ValidatorException {
        this.studentXMLService.add(new String[]{"1", "Alexandru", "935", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"});
        this.temaLabXMLService.add(new String[]{"6", "description", "8", "6"});
        String[] params = {"1", "6", "3", "10", "2018-11-03T12:05"};
        this.notaXMLService.add(params);
        assertEquals(this.temaLabXMLRepo.size(), 1);
    }

    @Test
    public void testBigBang() throws ValidatorException {
        this.studentXMLService.add(new String[]{"1", "Alexandru", "935", "naie2371@scs.ubbcluj.ro", "Lorincz Beata"});
        this.temaLabXMLService.add(new String[]{"6", "description", "8", "6"});
        this.notaXMLService.add(new String[] {"1", "6", "3", "10", "2018-11-03T12:05"});
        assertEquals(this.studentXMLRepo.size(), 1);
        assertEquals(this.temaLabXMLRepo.size(), 1);
        assertEquals(this.notaXMLRepo.size(), 1);
    }
}
