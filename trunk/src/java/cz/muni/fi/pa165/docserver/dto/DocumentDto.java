/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.dto;

import cz.muni.fi.pa165.docserver.entities.DocumentFile;
import cz.muni.fi.pa165.docserver.entities.Tag;
import cz.muni.fi.pa165.docserver.entities.User;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Matus
 */
public class DocumentDto implements Serializable {

    private static final long serialVersionUID = 2L;
    private Long id;
    private String title;
    private User author;
    private Date creationDate;
    private Tag[] tags;
    private String description;
    private DocumentFile[] files;
    private boolean isPublic;

    public DocumentDto() {
    }

    public DocumentDto(Long id, String title, User author, Date creationDate, Tag[] tags, String description, DocumentFile[] files, boolean isPublic) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.creationDate = creationDate;
        this.tags = tags;
        this.description = description;
        this.files = files;
        this.isPublic = isPublic;
    }

    public DocumentDto(Long id, String title, User author, Date creationDate, Tag[] tags, String description, List<DocumentFile> files, boolean aPublic) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DocumentFile[] getFiles() {
        return files;
    }

    public void setFiles(DocumentFile[] files) {
        this.files = files;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
