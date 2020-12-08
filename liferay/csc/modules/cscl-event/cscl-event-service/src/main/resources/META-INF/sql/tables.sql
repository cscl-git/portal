create table cscl_event (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	createdById LONG,
	updatedById LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title STRING null,
	description STRING null,
	startDate DATE null,
	endDate DATE null,
	status INTEGER
);