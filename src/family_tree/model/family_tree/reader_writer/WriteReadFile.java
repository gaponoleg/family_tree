package family_tree.model.family_tree.reader_writer;


import java.io.*;

public class WriteReadFile implements WriteRead{
    @Override
    public boolean save(Serializable serializable, String fileWay) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileWay))){
            objectOutputStream.writeObject(serializable);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String fileWay) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileWay))){
            return objectInputStream.readObject();
        }catch (Exception e){
         e.printStackTrace();
         return null;
        }
    }
}

