package VVSSProjectV03MV.Validator;
import VVSSProjectV03MV.Exceptions.ValidatorException;
public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}