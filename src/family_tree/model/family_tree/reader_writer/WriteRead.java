
package family_tree.model.family_tree.reader_writer;

import java.io.*;

public interface WriteRead {
    public boolean save(Serializable serializable, String fileWay);
    public Object read(String fileWay);
}
