package CSCI485ClassProject;

import CSCI485ClassProject.models.ComparisonOperator;
import CSCI485ClassProject.models.Record;

import java.util.ArrayList;

import com.apple.foundationdb.Database;
import com.apple.foundationdb.FDB;
import com.apple.foundationdb.FDBException;
import com.apple.foundationdb.KeyValue;
import com.apple.foundationdb.Range;
import com.apple.foundationdb.Transaction;
import com.apple.foundationdb.directory.DirectoryLayer;
import com.apple.foundationdb.directory.DirectorySubspace;
import com.apple.foundationdb.subspace.Subspace;
import com.apple.foundationdb.tuple.Tuple;
public class RecordsImpl implements Records{

  private Database db;
  @Override
  public StatusCode insertRecord(String tableName, String[] primaryKeys, Object[] primaryKeysValues, String[] attrNames, Object[] attrValues) {
    Transaction tr = db.createTransaction();
      // Get table's subspace
      ArrayList<String> path = new ArrayList();
      path.add(tableName);
      DirectorySubspace tableSubspace = FDBHelper.openSubspace(tr,path);
      
      // Create a tuple with primary keys
      Tuple primaryKeyTuple = new Tuple();
      for(int i =0; i<primaryKeysValues.length; i++){
        primaryKeyTuple = primaryKeyTuple.addObject(primaryKeysValues[i]);
      }
      
      // Check if the record exists
      byte[] recordKey = Tuple.from(tableName, primaryKeyTuple).pack();
      byte[] existingRecord = tr.get(recordKey).join();
      
      if(existingRecord != null) {
          return StatusCode.DATA_RECORD_CREATION_RECORD_ALREADY_EXISTS;
      }
      
      // Create a tuple with attribute values
      Tuple attrTuple = new Tuple();
      for(int i = 0; i<attrValues.length; i++){
        attrTuple = attrTuple.addObject(attrValues[i]);
      }
      
      // Create a tuple with attribute names
      Tuple attrNameTuple = new Tuple();
      for(int i = 0; i <attrNames.length; i++){
        attrNameTuple = attrNameTuple.add(attrNames[i]);
      }
      
      // Pack the tuple of attribute names and values
      for(int i = 0; i<attrValues.length; i++){
        attrNameTuple = attrNameTuple.addObject(attrValues[i]);
      }
      //byte[] packedAttrs = attrNameTuple.packWithValues(attrTuple);
      
      // Pack the primary keys tuple and the packed attributes tuple
      //byte[] packedRecord = primaryKeyTuple.packWithValues(packedAttrs);
      
      // Insert the record into the database
      tr.set(recordKey, attrNameTuple.pack());
      
      // Commit the transaction
      tr.commit().join();
      
      return StatusCode.SUCCESS;
  }

  @Override
  public Cursor openCursor(String tableName, String attrName, Object attrValue, ComparisonOperator operator, Cursor.Mode mode, boolean isUsingIndex) {
    return null;
  }

  @Override
  public Cursor openCursor(String tableName, Cursor.Mode mode) {
    return null;
  }

  @Override
  public Record getFirst(Cursor cursor) {
    return null;
  }

  @Override
  public Record getLast(Cursor cursor) {
    return null;
  }

  @Override
  public Record getNext(Cursor cursor) {
    return null;
  }

  @Override
  public Record getPrevious(Cursor cursor) {
    return null;
  }

  @Override
  public StatusCode updateRecord(Cursor cursor, String[] attrNames, Object[] attrValues) {
    return null;
  }

  @Override
  public StatusCode deleteRecord(Cursor cursor) {
    return null;
  }

  @Override
  public StatusCode commitCursor(Cursor cursor) {
    return null;
  }

  @Override
  public StatusCode abortCursor(Cursor cursor) {
    return null;
  }

  @Override
  public StatusCode deleteDataRecord(String tableName, String[] attrNames, Object[] attrValues) {
    return null;
  }
}
