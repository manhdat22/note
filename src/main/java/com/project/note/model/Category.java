package com.project.note.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {

  @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	private long userId;

	@ManyToOne
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private User user;

	@OneToMany(mappedBy = "categoryId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Note> notes;

	public List<Note> getNotes(){
		return notes;
	}

	private String title;

	private Date updatedAt;

	private Date createdAt;

  public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

  	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

    public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + "]";
	}
}
