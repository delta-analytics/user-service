package deltaanalytics.user.repository;


import deltaanalytics.user.entity.User;

public class UserRepository extends UserDataRepository<User> {
    @Override
    public boolean exists(User entity) {
        return read(entity.getId()) != null;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    public boolean exists(String account, String password) {
        String query = "Select count(*) from " + getEntityClass().getSimpleName() + " t " +
                "WHERE t.account='" + account + "' AND t.password='" + password +"'";
        return (long)selectForSingleResult(query) == 1;
    }

}
