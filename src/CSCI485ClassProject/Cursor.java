package CSCI485ClassProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import CSCI485ClassProject.StatusCode;


import CSCI485ClassProject.models.Record;

public class Cursor {
  // private List<Record> records;
  // private int index;
  // private boolean isReadWrite;

  public enum Mode {
    READ, READ_WRITE
  };

//   public Cursor(List<Record> records, Mode mode) {
//     this.records = records;
//     if (mode == Mode.READ) {
//       this.isReadWrite = false;
//     } else {
//       this.isReadWrite = true;
//     }
//     this.index = -1;
//   }

//   public boolean isReadWrite() {
//     return this.isReadWrite;
//   }

//   public StatusCode seek(Record record) {
//     int newIndex = Collections.binarySearch(records, record);
//     if (newIndex < 0) {
//       return StatusCode.KEY_NOT_FOUND;
//     }
//     index = newIndex;
//     return StatusCode.OK;
//   }

//   public StatusCode getFirst() {
//     if (records.isEmpty()) {
//       return StatusCode.EOF;
//     }
//     index = 0;
//     return StatusCode.OK;
//   }

//   public StatusCode getLast() {
//     if (records.isEmpty()) {
//       return StatusCode.EOF;
//     }
//     index = records.size() - 1;
//     return StatusCode.OK;
//   }

//   public Record getNext() {
//     if (index == records.size() - 1) {
//       return null;
//     }
//     index++;
//     return records.get(index);
//   }

//   public Record getPrevious() {
//     if (index == 0) {
//       return null;
//     }
//     index--;
//     return records.get(index);
//   }

//   public Record getCurrent() {
//     if (index < 0 || index >= records.size()) {
//       return null;
//     }
//     return records.get(index);
//   }

//   public StatusCode updateCurrent(Record newRecord) {
//     if (!isReadWrite) {
//       return StatusCode.CURSOR_NOT_IN_READ_WRITE_MODE;
//     }
//     if (index < 0 || index >= records.size()) {
//       return StatusCode.CURSOR_NOT_INITIALIZED;
//     }
//     records.set(index, newRecord);
//     return StatusCode.OK;
//   }

//   public StatusCode deleteCurrent() {
//     if (!isReadWrite) {
//       return StatusCode.CURSOR_NOT_IN_READ_WRITE_MODE;
//     }
//     if (index < 0 || index >= records.size()) {
//       return StatusCode.CURSOR_NOT_INITIALIZED;
//     }
//     records.remove(index);
//     return StatusCode.OK;
//   }

//   public StatusCode commit() {
//     // TODO: commit changes to database
//     return StatusCode.OK;
//   }

//   public StatusCode abort() {
//     // TODO: discard changes
//     return StatusCode.OK;
//   }
 }
