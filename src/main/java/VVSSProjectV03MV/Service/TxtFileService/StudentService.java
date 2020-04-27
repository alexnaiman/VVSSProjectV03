package VVSSProjectV03MV.Service.TxtFileService;

import VVSSProjectV03MV.Domain.*;
import VVSSProjectV03MV.Repository.TxtFileRepository.StudentFileRepository;

public class StudentService extends AbstractService<Integer, Student> {
    public StudentService(StudentFileRepository studentFileRepository) {
        super(studentFileRepository);
    }
}