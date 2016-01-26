/**
 * A single file or folder with basic properties
 */
package fileExplorer;

import java.nio.file.attribute.FileTime;


/**
 * @author Joey
 *
 */
public class FileSystemObject {
private String file_name,file_type,file_path;
private FileTime created,modified;
private long size;
private boolean is_folder;
/**
 * @return the file_name
 */
public String getFile_name() {
	return file_name;
}
/**
 * @param file_name the file_name to set
 */
public void setFile_name(String file_name) {
	this.file_name = file_name;
}
/**
 * @return the file_type
 */
public String getFile_type() {
	return file_type;
}
/**
 * @param file_type the file_type to set
 */
public void setFile_type(String file_type) {
	this.file_type = file_type;
}
/**
 * @return the file_path
 */
public String getFile_path() {
	return file_path;
}
/**
 * @param file_path the file_path to set
 */
public void setFile_path(String file_path) {
	this.file_path = file_path;
}
/**
 * @return the size
 */
public long getSize() {
	return size;
}
/**
 * @param size the size to set
 */
public void setSize(long size) {
	this.size = size;
}
/**
 * @return the is_folder
 */
public boolean isIs_folder() {
	return is_folder;
}
/**
 * @param is_folder the is_folder to set
 */
public void setIs_folder(boolean is_folder) {
	this.is_folder = is_folder;
}
/**
 * @return the created
 */
public FileTime getCreated() {
	return created;
}
/**
 * @param created the created to set
 */
public void setCreated(FileTime created) {
	this.created = created;
}
/**
 * @return the modified
 */
public FileTime getModified() {
	return modified;
}
/**
 * @param modified the modified to set
 */
public void setModified(FileTime modified) {
	this.modified = modified;
}
}
