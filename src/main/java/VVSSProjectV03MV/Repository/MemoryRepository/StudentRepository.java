package VVSSProjectV03MV.Repository.MemoryRepository;

import VVSSProjectV03MV.Validator.IValidator;
import VVSSProjectV03MV.Domain.Student;

public class StudentRepository extends AbstractCrudRepository<Integer, Student> {
    public StudentRepository(IValidator<Student> v) {
        super(v);
    }
}