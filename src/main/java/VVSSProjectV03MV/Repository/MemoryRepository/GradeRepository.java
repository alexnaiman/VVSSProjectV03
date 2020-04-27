package VVSSProjectV03MV.Repository.MemoryRepository;

import VVSSProjectV03MV.Validator.IValidator;
import VVSSProjectV03MV.Domain.Grade;

public class GradeRepository extends AbstractCrudRepository<Integer, Grade> {
    public GradeRepository(IValidator<Grade> v) {
        super(v);
    }
}