package put.io.testing.mocks;

import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;
import java.util.List;

public class AlternativeDatabase implements IFancyDatabase {

    @Override
    public void connect() {
        // Connection logic implementation
    }

    @Override
    public <T> void persist(T record) {
        // Persistence logic implementation
    }

    @Override
    public <T> List<T> queryAll() {
        // Returning an empty list as a placeholder
        return Collections.emptyList();
    }

    @Override
    public void close() {
        // Closing connection logic
    }
}

