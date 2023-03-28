package CSCI485ClassProject;

import CSCI485ClassProject.models.ComparisonOperator;
import CSCI485ClassProject.models.Record;

public class RecordsImpl implements Records{

  @Override
  public StatusCode insertRecord(String tableName, String[] primaryKeys, Object[] primaryKeysValues, String[] attrNames, Object[] attrValues) {
    Transaction tr = db.createTransaction();
      // Get table's subspace
      byte[] tableSubspace = tr.getDatabase().openSync(tableName.getBytes()).join();
      
      // Create a tuple with primary keys
      Tuple primaryKeyTuple = Tuple.fromArray(primaryKeysValues);
      
      // Check if the record exists
      byte[] recordKey = Tuple.from(tableName, primaryKeyTuple).pack();
      byte[] existingRecord = tr.get(recordKey).join();
      
      if(existingRecord != null) {
          return StatusCode.RECORD_ALREADY_EXISTS;
      }
      
      // Create a tuple with attribute values
      Tuple attrTuple = Tuple.fromArray(attrValues);
      
      // Create a tuple with attribute names
      Tuple attrNameTuple = Tuple.fromArray(attrNames);
      
      // Pack the tuple of attribute names and values
      for(int i = 0; i<attrValues.length; i++){
        attrNameTuple = attrNameTuple.add(attrValues[i]);
      }
      //byte[] packedAttrs = attrNameTuple.packWithValues(attrTuple);
      
      // Pack the primary keys tuple and the packed attributes tuple
      //byte[] packedRecord = primaryKeyTuple.packWithValues(packedAttrs);
      
      // Insert the record into the database
      tr.set(recordKey, attrNameTuple.pack());
      
      // Commit the transaction
      tr.commit().join();
      
      return StatusCode.OK;
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
