create table cscl_search (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(500) null,
	keywords VARCHAR(200) null,
	link VARCHAR(200) null,
	status INTEGER,
	createdById LONG,
	updatedById LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);