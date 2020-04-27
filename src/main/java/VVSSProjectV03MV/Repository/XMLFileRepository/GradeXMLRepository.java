package VVSSProjectV03MV.Repository.XMLFileRepository;

import VVSSProjectV03MV.Domain.Grade;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import VVSSProjectV03MV.Validator.GradeValidator;

import java.time.LocalDateTime;


public class GradeXMLRepository extends AbstractXMLRepository<Integer, Grade> {

    public GradeXMLRepository(GradeValidator v, String fileName) {
        super(v, fileName);
    }

    @Override
    protected Element createElementFromEntity(Document document, Grade grade) {
        Element root = document.getDocumentElement();
        Element e = document.createElement("grade");
        e.appendChild(createElement("id", document, grade.getId().toString()));
        e.appendChild(createElement("studentID", document, grade.getStudentId().toString()));
        e.appendChild(createElement("assignmentID", document, Integer.toString(grade.getAssignmentId())));
        e.appendChild(createElement("value", document, Double.toString(grade.getValue())));
        e.appendChild(createElement("date", document, grade.getLdt().toString()));
        return e;
    }


    @Override
    protected Grade createEntityFromElement(Element gradeElement) {
        String id = gradeElement.getAttribute("id");
        String studentID = gradeElement
                .getElementsByTagName("studentID")
                .item(0)
                .getTextContent();
        String assignmentID = gradeElement
                .getElementsByTagName("assignmentID")
                .item(0)
                .getTextContent();
        String value = gradeElement
                .getElementsByTagName("value")
                .item(0)
                .getTextContent();
        String date = gradeElement
                .getElementsByTagName("date")
                .item(0)
                .getTextContent();

        return new Grade(Integer.parseInt(id),
                Integer.parseInt(studentID),
                Integer.parseInt(assignmentID),
                Double.parseDouble(value),
                LocalDateTime.parse(date));
    }
}