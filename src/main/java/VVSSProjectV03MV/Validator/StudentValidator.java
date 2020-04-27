package VVSSProjectV03MV.Validator;

import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Domain.Student;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student student) throws ValidatorException {
        String errors = "";
        if (student.getId() <= 0) {
            errors += "Invalid ID\n";
        }
        if (student.getName() == null
                || student.getName().equals("")
                || student.getName().matches(".*\\d.*")) {
            errors += "Invalid name\n";
        }
        if (student.getGroup() < 100 || student.getGroup() > 999) {
            errors += "Invalid group\n";
        }
        if (student.getEmail() == null || student.getEmail().equals("")) {
            errors += "Invalid email\n";
        }
        if (student.getTeacher() == null
                || student.getTeacher().equals("")
                || student.getTeacher().matches(".*\\d.*")) {
            errors += "Invalid teacher name\n";
        }
        if (errors.length() != 0) {
            throw new ValidatorException(errors);
        }
    }
}