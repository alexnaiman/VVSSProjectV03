package VVSSProjectV03MV.Repository.MemoryRepository;
import VVSSProjectV03MV.Validator.IValidator;
import VVSSProjectV03MV.Domain.Student;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}