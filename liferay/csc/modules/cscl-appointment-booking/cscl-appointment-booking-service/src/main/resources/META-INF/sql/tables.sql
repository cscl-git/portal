create table cscl_appointee_master (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	designation VARCHAR(75) null,
	isActive BOOLEAN
);

create table cscl_appointment_master (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	mobile VARCHAR(10) null,
	address VARCHAR(500) null,
	appointee INTEGER,
	preferedDate DATE null,
	preferedTime VARCHAR(75) null,
	reason VARCHAR(500) null,
	refId VARCHAR(75) null,
	approver LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	appointedDate DATE null,
	appointedTime VARCHAR(75) null,
	comment_ VARCHAR(150) null
);

create table cscl_approver_mapping (
	id_ LONG not null primary key,
	appointee INTEGER,
	approver VARCHAR(75) null,
	assignedTo LONG,
	createdDate DATE null,
	modifiedDate DATE null
);

create table cscl_approver_master (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	appointee VARCHAR(75) null,
	userId LONG,
	isActive BOOLEAN
);

create table cscl_status (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	value VARCHAR(75) null,
	isActive BOOLEAN
);