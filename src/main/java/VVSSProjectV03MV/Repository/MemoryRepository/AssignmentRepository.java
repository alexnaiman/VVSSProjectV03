package VVSSProjectV03MV.Repository.MemoryRepository;

import VVSSProjectV03MV.Validator.IValidator;
import VVSSProjectV03MV.Domain.Assignment;

public class AssignmentRepository extends AbstractCrudRepository<Integer, Assignment> {

    public AssignmentRepository(IValidator<Assignment> v) {

        super(v);
    }

    public void changeDeadline(Assignment assignment, int startline) {
        if (startline <= assignment.getDeadline()) {
            assignment.setDeadline(assignment.getDeadline() + 1);
            update(assignment);
        }
    }

}