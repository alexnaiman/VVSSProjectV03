package VVSSProjectV03MV.Repository.XMLFileRepository;

import VVSSProjectV03MV.Domain.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import VVSSProjectV03MV.Validator.StudentValidator;


public class StudentXMLRepository extends AbstractXMLRepository<Integer, Student> {

    public StudentXMLRepository(StudentValidator v, String fileName) {
        super(v, fileName);
    }

    @Override
    protected Element createElementFromEntity(Document document, Student s) {
        Element root = document.getDocumentElement();
        Element e = document.createElement("student");
        e.appendChild(createElement("id", document, Integer.toString(s.getId())));
        e.appendChild(createElement("name", document, s.getName()));
        e.appendChild(createElement("group", document, Integer.toString(s.getGroup())));
        e.appendChild(createElement("email", document, s.getEmail()));
        e.appendChild(createElement("teacher", document, s.getTeacher()));
        return e;
    }


    @Override
    protected Student createEntityFromElement(Element studentElement) {
        int id = Integer.parseInt(studentElement
                .getAttribute("id"));
        String name = studentElement
                .getElementsByTagName("name")
                .item(0)
                .getTextContent();
        int group = Integer.parseInt(studentElement
                .getElementsByTagName("group")
                .item(0)
                .getTextContent());
        String email = studentElement
                .getElementsByTagName("email")
                .item(0)
                .getTextContent();
        String teacher = studentElement
                .getElementsByTagName("teacher")
                .item(0)
                .getTextContent();
        return new Student(id, name, group, email, teacher);
    }
}