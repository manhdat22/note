package com.project.note.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Note")
public class Note {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	private long categoryId;

	private long userId;

	@ManyToOne
	@JoinColumn(name = "categoryId", insertable = false, updatable = false)
	private Category category;

	@ManyToOne
  @JoinColumn(name = "userId", insertable = false, updatable = false)
	private User user;

	private String title;

	@Lob
	private String content;

	private Date updatedAt;

	private Date createdAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getCategoryId() {
		return categoryId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return title;
	}
}
