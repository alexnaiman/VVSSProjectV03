package VVSSProjectV03MV.Repository.TxtFileRepository;

import VVSSProjectV03MV.Domain.HasId;
import VVSSProjectV03MV.Domain.Assignment;
import VVSSProjectV03MV.Validator.AssignmentValidator;

import java.io.*;

public class AssignmentFileRepository extends AbstractFileRepository {
    public AssignmentFileRepository(String filename, AssignmentValidator validator) throws IOException {
        super(validator, filename);
    }

    @Override
    public HasId extractEntity(String[] info) {
        int id = Integer.parseInt(info[0]);
        String description = info[1];
        int deadline = Integer.parseInt(info[2]);
        int startline = Integer.parseInt(info[3]);
        return new Assignment(id, description, deadline, startline);
    }
}