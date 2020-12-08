create table cscl_feedback (
	uuid_ VARCHAR(75) null,
	feedbackId LONG not null primary key,
	createdById LONG,
	createDate DATE null,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	mobile VARCHAR(10) null,
	comments VARCHAR(500) null
);