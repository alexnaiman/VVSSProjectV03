package VVSSProjectV03MV.Repository.XMLFileRepository;

import VVSSProjectV03MV.Domain.Assignment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import VVSSProjectV03MV.Validator.AssignmentValidator;


public class AssignmentXMLRepository extends AbstractXMLRepository<Integer, Assignment> {

    public AssignmentXMLRepository(AssignmentValidator v, String fileName) {
        super(v, fileName);
    }

    @Override
    protected Element createElementFromEntity(Document document, Assignment assignment) {
        Element root = document.getDocumentElement();
        Element e = document.createElement("assignment");
        e.appendChild(createElement("id", document, assignment.getId().toString()));
        e.appendChild(createElement("description", document, assignment.getDescription()));
        e.appendChild(createElement("deadline", document, Integer.toString(assignment.getDeadline())));
        e.appendChild(createElement("startline", document, Integer.toString(assignment.getStartline())));
        return e;
    }


    @Override
    protected Assignment createEntityFromElement(Element assignmentElement) {
        String id = assignmentElement.getAttribute("id");
        String description = assignmentElement
                .getElementsByTagName("description")
                .item(0)
                .getTextContent();
        String deadline = assignmentElement
                .getElementsByTagName("deadline")
                .item(0)
                .getTextContent();
        String startline = assignmentElement
                .getElementsByTagName("startline")
                .item(0)
                .getTextContent();

        return new Assignment(Integer.parseInt(id),
                description,
                Integer.parseInt(deadline),
                Integer.parseInt(startline));
    }
}