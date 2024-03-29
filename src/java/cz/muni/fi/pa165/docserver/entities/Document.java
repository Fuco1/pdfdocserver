/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Matus
 */
@Entity
@NamedQueries({@NamedQuery(name = "getDocumentsByUserId",
                           query = "SELECT d FROM Document d WHERE d.author.id = ?1 ORDER BY d.title ASC"),
               @NamedQuery(name = "getDocumentCountByUserId",
                           query = "SELECT count(d) FROM Document d WHERE d.author.id = ?1"),
               @NamedQuery(name = "getDocumentsByUserIdDate",
                           query = "SELECT d FROM Document d WHERE d.author.id = ?1 ORDER BY d.creationDate ASC"),
               @NamedQuery(name = "getVisible",
                           query = "SELECT d FROM Document d WHERE d.author.id = ?1 OR d.isPublic = true ORDER BY d.title ASC"),
               @NamedQuery(name = "getVisibleByDate",
                           query = "SELECT d FROM Document d WHERE d.author.id = ?1 OR d.isPublic = true ORDER BY d.creationDate ASC"),
               @NamedQuery(name = "getVisibleCount",
                           query = "SELECT count(d) FROM Document d WHERE d.author.id = ?1 OR d.isPublic = true")
})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @OneToOne
    private User author;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creationDate;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Tag> tags;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<DocumentFile> files;
    private boolean isPublic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<DocumentFile> getFiles() {
        return files;
    }

    public void setFiles(List<DocumentFile> files) {
        this.files = files;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.muni.fi.pa165.docserver.entities.Document[id=" + id + "]";
    }
}
