package deltaanalytics.user.repository;

public class CleanTestMemDB {
    public static void cleanUp() {
        new UserRepository().deleteAll();
    }
}
