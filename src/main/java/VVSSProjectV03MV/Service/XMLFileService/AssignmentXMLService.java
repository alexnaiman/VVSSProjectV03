package VVSSProjectV03MV.Service.XMLFileService;

import VVSSProjectV03MV.Domain.Assignment;
import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.XMLFileRepository.AssignmentXMLRepository;

public class AssignmentXMLService extends AbstractXMLService<Integer, Assignment> {
    private AssignmentXMLRepository xmlRepository;

    public AssignmentXMLService(AssignmentXMLRepository xmlRepository) {
        super(xmlRepository);
    }

    public void extendDeadline(String id,
                               String description,
                               String startline,
                               String deadline,
                               int current) {
        if (current <= Integer.parseInt(startline)) {
            String sln = Integer.toString(Integer.parseInt(deadline) + 1);
            String[] params = {id, description, sln, deadline};
            update(params);
        }

    }

    @Override
    protected Assignment extractEntity(String[] params) {
        return new Assignment(Integer.parseInt(params[0]),
                params[1],
                Integer.parseInt(params[2]),
                Integer.parseInt(params[3]));
    }
}