package VVSSProjectV03MV.Service.XMLFileService;

import VVSSProjectV03MV.Domain.*;
import VVSSProjectV03MV.Repository.XMLFileRepository.GradeXMLRepository;

import java.io.*;
import java.time.LocalDateTime;

public class GradeXMLService extends AbstractXMLService<Integer, Grade> {
    private GradeXMLRepository xmlRepository;

    public GradeXMLService(GradeXMLRepository xmlRepository) {
        super(xmlRepository);
    }

    public String changeGrade(AssignmentXMLService assignmentXMLService, String id, String value) {
        Assignment assignment = assignmentXMLService.findOne(Integer.parseInt(id));
        String newValue = Double.toString(
                Double.parseDouble(value) - (assignment.getStartline() - assignment.getDeadline()) * 2.5);
        return newValue;
    }

    public void printAllGrades(AssignmentXMLService srv) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("NoteStudenti.txt"));
        this.findAll().forEach(n -> {
            try {
                out.writeChars("Assignment: " + n.getAssignmentId() +
                        "\nGrade: " + n.getValue() +
                        "\nStartline: " + srv.findOne(n.getAssignmentId()).getStartline() +
                        "\nDeadline: " + srv.findOne(n.getAssignmentId()).getDeadline() +
                        "\nFeedback: Se putea si mai bine!\n\n\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    protected Grade extractEntity(String[] params) {
       return new Grade(Integer.parseInt(params[0]),
               Integer.parseInt(params[1]),
               Integer.parseInt(params[2]),
               Double.parseDouble(params[3]),
               LocalDateTime.parse(params[4]));
    }
}