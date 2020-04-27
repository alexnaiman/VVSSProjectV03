package VVSSProjectV03MV.Repository.TxtFileRepository;

import VVSSProjectV03MV.Domain.HasId;
import VVSSProjectV03MV.Domain.Grade;
import VVSSProjectV03MV.Validator.GradeValidator;

import java.io.*;
import java.time.LocalDateTime;

public class GradeFileRepository extends AbstractFileRepository {
    public GradeFileRepository(String filename, GradeValidator validator) {
        super(validator, filename);
    }

    @Override
    public HasId extractEntity(String[] info) {
        Integer gradeID = Integer.parseInt(info[0]);
        Integer studentID = Integer.parseInt(info[1]);
        Integer assignmentID = Integer.parseInt(info[2]);
        double value = Double.parseDouble(info[3]);
        LocalDateTime ldt = LocalDateTime.parse(info[4]);
        return new Grade(gradeID, studentID, assignmentID, value, ldt);
    }
}