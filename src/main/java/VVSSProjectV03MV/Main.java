package VVSSProjectV03MV;

import VVSSProjectV03MV.Repository.XMLFileRepository.*;
import VVSSProjectV03MV.Service.XMLFileService.*;
import VVSSProjectV03MV.UI.ui;
import VVSSProjectV03MV.Validator.*;

public class Main {
    public static void main(String[] args) {
        StudentValidator studentValidator = new StudentValidator();
        AssignmentValidator assignmentValidator = new AssignmentValidator();
        GradeValidator gradeValidator = new GradeValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "StudentiXML.xml");
        AssignmentXMLRepository assignmentXMLRepository = new AssignmentXMLRepository(assignmentValidator, "TemaLaboratorXML.xml");
        GradeXMLRepository gradeXMLRepository = new GradeXMLRepository(gradeValidator, "NotaXML.xml");
        StudentXMLService studentXMLService = new StudentXMLService(studentXMLRepository);
        AssignmentXMLService assignmentXMLService = new AssignmentXMLService(assignmentXMLRepository);
        GradeXMLService gradeXMLService = new GradeXMLService(gradeXMLRepository);
        ui ui = new ui(studentXMLService, assignmentXMLService, gradeXMLService);
        ui.run();
    }
}