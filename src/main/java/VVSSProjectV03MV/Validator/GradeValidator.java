package VVSSProjectV03MV.Validator;

import VVSSProjectV03MV.Domain.Grade;
import VVSSProjectV03MV.Exceptions.ValidatorException;

public class GradeValidator implements IValidator<Grade> {

    public void validate(Grade grade) throws ValidatorException {
        String errors = "";
        if (grade.getId() <= 0) {
            errors += "Invalid ID\n";
        }
        if (grade.getStudentId() == null || grade.getStudentId() <= 0) {
            errors += "Invalid student ID\n";
        }
        if (grade.getAssignmentId() == null || grade.getAssignmentId() <= 0) {
            errors += "Invalid assignment ID\n";
        }
        if (grade.getValue() <= 0 || grade.getValue() > 10) {
            errors += "Invalid grade value\n";
        }
        if (errors.length() != 0) {
            throw new ValidatorException(errors);
        }
    }
}