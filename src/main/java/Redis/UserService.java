package Redis;

public interface UserService {
    User save(User user);

    void delete(int id);

    User get(Integer id);
}
