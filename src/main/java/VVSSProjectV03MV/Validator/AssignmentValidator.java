package VVSSProjectV03MV.Validator;

import VVSSProjectV03MV.Domain.Assignment;
import VVSSProjectV03MV.Exceptions.ValidatorException;

public class AssignmentValidator implements IValidator<Assignment> {

    public void validate(Assignment assignment) throws ValidatorException {
        String errors = "";
        if (assignment.getId() == null || assignment.getId() <= 0) {
            errors += "Invalid assignment ID\n";
        }
        if (assignment.getDescription() == null || assignment.getDescription().equals("")) {
            errors += "Invalid description\n";
        }
        if (assignment.getStartline() <= 0 || assignment.getStartline() > 14) {
            errors += "Invalid startline\n";
        }
        if (assignment.getDeadline() <= 0 || assignment.getDeadline() > 14) {
            errors += "Invalid deadline\n";
        }
        if (errors.length() != 0) {
            throw new ValidatorException(errors);
        }
    }
}