package com.example.RestClient.models;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Collaborator")
public class CollaboratorRp2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String first_name;
	private String last_name;
	private String email;
	private Date create_date;
	private Date start_date;
	private Date close_date;
	private Evaluation evaluation;
	private String pdf_report_url;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getClose_date() {
		return close_date;
	}
	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public String getPdf_report_url() {
		return pdf_report_url;
	}
	public void setPdf_report_url(String pdf_report_url) {
		this.pdf_report_url = pdf_report_url;
	}
	@Override
	public String toString() {
		return "CollaboratorRp2 [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", create_date=" + create_date + ", start_date=" + start_date + ", close_date=" + close_date
				+ ", evaluation=" + evaluation + ", urlPdf=" + pdf_report_url + "]";
	}
	
}
