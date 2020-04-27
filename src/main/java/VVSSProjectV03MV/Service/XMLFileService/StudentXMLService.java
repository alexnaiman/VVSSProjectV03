package VVSSProjectV03MV.Service.XMLFileService;

import VVSSProjectV03MV.Domain.Student;
import VVSSProjectV03MV.Repository.XMLFileRepository.StudentXMLRepository;

public class StudentXMLService extends AbstractXMLService<Integer, Student> {
    private StudentXMLRepository xmlRepository;

    public StudentXMLService(StudentXMLRepository xmlRepository) {
        super(xmlRepository);
    }

    @Override
    protected Student extractEntity(String[] params) {
        int group = 0;
        int id = 0;
        try {
            id = Integer.parseInt(params[0]);
            group = Integer.parseInt(params[2]);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        return new Student(id, params[1], group, params[3], params[4]);
    }
}