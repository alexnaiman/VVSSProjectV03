package VVSSProjectV03MV.Repository.TxtFileRepository;

import VVSSProjectV03MV.Domain.HasId;
import VVSSProjectV03MV.Domain.Student;
import VVSSProjectV03MV.Validator.StudentValidator;

public class StudentFileRepository extends AbstractFileRepository {
    public StudentFileRepository(String filename, StudentValidator val)  {
        super(val, filename);
    }


    @Override
    public HasId extractEntity(String[] info) {
        Integer id = Integer.parseInt(info[0]);
        String name = info[1];
        int group = Integer.parseInt(info[2]);
        String email = info[3];
        String teacher = info[4];
        return new Student(id, name, group, email, teacher);
    }
}